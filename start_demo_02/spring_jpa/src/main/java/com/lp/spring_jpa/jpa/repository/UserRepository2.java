package com.lp.spring_jpa.jpa.repository;

import com.lp.spring_jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @Author lipeng
 * @Date 2023/1/12 13:59
 * @Version 1.0
 */
public interface UserRepository2 extends CrudRepository<User, Integer> {

    List<User> findByName(String name);
}
