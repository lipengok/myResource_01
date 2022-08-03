package com.lp.db_mybatisplus;

import com.lp.db_mybatisplus.entity.User;
import com.lp.db_mybatisplus.mapper.UserMapper;
import com.lp.db_mybatisplus.model.pojo.LoginInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DbMybatisplusApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    void userMapperFindAll() {
        List<User> list = userMapper.findAll();
        System.out.println(list);
    }

    @Test
    void userMapperFindByName() {
        List<User> list = userMapper.findByName("jack");
        System.out.println(list);
    }

    @Test
    void userMapperfindLogin(){
        List<LoginInfo> list = userMapper.findLogin();
        System.out.println(list);
        System.out.println(list.get(0).getUser());
        System.out.println(list.get(0).getSeesion());

    }

}
