package com.lp.db_jdbctemplate.service;

import com.lp.db_jdbctemplate.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author lipeng
 * @Date 2022/6/24 14:07
 * @Version 1.0
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List findAll() {
        log.info("service=>{ 查询所有用户信息 }");
        return userRepository.findAll();
    }
}
