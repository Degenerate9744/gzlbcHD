package com.example.mynhdemo.controller;

import com.example.mynhdemo.constant.ApiConstant;
import com.example.mynhdemo.constant.ApiResult;
import com.example.mynhdemo.entity.dto.UserDto;
import com.example.mynhdemo.entity.query.UserQuery;
import com.example.mynhdemo.entity.vo.UserVo;
import com.example.mynhdemo.service.PermissionRoleService;
import com.example.mynhdemo.service.PermissionService;
import com.example.mynhdemo.service.UserRoleService;
import com.example.mynhdemo.service.UserService;
import com.example.mynhdemo.util.LoginUtil;
import com.example.mynhdemo.entity.domain.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * @ClassName：LoginController
 * @Author：Acmsdy
 * @Date：2023-12-21 18:57
 * @Describe：
 */
@Controller
@RequestMapping("/login")
@Slf4j
public class LoginController {
    @Autowired
    private UserService service;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private PermissionRoleService permissionRoleService;
    @Autowired
    private PermissionService permissionService;

    @ResponseBody
    @RequestMapping("/apiLogin")
    public ApiResult<UserVo> apiLogin(@RequestBody @Validated UserQuery userQuery,@RequestHeader(value = "client_type",required = false,defaultValue = "web") String clientType) throws UnsupportedEncodingException {
        UserVo userVo = new UserVo();
        UserDto userDto = service.login(userQuery.getId());
        String token = service.generateToken(userDto.getId(), userQuery.getPassword(), clientType);
        System.out.println("----------------"+token);
        if(userDto != null){
            BeanUtils.copyProperties(userDto,userVo);
            userVo.setToken(token);
            return ApiResult.success(userVo);
        }
        return ApiResult.fail(ApiConstant.API_LOGIN_FAIL,"错误");
    }

    @RequestMapping("/verify_account_password")
    public String verifyAccountPassword(Integer id, String password, RedirectAttributes attributes){
        try{
            log.info("用户："+id+"进行登录");
            User user = service.selectByPrimaryKey(id);
            System.out.println("-------"+user.toString());
            if(password.equals(user.getPassword())){
                log.info("用户："+id+"登录成功");
                attributes.addAttribute("id",id);
                return "redirect:getRolePermission";
            }
        }catch (RuntimeException e){
            return "redirect:wrong";
        }
        return "redirect:wrong";
    }

    @RequestMapping("/getRolePermission")
    public String getRolePermission(@RequestParam(required = false) Integer id){
        try {
            if(id == null){
                for (Integer key : LoginRecord.urp.keySet()) {
                    UserRolePermission urp = LoginUtil.getUserRolePermission(userRoleService, permissionRoleService, permissionService, key);
                    LoginRecord.urp.put(key,urp);
                    log.info("用户："+key+"获取了权限");
                }
            }else {
                UserRolePermission urp = LoginUtil.getUserRolePermission(userRoleService,permissionRoleService,permissionService,id);
                LoginRecord.urp.put(id,urp);
                log.info("用户："+id+"获取了权限");
            }
            return "redirect:successful";
        }catch (RuntimeException e){
            return "redirect:wrong";
        }
    }
    @ResponseBody
    @RequestMapping("/wrong")
    public String wrong(){
        return "wrong";
    }
    @ResponseBody
    @RequestMapping("/successful")
    public String successful(){
        return "successful";
    }

    /*用来测试权限的方法*/
    @ResponseBody
    @RequestMapping("/url1")
    public Object url1(Integer id,HttpServletRequest request){
        //System.out.println(request.getHeader("User-Agent"));
        /*Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36 Edg/120.0.0.0*/
        if(LoginUtil.checkPermission(id, LoginUtil.getSuffix(request))){
            log.info("用户："+id+"访问了url1");
            return "访问url1的资源";
        }else {
            return new RedirectView("/login/wrong");
        }
    }
    @ResponseBody
    @RequestMapping("/url2")
    public Object url2(Integer id,HttpServletRequest request){
        if(LoginUtil.checkPermission(id,LoginUtil.getSuffix(request))){
            log.info("用户："+id+"访问了url2");
            return "访问url2的资源";
        }else {
            return new RedirectView("/login/wrong");
        }
    }
    @ResponseBody
    @RequestMapping("/url3")
    public Object url3(Integer id,HttpServletRequest request){
        if(LoginUtil.checkPermission(id,LoginUtil.getSuffix(request))){
            log.info("用户："+id+"访问了url3");
            return "访问url3的资源";
        }else {
            return new RedirectView("/login/wrong");
        }
    }
    @ResponseBody
    @RequestMapping("/url4")
    public Object url4(Integer id,HttpServletRequest request){
        if(LoginUtil.checkPermission(id,LoginUtil.getSuffix(request))){
            log.info("用户："+id+"访问了url4");
            return "访问url4的资源";
        }else {
            return new RedirectView("/login/wrong");
        }
    }
    @ResponseBody
    @RequestMapping("/url5")
    public Object url5(Integer id,HttpServletRequest request){
        if(LoginUtil.checkPermission(id,LoginUtil.getSuffix(request))){
            log.info("用户："+id+"访问了url5");
            return "访问url5的资源";
        }else {
            return new RedirectView("/login/wrong");
        }
    }
    @ResponseBody
    @RequestMapping("/url6")
    public Object url6(Integer id,HttpServletRequest request){
        if(LoginUtil.checkPermission(id,LoginUtil.getSuffix(request))){
            log.info("用户："+id+"访问了url6");
            return "访问url6的资源";
        }else {
            return new RedirectView("/login/wrong");
        }
    }
    @ResponseBody
    @RequestMapping("/url7")
    public Object url7(Integer id,HttpServletRequest request){
        if(LoginUtil.checkPermission(id,LoginUtil.getSuffix(request))){
            log.info("用户："+id+"访问了url7");
            return "访问url7的资源";
        }else {
            return new RedirectView("/login/wrong");
        }
    }
    @ResponseBody
    @RequestMapping("/url8")
    public Object url8(Integer id,HttpServletRequest request){
        if(LoginUtil.checkPermission(id,LoginUtil.getSuffix(request))){
            log.info("用户："+id+"访问了url8");
            return "访问url8的资源";
        }else {
            return new RedirectView("/login/wrong");
        }
    }
    //@ResponseBody
    //@RequestMapping("/test")
    //public void test(@Validated UserQuery userQuery){
    //    System.out.println("------------------test");
    //}
}
