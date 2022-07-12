package com.lp.redis_jpa.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

/**
 * @Author lipeng
 * @Date 2022/6/29 14:52
 * @Version 1.0
 */
@Data
@RedisHash
public class User {
    @Id
    private Integer id;

    private String name;
    private String psw;
    private String information;
    private String photo;
    private String school;
}
