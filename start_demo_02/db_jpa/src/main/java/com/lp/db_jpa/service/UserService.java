package com.lp.db_jpa.service;

import com.lp.db_jpa.model.entity.User;
import com.lp.db_jpa.repository.UserCrudRepository;
import com.lp.db_jpa.repository.UserPSortRepository;
import com.lp.db_jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lipeng
 * @Date 2022/7/25 11:14
 * @Version 1.0
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserCrudRepository userCrudRepository;
    @Autowired
    private UserPSortRepository userPSortRepository;

    /**
     * UserRepository
     * 自定义SQL
     * 查询用户信息，并且根据id降序排序
     * @return
     */
    public List<User> findAllByIdDesc(){
        return userRepository.findAllDesc();
    }

    /**
     * UserCrudRepository
     * 基础增删改查
     * 查询所有信息
     * @return
     */
    public List<User> findAll(){
        Iterable<User> iterable = userCrudRepository.findAll();
        List<User> list = new ArrayList<>();
        for (User user : iterable) {
            list.add(user);
        }
        return list;
    }

    /**
     * UserPSortRepository
     * 分页查询
     * @return
     */
    public Page<User> find(int page, int size){
        Sort.Order order = new Sort.Order(Sort.Direction.DESC,"id");
        Sort sort=Sort.by(order);
        Pageable pageable=PageRequest.of(page,size,sort);
        Page<User> pageList = userPSortRepository.findAll(pageable);
        return pageList;
    }
}
