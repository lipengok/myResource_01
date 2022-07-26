package com.lp.db_jpa.repository;

import com.lp.db_jpa.model.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @Author lipeng
 * @Date 2022/7/26 9:06
 * @Version 1.0
 */
public interface UserCrudRepository extends CrudRepository<User, Integer> {
}
