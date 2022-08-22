package com.lp.dubbo_api_consumer_demo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lp.dubbo_api_consumer_demo.enums.Code;
import com.lp.dubbo_api_consumer_demo.enums.Msg;
import com.lp.dubbo_api_consumer_demo.template.ResponseTemplate;
import com.lp.dubbo_api_demo.entity.User;
import com.lp.dubbo_api_demo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author lipeng
 * @Date 2022/7/18 14:12
 * @Version 1.0
 */
@RestController
@RequestMapping("/consumer")
public class UserController {
    @Reference
    private UserService userService;

    @GetMapping("/user/list")
    public ResponseTemplate findAll(){
        List<User> list = userService.findAll();
        return new ResponseTemplate(Msg.COMMON_SUCCESS.value(), Code.COMMON_SUCCESS.value(), list);
    }
}
