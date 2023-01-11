package com.lp.spring_annotate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SpringAnnotateApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAnnotateApplication.class, args);
        log.info("项目初始化完成");
    }

}
