package com.lp.redis_jpa.conf.convert;

import com.alibaba.fastjson2.JSON;
import com.lp.redis_jpa.entity.User;
import com.lp.redis_jpa.util.JsonUtil;
import lombok.SneakyThrows;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

/**
 * @Author lipeng
 * @Date 2022/7/5 15:22
 * @Version 1.0
 */
@WritingConverter
public class ReUserConvert implements Converter<byte[], User> {

    @SneakyThrows
    @Override
    public User convert(byte[] bytes) {
        String json = JsonUtil.unCompressCJSONFromByte(bytes);

        User user = JSON.parseObject(json, User.class);
        return user;
    }
}
