package com.lp.spring_jpa.jpa.service;

import com.lp.spring_jpa.entity.User;
import com.lp.spring_jpa.jpa.repository.UserRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Author lipeng
 * @Date 2023/1/12 14:03
 * @Version 1.0
 */
@Service
public class UserService2 {

    @Autowired
    private UserRepository2 userRepository2;

    public List<User> findByName(String name){
        return userRepository2.findByName(name);
    }
}
