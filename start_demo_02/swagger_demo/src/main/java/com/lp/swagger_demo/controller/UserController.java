package com.lp.swagger_demo.controller;

import com.lp.swagger_demo.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lipeng
 * @Date 2022/7/6 14:23
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户管理相关接口")
public class UserController {

    @GetMapping("/list")
    @ApiOperation("查询所有的用户信息")
    public List<User> findAll(){
        User user = new User();
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            user.setId(111111);
            user.setInformation("information");
            user.setName("jack");
            user.setPhoto("www.baidu.com/photo/main/008.png");
            user.setPsw("67890");
            user.setSchool("蚌埠学院");
            list.add(user);
        }
        return list;
    }
}
