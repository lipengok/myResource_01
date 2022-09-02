package com.lp.db_jdbctemplate.controller;

import com.lp.db_jdbctemplate.globe.CodeEnum;
import com.lp.db_jdbctemplate.globe.MsgEnum;
import com.lp.db_jdbctemplate.modle.ResponseModel;
import com.lp.db_jdbctemplate.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lipeng
 * @Date 2022/6/24 14:11
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/all")
    public ResponseModel findAll() {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setCode(CodeEnum.SUCCESS_CODE.value());
        responseModel.setMsg(MsgEnum.SELECT_SUCCESS.value());
        responseModel.setData(userService.findAll());
        return responseModel;
    }
}
