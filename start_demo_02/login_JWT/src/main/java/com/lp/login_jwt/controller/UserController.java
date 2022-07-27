package com.lp.login_jwt.controller;

import com.lp.login_jwt.enums.CodeEnum;
import com.lp.login_jwt.enums.MsgEnum;
import com.lp.login_jwt.model.entity.User;
import com.lp.login_jwt.model.vo.UserLoginVo;
import com.lp.login_jwt.repository.UserRepository;
import com.lp.login_jwt.service.UserService;
import com.lp.login_jwt.temple.ResponseTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author lipeng
 * @Date 2022/7/27 16:32
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public ResponseTemplate list(){
        List<User> list = userRepository.findAll();
        return new ResponseTemplate(MsgEnum.COMMON_SUCCESS_MSG.value(), CodeEnum.COMMON_SUCCESS_CODE.value(),list);
    }

    @PostMapping("/login")
    public ResponseTemplate login(@RequestBody UserLoginVo userLoginVo) throws Exception {
        String token = userService.login(userLoginVo);
        return new ResponseTemplate(MsgEnum.COMMON_SUCCESS_MSG.value(), CodeEnum.COMMON_SUCCESS_CODE.value(),token);
    }

    @GetMapping("/page/{page}/{size}")
    public ResponseTemplate pageList(@PathVariable int page, @PathVariable int size){
        List<User> list = userRepository.findAll();
        return new ResponseTemplate(MsgEnum.COMMON_SUCCESS_MSG.value(), CodeEnum.COMMON_SUCCESS_CODE.value(),list);
    }
}
