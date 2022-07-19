package com.lp.dubbo_demo.service;

import com.lp.dubbo_demo.entity.User;

import java.util.List;

/**
 * dubbo服务
 * @Author lipeng
 * @Date 2022/7/18 9:44
 * @Version 1.0
 */
public interface UserService {
    List<User> findAll();
}
