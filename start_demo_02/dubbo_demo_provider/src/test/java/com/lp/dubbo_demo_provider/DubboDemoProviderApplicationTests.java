package com.lp.dubbo_demo_provider;

import com.lp.dubbo_demo.entity.User;
import com.lp.dubbo_demo_provider.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DubboDemoProviderApplicationTests {
    @Autowired
    private UserDao userDao;

    @Test
    void contextLoads() {
        List<User> list = userDao.findAll();
        System.out.println(list);
    }

}
