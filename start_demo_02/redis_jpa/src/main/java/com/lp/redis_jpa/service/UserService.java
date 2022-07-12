package com.lp.redis_jpa.service;

import com.lp.redis_jpa.entity.User;
import com.lp.redis_jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lipeng
 * @Date 2022/7/5 14:47
 * @Version 1.0
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // 批量新增
    public void insert(List<User> list){
        userRepository.saveAll(list);
    }

    // 获取所有数据
    public List<User> find(){
        return (List<User>) userRepository.findAll();
    }
    public List<User> find(Integer id){
        List ids = new ArrayList<>();
        ids.add(id);
        return (List<User>) userRepository.findAllById(ids);
    }
    public List<User> find(List<Integer> ids){
        return (List<User>) userRepository.findAllById(ids);
    }
}
