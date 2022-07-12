package com.lp.log4j_demo.controller;

import com.lp.log4j_demo.service.Log4jService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Author lipeng
 * @Date 2022/7/6 10:00
 * @Version 1.0
 */
@RestController
@RequestMapping("/log")
public class Log4jController {
    @Autowired
    private Log4jService log4jService;

    @GetMapping("/debug")
    public String debugDemo(){
        return log4jService.debugDemo(new Date(System.currentTimeMillis()));
    }

    @GetMapping("/error")
    public String errorDemo(){
        return log4jService.errorDemo();
    }
}
