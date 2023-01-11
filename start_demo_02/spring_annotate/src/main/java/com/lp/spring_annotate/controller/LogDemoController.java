package com.lp.spring_annotate.controller;

import com.lp.spring_annotate.annotation.LogAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lipeng
 * @Date 2023/1/11 11:23
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/log/demo")
public class LogDemoController {

    @LogAnnotation("获取所有的型号")
    @GetMapping("/list")
    public List<String> list(){
        List list = new ArrayList<String>();
        list.add("k9s");
        list.add("k10s");
        log.info("查询到的型号如下：[{}]", list);
        return list;
    }
}
