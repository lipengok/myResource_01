package com.lp.redis_jpa.controller;

import com.lp.redis_jpa.entity.User;
import com.lp.redis_jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author lipeng
 * @Date 2022/7/5 15:02
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/insert")
    public boolean insert(@RequestBody List<User> list){
        boolean flag = false;
        try {
            userService.insert(list);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @GetMapping("/list")
    public List find(){
        return userService.find();
    }
}
