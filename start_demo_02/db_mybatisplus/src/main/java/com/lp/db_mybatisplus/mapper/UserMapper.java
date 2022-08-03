package com.lp.db_mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lp.db_mybatisplus.entity.User;
import com.lp.db_mybatisplus.model.pojo.LoginInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author lipeng
 * @Date 2022/7/4 10:32
 * @Version 1.0
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    List<User> findAll();

    List<User> findByName(String name);

    List<LoginInfo> findLogin();

    User findById(Integer id);
}
