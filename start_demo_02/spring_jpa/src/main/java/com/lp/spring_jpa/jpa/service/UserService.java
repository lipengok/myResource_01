package com.lp.spring_jpa.jpa.service;

import com.lp.spring_jpa.entity.User;
import com.lp.spring_jpa.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author lipeng
 * @Date 2023/1/12 14:03
 * @Version 1.0
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * 无条件查询
     * @return
     */
    public List<User> list(){
        List<User> list = userRepository.findAll();
        return list;
    }

    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    public Page<User> listPage(int page, int size){
        // 排序条件
        Sort.Order order = new Sort.Order(Sort.Direction.DESC,"id");
        Sort sort = Sort.by(order);
        // 分页条件
        Pageable pageable = PageRequest.of(page, size, sort);
        return userRepository.findAll(pageable);
    }

    /**
     * 条件查询-根据用户名查询
     * 没有mybatis灵活，这里只能传递一个参数查询
     * @param name
     * @return
     */
    public List<User> findByName(String name){
        return userRepository.queryByName(name);
    }
}
