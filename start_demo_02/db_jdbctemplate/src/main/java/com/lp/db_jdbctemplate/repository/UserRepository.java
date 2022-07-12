package com.lp.db_jdbctemplate.repository;

import com.lp.db_jdbctemplate.modle.enity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author lipeng
 * @Date 2022/6/24 13:59
 * @Version 1.0
 */
@Repository
@Slf4j
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List findAll() {
        String sql = "select * from user";
        log.info("sql=>{ [{}] }", sql);
        return jdbcTemplate.queryForList(sql);
    }

    public void insert(User user) {
        String sql = "insert into user(name, psw, photo, information, school) " +
                "values(" + user.getName() + "," + user.getPsw() + "," + user.getPhoto() + "," + user.getInformation() + "," + user.getSchool() + ")";
        jdbcTemplate.execute(sql);
    }

    public void del(User user) {
        Integer id = user.getId();
        delByid(id);
    }

    public void delByid(Integer id) {
        String sql = "select * from user where id = " + id;
        jdbcTemplate.execute(sql);
    }

    public int update(User user) {
        String sql = "update user set name=? psw=? photo=? information=? school=?" +
                "where id=?";
        return jdbcTemplate.update(sql, user.getName(), user.getPsw(), user.getPhoto(), user.getInformation(), user.getSchool(), user.getId());
    }

    public List findById(Integer id) {
        String sql = "select * from user where id=?";
        return jdbcTemplate.queryForList(sql, id);
    }

    public List<User> find(User user) {
        String sql = "select * from user where id=? and name=?";
        BeanPropertyRowMapper rowMapper = new BeanPropertyRowMapper(User.class);
        return jdbcTemplate.query(sql, rowMapper, user.getId(), user.getName());
    }
}
