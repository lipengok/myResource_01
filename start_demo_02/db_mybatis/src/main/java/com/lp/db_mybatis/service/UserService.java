package com.lp.db_mybatis.service;

import com.lp.db_mybatis.entity.User;

import java.util.List;

/**
 * @Author lipeng
 * @Date 2022/6/29 15:09
 * @Version 1.0
 */
public interface UserService {

    List<User> findAll();
}
