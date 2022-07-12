package com.lp.db_mybatis.service.impl;

import com.lp.db_mybatis.entity.User;
import com.lp.db_mybatis.mapper.UserMapper;
import com.lp.db_mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author lipeng
 * @Date 2022/6/29 15:10
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }
}
