package com.lp.login_jwt.service;

/**
 * @Author lipeng
 * @Date 2022/7/27 10:20
 * @Version 1.0
 */
public interface RedisService {

    // 添加数据
    void set(String key, String value);

    // 查询数据
    String get(String key);

    // 删除数据
    boolean delete(String key);

    // 获取数据过期时间
    Long getExpireTime(String key);
}
