package com.lp.spring_filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@Slf4j
@ServletComponentScan // @WebFilter的使用需要启用servlet注解
@SpringBootApplication
public class SpringFilterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringFilterApplication.class, args);
        log.info("项目初始化完成");
    }

}
