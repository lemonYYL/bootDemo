package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

/**
 * 自定义视图解析器
 * @author yali yang
 */
@Configuration
public class MyViewResolver {

    @Bean
    public ViewResolver viewResolver(){
        return new InnerMyViewResolver();
    }

    private static class InnerMyViewResolver implements ViewResolver {

        @Override
        public View resolveViewName(String viewName, Locale locale) throws Exception {
            return null;
        }
    }
}
