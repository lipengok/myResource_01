package com.lp.db_jpa.controller;

import com.lp.db_jpa.enums.CodeEnum;
import com.lp.db_jpa.enums.MsgEnum;
import com.lp.db_jpa.model.entity.User;
import com.lp.db_jpa.service.UserService;
import com.lp.db_jpa.template.ResponseTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author lipeng
 * @Date 2022/7/26 10:19
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public ResponseTemplate list(){
        List<User> list = userService.findAll();
        return new ResponseTemplate(MsgEnum.COMMON_SUCCESS_MSG.value(), CodeEnum.COMMON_SUCCESS_CODE.value(), list);
    }

    @GetMapping("/query")
    public ResponseTemplate query(){
        List<User> list = userService.findAllByIdDesc();
        return new ResponseTemplate(MsgEnum.COMMON_SUCCESS_MSG.value(), CodeEnum.COMMON_SUCCESS_CODE.value(), list);
    }

    @GetMapping("/pageList/{page}/{size}")
    public ResponseTemplate page(@PathVariable int page, @PathVariable int size){
        Page<User> list = userService.find(page, size);
        return new ResponseTemplate(MsgEnum.COMMON_SUCCESS_MSG.value(), CodeEnum.COMMON_SUCCESS_CODE.value(), list);
    }
}
