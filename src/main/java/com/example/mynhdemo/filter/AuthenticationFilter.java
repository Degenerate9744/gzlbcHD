package com.example.mynhdemo.filter;

/**
 * @ClassName：AuthenticationFilter
 * @Author：Acmsdy
 * @Date：2023-12-23 13:27
 * @Describe：
 */
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class AuthenticationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("******Filter的init方法执行******");
    }

    /**
     * 过滤哪些请求可以放行，一般此方法中会写是否在登录有效期
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
        log.info("******Filter的doFilter方法执行******");
        try {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            // 检查用户权限
            if (checkPermissions(request)) {
                // 用户有权限，继续执行请求
                filterChain.doFilter(servletRequest,servletResponse);
                // 请求重定向到指定页面
                //response.sendRedirect("/new-page");
                // 请求转发到指定资源
                //RequestDispatcher dispatcher = request.getRequestDispatcher("/new-resource");
                //dispatcher.forward(request, response);
            } else {
                // 用户没有权限，返回错误信息或跳转到错误页面
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Denied");
            }
        } catch (Exception e) {
            log.error("doFilter 执行异常，异常信息 ： {}",e);
        }

    }

    @Override
    public void destroy() {
        log.info("******Filter的destroy方法执行******");
    }
    private boolean checkPermissions(HttpServletRequest request) {
        // 根据具体业务逻辑进行用户权限验证
        // 返回true表示有权限，返回false表示无权限
        // 示例中直接返回true，表示所有用户都有权限
        return true;
    }
}