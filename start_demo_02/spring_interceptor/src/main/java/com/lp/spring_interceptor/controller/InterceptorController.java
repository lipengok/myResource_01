package com.lp.spring_interceptor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lipeng
 * @Date 2023/1/9 11:09
 * @Version 1.0
 */
@RestController
@RequestMapping("/interceptor")
public class InterceptorController {

    @GetMapping("/demo")
    public String demo(){
        return "success";
    }


}
