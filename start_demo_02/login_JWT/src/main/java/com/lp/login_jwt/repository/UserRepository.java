package com.lp.login_jwt.repository;

import com.lp.login_jwt.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @Author lipeng
 * @Date 2022/7/27 14:00
 * @Version 1.0
 */
@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> getUserByName(String name){
        String sql = "select * from user where name=?";
        List<User> list = jdbcTemplate.query(sql,new BeanPropertyRowMapper(User.class),name);
        return list;
    }

    public List<User> findAll(){
        String sql = "select * from user";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper(User.class));
    }

    public User getUserById(Integer id){
        String sql = "select * from user where id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
    }

    public boolean updateByName(String name, String psw){
        boolean flag = false;
        String sql = "update user set psw = ? where name = ?";
        int row = jdbcTemplate.update(sql, psw, name);
        if (row > 0){
            flag = true;
        }
        return flag;
    }
}
