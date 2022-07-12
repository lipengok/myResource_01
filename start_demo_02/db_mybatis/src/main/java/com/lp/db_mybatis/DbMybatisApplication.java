package com.lp.db_mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lp.db_mybatis.mapper")
public class DbMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbMybatisApplication.class, args);
    }

}
