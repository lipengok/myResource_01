package com.lp.login_jwt;

import com.lp.login_jwt.model.entity.User;
import com.lp.login_jwt.model.vo.UserLoginVo;
import com.lp.login_jwt.repository.UserRepository;
import com.lp.login_jwt.service.UserService;
import com.lp.login_jwt.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class LoginJwtApplicationTests {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserServiceImpl userService;

    @Test
    void contextLoads0() {
        List<User> list = userRepository.getUserByName("jack");
        System.out.println(list);
    }

    @Test
    void contextLoads1() {
        User user = userRepository.getUserById(1);
        System.out.println(user);
    }

    @Test
    void contextLoads2() {
        List<User> list = userRepository.getUserByName("jack");
        System.out.println(list);
    }

    @Test
    void contextLoads3() throws Exception {
        UserLoginVo userLoginVo = new UserLoginVo();
        userLoginVo.setName("lp");
        userLoginVo.setPsw("lp");
        String token = userService.login(userLoginVo);
        System.out.println(token);
    }

}
