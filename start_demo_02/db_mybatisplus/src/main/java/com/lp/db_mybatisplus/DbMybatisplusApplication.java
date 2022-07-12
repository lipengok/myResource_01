package com.lp.db_mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lp.db_mybatisplus.mappers")
public class DbMybatisplusApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbMybatisplusApplication.class, args);
    }

}
