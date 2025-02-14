package org.employeems.config;

import lombok.extern.slf4j.Slf4j;
import org.employeems.handler.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("开始注册自定义拦截器....");
        // 添加拦截器
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/core/**") // 拦截的路径
                .excludePathPatterns("/login/**"); // 排除登录接口
    }
}
