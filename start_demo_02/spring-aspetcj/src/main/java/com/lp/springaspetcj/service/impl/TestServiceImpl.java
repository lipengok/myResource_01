package com.lp.springaspetcj.service.impl;

import com.lp.springaspetcj.entity.User;
import com.lp.springaspetcj.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @Author lipeng
 * @Date 2022/10/31 10:36
 * @Version 1.0
 */
@Service
public class TestServiceImpl implements TestService {

    public void addOne(User user){
        System.out.println("新增用户=>" + user);
    }
}
