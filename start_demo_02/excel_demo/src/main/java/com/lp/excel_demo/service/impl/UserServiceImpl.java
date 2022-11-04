package com.lp.excel_demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lp.excel_demo.entity.User;
import com.lp.excel_demo.mapper.UserMapper;
import com.lp.excel_demo.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Author lipeng
 * @Date 2022/11/3 11:32
 * @Version 1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
