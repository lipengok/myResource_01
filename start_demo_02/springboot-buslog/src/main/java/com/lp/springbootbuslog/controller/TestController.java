package com.lp.springbootbuslog.controller;

import com.alibaba.fastjson2.JSON;
import com.lp.springbootbuslog.aop.BusinessTypeEnum;
import com.lp.springbootbuslog.aop.Log;
import com.lp.springbootbuslog.entity.SysLog;
import com.lp.springbootbuslog.service.TestService;
import com.lp.springbootbuslog.service.impl.TestServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author lipeng
 * @Date 2022/10/28 14:24
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestServiceImpl testService;

    @Log(title = "测试",businessType = BusinessTypeEnum.INSERT)
    @GetMapping("/saveLog")
    public String saveLog(){
        log.info("我就是来测试一下是否成功！");
        return "success";
    }

    @GetMapping
    public List<SysLog> list(){
        return testService.logList();

        // return JSON.toJSONString(list);
    }
}

