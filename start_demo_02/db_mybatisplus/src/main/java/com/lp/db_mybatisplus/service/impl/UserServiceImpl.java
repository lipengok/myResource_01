package com.lp.db_mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lp.db_mybatisplus.entity.User;
import com.lp.db_mybatisplus.mappers.UserMapper;
import com.lp.db_mybatisplus.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Author lipeng
 * @Date 2022/7/4 10:35
 * @Version 1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{
}
