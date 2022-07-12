package com.lp.db_mybatis.mapper;

import com.lp.db_mybatis.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author lipeng
 * @Date 2022/6/29 14:53
 * @Version 1.0
 */
@Repository
public interface UserMapper {

    // select * from user
    List<User> findAll();
}
