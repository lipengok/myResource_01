package com.lp.login_jwt.model.dto;

import lombok.Data;

/**
 * @Author lipeng
 * @Date 2022/7/27 10:13
 * @Version 1.0
 */
@Data
public class UserTokenDto {
    // 用户id
    private Long userId;
    // token创建时间
    private Long createTime;
}
