package com.kzzf.blog.interceptor;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/admin/**")  // 对admin下的地址进行过滤
                .excludePathPatterns("/admin")  // 排除一些不用过滤的地址
                .excludePathPatterns("/admin/login");
    }
}
