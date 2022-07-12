package com.lp.redis_jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class RedisJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisJpaApplication.class, args);
    }

}
