package com.lp.xml_plus;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class XmlPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(XmlPlusApplication.class, args);
        log.info("项目初始化完成");
    }

}
