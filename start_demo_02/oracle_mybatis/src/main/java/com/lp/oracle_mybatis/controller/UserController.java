package com.lp.oracle_mybatis.controller;

import com.lp.oracle_mybatis.entity.User;
import com.lp.oracle_mybatis.entity.template.ResponseTemplate;
import com.lp.oracle_mybatis.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author lipeng
 * @Date 2023/6/5 14:39
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserMapper userMapper;

    @GetMapping("/id/{id}")
    public ResponseTemplate findById(@PathVariable Integer id){
        List<User> users = null;
        ResponseTemplate responseTemplate = null;
        try {
            users = userMapper.findById(id);
            responseTemplate = new ResponseTemplate().success(users);
        }catch (Exception e){
            log.error("根据用户id查询失败", e);
            responseTemplate = new ResponseTemplate().error(e.getMessage());
        }
        return responseTemplate;
    }

    @GetMapping("/name/{name}")
    public ResponseTemplate findByName(@PathVariable String name){
        ResponseTemplate responseTemplate = null;
        try {
            List<User> users = userMapper.findByName(name);
            responseTemplate = new ResponseTemplate().success(users);
        }catch (Exception e){
            log.error("根据用户name查询失败", e);
            responseTemplate = new ResponseTemplate().error(e.getMessage());
        }
        return responseTemplate;
    }

    @GetMapping("/name_like/{name}")
    public ResponseTemplate findLikeName(@PathVariable String name){
        try {
            List<User> users = userMapper.findLikeName(name);
            return new ResponseTemplate().success(users);
        }catch (Exception e){
            log.error("根据用户name模糊查询失败", e);
            return new ResponseTemplate().error(e.getMessage());
        }
    }

    @GetMapping("/pageByRowNum/{start}/{end}")
    public ResponseTemplate pageList(@PathVariable Integer start, @PathVariable Integer end){
        try {
            List<User> users = userMapper.pageList(start, end);
            return new ResponseTemplate().success(users);
        }catch (Exception e){
            log.error("根据行号分页查询失败", e);
            return new ResponseTemplate().error(e.getMessage());
        }
    }

    @GetMapping("/pageById/{start}/{end}")
    public ResponseTemplate pageList2(@PathVariable Integer start, @PathVariable Integer end){
        try {
            List<User> users = userMapper.pageList2(start, end);
            return new ResponseTemplate().success(users);
        }catch (Exception e){
            log.error("根据id分页查询失败", e);
            return new ResponseTemplate().error(e.getMessage());
        }
    }

    @PostMapping("/insertUsers")
    public ResponseTemplate insertUsers(@RequestBody List<User> list){
        try {
            userMapper.insertUsers(list);
            return new ResponseTemplate().success(list);
        }catch (Exception e){
            log.error("批量插入失败", e);
            return new ResponseTemplate().error(e.getMessage());
        }
    }

    @PostMapping("/insertUser")
    public ResponseTemplate insertUser(@RequestBody User user){
        try {
            userMapper.insertUser(user);
            return new ResponseTemplate().success(user);
        }catch (Exception e){
            log.error("批量插入失败", e);
            return new ResponseTemplate().error(e.getMessage());
        }
    }
}
