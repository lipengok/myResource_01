package com.lp.db_mybatisplus;

import com.lp.db_mybatisplus.entity.Phone;
import com.lp.db_mybatisplus.entity.User;
import com.lp.db_mybatisplus.mapper.UserMapper;
import com.lp.db_mybatisplus.model.pojo.LoginInfo;
import com.lp.db_mybatisplus.service.PhoneService;
import com.lp.db_mybatisplus.service.impl.PhoneServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class DbMybatisplusApplicationTests {
    @Resource
    private UserMapper userMapper;

    @Autowired
    private PhoneServiceImpl phoneService;

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

    @Test
    void phoneServiceFindAll(){
        List<Phone> list = phoneService.list();
        Phone phone = list.get(0);
        System.out.println(phone.toString());
        System.out.println(phone.getState().getValue());
    }

}
