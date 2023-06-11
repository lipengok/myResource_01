package com.lp.quartz_simple;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class QuartzSimpleApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuartzSimpleApplication.class, args);
        log.info("项目初始化完成");
    }

}
