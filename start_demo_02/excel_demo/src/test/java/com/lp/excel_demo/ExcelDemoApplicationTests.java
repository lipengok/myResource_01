package com.lp.excel_demo;

import com.alibaba.fastjson2.JSON;
import com.lp.excel_demo.entity.User;
import com.lp.excel_demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ExcelDemoApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
        List<User> list = userService.list();
        JSON.toJSONString(list);

        System.out.println(list);
    }

}
