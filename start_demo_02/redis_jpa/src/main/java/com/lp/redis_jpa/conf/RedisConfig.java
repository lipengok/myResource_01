package com.lp.redis_jpa.conf;

import com.lp.redis_jpa.conf.convert.ReUserConvert;
import com.lp.redis_jpa.conf.convert.UserConvert;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.redis.core.convert.RedisCustomConversions;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lipeng
 * @Date 2022/7/5 15:18
 * @Version 1.0
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedisCustomConversions redisCustomConversions(){
        List<Converter> list = new ArrayList<>();
        list.add(new UserConvert());
        list.add(new ReUserConvert());
        RedisCustomConversions redisCustomConversions = new RedisCustomConversions(list);
        return redisCustomConversions;
    }
}
