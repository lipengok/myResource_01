package com.lp.spring_jpa.jpa.repository;

import com.lp.spring_jpa.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * user jpa
 *
 * @Author lipeng
 * @Date 2023/1/12 13:59
 *
 * @Version 1.0
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    // 根据用户名查找
    @Query("select u from User u where name = ?1")
    List<User> queryByName(String name);

    // jpa根据方法名匹配
    // 根据用户名查找
    List<User> findAllByName(String name);

    // jpa根据方法名匹配
    // 根据用户名模糊查找
    // like不生效Containing会生效
    List<User> findAllByNameContaining(String name);

    // jpa根据方法名匹配
    // 根据用户id查找用户列表
    List<User> findAllByIdIn(List<Integer> ids);

    // jpa根据方法名匹配
    // 根据用户id的范围查找用户列表
    List<User> findAllByIdBetween(Integer start, Integer end);

    // jpa根据方法名匹配
    // 根据条件分页查询
    Page<User> findAllByName(String name, Pageable pageable);
}
