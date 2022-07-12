package com.lp.redis_jpa.conf.convert;

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
public class UserConvert implements Converter<User, byte[]> {

    @SneakyThrows
    @Override
    public byte[] convert(User user) {
        // 对象-压缩-序列化
        return JsonUtil.compressCJSONToByte(user);
    }
}
