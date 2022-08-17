package com.lp.mongodb_demo.controller;

import com.lp.mongodb_demo.common.template.ResponseTemplate;
import com.lp.mongodb_demo.dao.UserDao;
import com.lp.mongodb_demo.entity.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lipeng
 * @Date 2022/8/17 8:58
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @PostMapping("/save")
    public ResponseTemplate saveUser(@RequestBody User user){
        User u = userDao.saveOneUser(user);
        return new ResponseTemplate("200", "success", u);
    }
}
