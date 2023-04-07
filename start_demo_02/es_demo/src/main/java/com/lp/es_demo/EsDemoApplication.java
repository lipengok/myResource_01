package com.lp.es_demo;

import com.lp.es_demo.utils.LogUtil;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EsDemoApplication {

    static Logger logger = LogUtil.getLog();

    public static void main(String[] args) {
        SpringApplication.run(EsDemoApplication.class, args);
        logger.info("spring容器初始化完成");
    }

}
