package com.lp.jna_demo.controller;

import com.lp.jna_demo.service.OperateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lipeng
 * @Date 2023/6/28 10:09
 * @Version 1.0
 */
@RestController
@RequestMapping("/operate")
public class OperateController {

    @Autowired
    private OperateService operateService;


}
