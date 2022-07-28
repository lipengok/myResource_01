package com.lp.login_jwt.config;

import com.lp.login_jwt.handler.LoginHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author lipeng
 * @Date 2022/7/27 15:43
 * @Version 1.0
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticateInterceptor())
                // 不做验证的路径
                .excludePathPatterns("/**/logout/**","/**/login/**","/**/list/**")
                .addPathPatterns("/**");
    }

    @Bean
    public LoginHandler authenticateInterceptor() {
        return new LoginHandler();
    }
}
