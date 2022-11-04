package com.lp.springaspetcj.controller;

import com.lp.springaspetcj.handler.TestHandler;
import com.lp.springaspetcj.template.ResponseTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lipeng
 * @Date 2022/10/31 10:37
 * @Version 1.0
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestHandler testHandler;

    @GetMapping
    public ResponseTemplate test(){
        testHandler.run();
        return new ResponseTemplate().success(null);
    }
}
