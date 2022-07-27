package com.lp.login_jwt.util;

import com.lp.login_jwt.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author lipeng
 * @Date 2022/7/27 10:15
 * @Version 1.0
 */
@Component
@Slf4j
public final class RedisUtil implements RedisService {

    // 数据默认过期时间
    private final Long DURATION = 1*24*60*60*1000L;

    private ValueOperations<String,String> valueOperations;

    @Resource
    private RedisTemplate redisTemplate;

    public void init(){
        RedisSerializer redisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);
        redisTemplate.setValueSerializer(redisSerializer);
        redisTemplate.setHashKeySerializer(redisSerializer);
        redisTemplate.setHashValueSerializer(redisSerializer);
        valueOperations = redisTemplate.opsForValue();
        log.debug("redis初始化完成");
    }

    @Override
    public void set(String key, String value) {
        valueOperations.set(key, value, DURATION);
        log.debug("【add】=>[{}]:[{}]", key, value);
    }

    @Override
    public String get(String key) {
        String value = valueOperations.get(key);
        return value;
    }

    @Override
    public boolean delete(String key) {
        boolean res = redisTemplate.delete(key);
        log.debug("【delete】=>[{}]", key);
        return res;
    }

    @Override
    public Long getExpireTime(String key) {
        Long time = redisTemplate.getExpire(key);
        return time;
    }
}
