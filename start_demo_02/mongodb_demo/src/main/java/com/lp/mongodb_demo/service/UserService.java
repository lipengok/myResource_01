package com.lp.mongodb_demo.service;

import com.lp.mongodb_demo.entity.dto.User;

import java.util.List;

/**
 * @Author lipeng
 * @Date 2022/8/17 9:03
 * @Version 1.0
 */
public interface UserService {

    List<User> findAll();
}
