package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 扩展spring mvc功能
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    /**
     * 添加登录拦截器
     * @param registry
     */
  /*  @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html","/","login.html");
    }*/
}

