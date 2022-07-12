package com.lp.redis_jpa.repository;

import com.lp.redis_jpa.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @Author lipeng
 * @Date 2022/7/5 14:43
 * @Version 1.0
 */
public interface UserRepository extends CrudRepository<User, Integer> {
}
