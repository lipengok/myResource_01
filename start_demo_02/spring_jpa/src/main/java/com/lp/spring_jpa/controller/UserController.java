package com.lp.spring_jpa.controller;

import com.lp.spring_jpa.entity.User;
import com.lp.spring_jpa.jpa.repository.UserRepository;
import com.lp.spring_jpa.jpa.service.UserService2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author lipeng
 * @Date 2023/1/13 9:29
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService2 userService;

    @GetMapping("/findByName")
    public Map<String, List> findByName(@RequestParam String name){
        List<User> list1 = userRepository.queryByName(name);
        List<User> list2 = userRepository.findAllByName(name);
        Map<String, List> map = new HashMap<>();
        map.put("queryByName", list1);
        map.put("findAllByName", list2);
        return map;
    }

    @GetMapping("/findByNameLike")
    public List<User> findByNameLike(@RequestParam String name){
        return userRepository.findAllByNameContaining(name);
    }

    @GetMapping("/findByIds")
    public List<User> findByIds(@RequestParam List<Integer> ids){
        return userRepository.findAllByIdIn(ids);
    }

    @GetMapping("/findByIdBetween")
    public List<User> findByIdBetween(@RequestParam Integer start, @RequestParam Integer end){
        return userRepository.findAllByIdBetween(start, end);
    }

    @GetMapping("/findByNamePage")
    public Page<User> findByNamePage(@RequestParam String name, @RequestParam int page, @RequestParam int size){
        return userRepository.findAllByName(name, PageRequest.of(page, size));
    }
}
