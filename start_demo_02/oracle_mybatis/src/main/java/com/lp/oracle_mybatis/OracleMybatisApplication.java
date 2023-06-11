package com.lp.oracle_mybatis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class OracleMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(OracleMybatisApplication.class, args);
        log.info("项目初始化完成");
    }

}
