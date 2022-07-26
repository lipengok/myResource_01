package com.lp.db_jpa.repository;

import com.lp.db_jpa.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author lipeng
 * @Date 2022/7/25 10:59
 * @Version 1.0
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    /*@Query(value = "SELECT " +
            "new com.lp.db_jpa.model.entity.User(u.id, u.name, u.psw, u.photo, u.information, u.school) " +
            "FROM user u " +
            "ORDER BY id " +
            "DESC ")*/
    @Query(value = "select u from  com.lp.db_jpa.model.entity.User u order by u.id desc ")
    public List<User> findAllDesc();
}
