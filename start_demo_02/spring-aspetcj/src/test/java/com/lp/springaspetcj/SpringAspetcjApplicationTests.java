package com.lp.springaspetcj;

import com.lp.springaspetcj.entity.User;
import com.lp.springaspetcj.handler.TestHandler;
import com.lp.springaspetcj.service.impl.TestServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringAspetcjApplicationTests {
    @Autowired
    private TestHandler thread;

    @Autowired
    private TestServiceImpl testService;

    @Test
    void test1() {
        thread.run();
    }

    @Test
    void test2() {
        User user = new User();
        user.setId("001");
        user.setName("jack");
        user.setSex(1);
        testService.addOne(user);
    }
}
