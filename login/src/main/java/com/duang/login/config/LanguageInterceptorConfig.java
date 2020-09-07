package com.duang.login.config;

import com.duang.login.interceptor.LanguageInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author duang
 * @date 2020-09-06
 * @Describe 语言拦截器配置
 */
@Configuration
public class LanguageInterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration = registry.addInterceptor(new LanguageInterceptor());
        registration.addPathPatterns("/**");    //所有请求路径都拦截
    }
}
