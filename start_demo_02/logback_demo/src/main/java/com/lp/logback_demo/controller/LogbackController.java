package com.lp.logback_demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lipeng
 * @Date 2022/7/22 9:12
 * @Version 1.0
 */
@RestController
@RequestMapping("/logback")
@Slf4j
public class LogbackController {

    @GetMapping("/getPath")
    public String getPath(){
        String path = System.getProperty("user.dir");
        log.info("项目路径=>[{}]", path);
        log.error("项目路径=>[{}]", path);
        log.debug("项目路径=>[{}]", path);
        log.warn("项目路径=>[{}]", path);

        return path;
    }
}
