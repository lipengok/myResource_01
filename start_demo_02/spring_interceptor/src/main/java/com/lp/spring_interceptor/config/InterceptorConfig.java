package com.lp.spring_interceptor.config;

import com.lp.spring_interceptor.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * spring nvc 配置
 *
 * @Author lipeng
 * @Date 2023/1/9 10:53
 * @Version 1.0
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    /**
     * 添加自定义拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).
        // 登录接口不拦截
        excludePathPatterns("/**/login").
        excludePathPatterns("/**/loginByMobile").
        excludePathPatterns("/**/loginByName");;
    }
}
