package com.lp.dubbo_api_provider_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(value = {"classpath:provider.xml"})
public class DubboApiProviderDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboApiProviderDemoApplication.class, args);
    }

}
