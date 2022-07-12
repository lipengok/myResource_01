package com.lp.db_mybatisplus.entity;

import lombok.Data;

/**
 * @Author lipeng
 * @Date 2022/6/29 14:52
 * @Version 1.0
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String psw;
    private String information;
    private String photo;
    private String school;
}
