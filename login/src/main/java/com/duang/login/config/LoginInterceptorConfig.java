package com.duang.login.config;

import com.duang.login.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author duang
 * @date 2020-09-06
 * @Describe 登陆拦截器配置
 */
@Configuration
public class LoginInterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration = registry.addInterceptor(new LoginInterceptor());
        registration.addPathPatterns("/**");    //所有请求路径都拦截
        registration.excludePathPatterns(       //添加不拦截路径
                "/login.html",  //登陆页
                "/register.html",   //注册页
                "/404.html",    //404页
                "/**/*.js",     //所有js资源
                "/**/*.css",    //所有css资源
                "/login",    //释放login、register请求
                "/register"
        );
    }
}
