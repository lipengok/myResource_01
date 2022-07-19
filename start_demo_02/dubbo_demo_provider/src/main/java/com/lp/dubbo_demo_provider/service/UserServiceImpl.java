package com.lp.dubbo_demo_provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.lp.dubbo_demo.entity.User;
import com.lp.dubbo_demo.service.UserService;
import com.lp.dubbo_demo_provider.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author lipeng
 * @Date 2022/7/18 14:08
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
