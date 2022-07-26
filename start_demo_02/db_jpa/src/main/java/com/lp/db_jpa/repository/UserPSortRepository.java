package com.lp.db_jpa.repository;

import com.lp.db_jpa.model.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @Author lipeng
 * @Date 2022/7/26 9:43
 * @Version 1.0
 */
public interface UserPSortRepository extends PagingAndSortingRepository<User, Integer> {
}
