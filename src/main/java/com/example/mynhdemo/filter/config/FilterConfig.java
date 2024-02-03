package com.example.mynhdemo.filter.config;

/**
 * @ClassName：FilterConfig
 * @Author：Acmsdy
 * @Date：2023-12-23 13:32
 * @Describe：
 */
import com.example.mynhdemo.filter.AuthenticationFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class FilterConfig {

    /**
     * 注册自定义的filter过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean registrationBean(){
        log.info("******注册自定义的filter过滤器******");
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new AuthenticationFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setName("authenticationFilter");
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }
}
