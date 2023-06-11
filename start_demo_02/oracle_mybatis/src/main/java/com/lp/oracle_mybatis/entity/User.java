package com.lp.oracle_mybatis.entity;

import lombok.Data;

/**
 * @Author lipeng
 * @Date 2023/6/5 14:02
 * @Version 1.0
 */
@Data
public class User {

    // 主键
    private Integer id;

    // 用户名
    private String name;

    // 用户密码
    private String psw;

    // 用户头像地址
    private String photo;

    // 用户个人简介
    private String information;

    // 用户学校名称
    private String school;

    // 住址
    private String address;
}
