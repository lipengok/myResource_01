package com.lp.mongodb_demo.entity.dto;

import lombok.Data;

/**
 * @Author lipeng
 * @Date 2022/8/17 8:58
 * @Version 1.0
 */
@Data
public class User {
    // id
    private Long id;
    // 学籍信息
    private Long sid;
    // 身份证信息
    private Long cid;
    // 昵称
    private String name;
    // 密码
    private String psw;
    // 简介
    private String direction;
}
