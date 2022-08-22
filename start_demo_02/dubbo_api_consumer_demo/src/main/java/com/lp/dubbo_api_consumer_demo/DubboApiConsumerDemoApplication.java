package com.lp.dubbo_api_consumer_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:consumer.xml")
public class DubboApiConsumerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboApiConsumerDemoApplication.class, args);
    }

}
