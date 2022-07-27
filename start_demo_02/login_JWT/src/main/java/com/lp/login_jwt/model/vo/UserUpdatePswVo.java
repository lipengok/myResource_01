package com.lp.login_jwt.model.vo;

import lombok.Data;

/**
 * @Author lipeng
 * @Date 2022/7/27 14:58
 * @Version 1.0
 */
@Data
public class UserUpdatePswVo {
    private String name;
    private String psw;
    private String newPsw;
}
