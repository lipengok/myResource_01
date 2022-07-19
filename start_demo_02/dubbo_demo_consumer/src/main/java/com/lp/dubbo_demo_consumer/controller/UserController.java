package com.lp.dubbo_demo_consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lp.dubbo_demo.entity.User;
import com.lp.dubbo_demo.service.UserService;
import com.lp.dubbo_demo_consumer.enums.Code;
import com.lp.dubbo_demo_consumer.enums.Msg;
import com.lp.dubbo_demo_consumer.template.ResponseTemplate;
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
