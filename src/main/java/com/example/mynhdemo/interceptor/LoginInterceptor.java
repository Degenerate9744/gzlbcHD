package com.example.mynhdemo.interceptor;

import com.alibaba.fastjson.JSON;
import com.example.mynhdemo.common.util.Base64Util;
import com.example.mynhdemo.common.util.RedisUtil;
import com.example.mynhdemo.constant.ApiConstant;
import com.example.mynhdemo.constant.ApiResult;
import com.example.mynhdemo.constant.Constant;
import com.example.mynhdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    UserService userService;

    @Autowired
    RedisUtil redisUtil;
    /**
     * 在请求处理之前进行调用（Controller方法调用之前）
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        System.out.println("preHandle被调用");
        String url = request.getRequestURI();
        String token = request.getHeader("token");
        String clientType = request.getHeader("client_type");
        if(clientType == null || clientType.isEmpty()){
            clientType = Constant.CLIENT_TYPE_WEB;
        }
        String method = request.getMethod();
        // 查询验证token
        //这里特别坑，开启跨域之后，对于自定义header，第一次http请求为options嗅探，此时所有自定义header都会为null空指针，
        //第二次发送请求才为get/post，此时如果header为空的话，会自动转化为字符串“null”，注意这里的null是字符串不是null
        if (!method.equals("OPTIONS")) {
            if ( token != null && !token.isEmpty() && !token.equals("null")){
                String userId_tokenValue = null;   //前端传过来的token是经过base64混淆的
                try {
                    userId_tokenValue = Base64Util.decode(token);
                    if(userId_tokenValue.indexOf("-")!=-1){
                        String userId = userId_tokenValue.substring(0,userId_tokenValue.indexOf("-"));
                        String tokenValue = userId_tokenValue.substring(userId_tokenValue.indexOf("-")+1);
                        if(userService.checkToken(Integer.parseInt(userId),tokenValue,clientType)){
                            //token校验成功之后，更新token的超时时间
                            String tokenKey = "token:"+userId;
                            redisUtil.expire(tokenKey,Constant.TOKEN_EXPIRE_TIME);
                            //token校验成功后，将userid存储到request中，后续拦截器和控制器可以直接获取到userid
                            request.setAttribute("userId",userId);
                            return true;
                        }
                    }
                } catch (Exception e) {
//                    e.printStackTrace();
                }
            }
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            PrintWriter out = null;
            try {
                out = response.getWriter();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String json = JSON.toJSONString(ApiResult.fail(ApiConstant.RESULT_TOKEN_FAIL,"登录失效重新登录"));
            response.setContentType("application/json");
            // 返回json信息给前端
            out.append(json);
            out.flush();
            return false;
//            throw new TokenException("登录失效重新登录");         //此处不能使用自定义异常输出json给Vue前端
        }

        return true;


    }

    /**
     *
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        System.out.println("postHandle被调用");
    }

    /**
     * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        System.out.println("afterCompletion被调用");
    }
}

