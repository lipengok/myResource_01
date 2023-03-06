package com.lp.word_demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class WordDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(WordDemoApplication.class, args);
        log.info("项目初始化完成");
    }

}
