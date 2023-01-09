package com.lp.spring_filter.config;

import com.lp.spring_filter.filter.MyFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author lipeng
 * @Date 2023/1/9 14:42
 * @Version 1.0
 */
@Configuration
public class FilterConfig {

    @Bean(name = "myFilter")
    public MyFilter getMyFilter(){
        return new MyFilter();
    }
}
