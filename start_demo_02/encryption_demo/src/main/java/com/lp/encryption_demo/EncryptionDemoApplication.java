package com.lp.encryption_demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class EncryptionDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EncryptionDemoApplication.class, args);
        log.info("项目初始化完成");
    }

}
