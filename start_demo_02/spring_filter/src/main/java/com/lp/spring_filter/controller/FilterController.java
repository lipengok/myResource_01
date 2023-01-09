package com.lp.spring_filter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lipeng
 * @Date 2023/1/9 14:43
 * @Version 1.0
 */
@RestController
@RequestMapping("/filter")
public class FilterController {

    @GetMapping("/demo")
    public String demo(){
        return "demo";
    }
}
