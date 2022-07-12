package com.lp.db_mybatis.controller;

import com.lp.db_mybatis.globe.CodeEnum;
import com.lp.db_mybatis.globe.MsgEnum;
import com.lp.db_mybatis.modle.ResponseModel;
import com.lp.db_mybatis.service.UserService;
import com.lp.db_mybatis.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lipeng
 * @Date 2022/6/29 15:12
 * @Version 1.0
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/list")
    public ResponseModel findAll(){
        return new ResponseModel(MsgEnum.SELECT_SUCCESS.value(), CodeEnum.SUCCESS_CODE.value(), userService.findAll());
    }
}
