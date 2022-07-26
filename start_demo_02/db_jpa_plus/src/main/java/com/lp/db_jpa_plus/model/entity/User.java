package com.lp.db_jpa_plus.model.entity;

import lombok.Data;

import javax.persistence.Table;

/**
 * @Author lipeng
 * @Date 2022/7/25 10:58
 * @Version 1.0
 */
@Data
@Table(name = "user")
public class User {
    private Integer id;
    private String name;
    private String psw;
    private String photo;
    private String information;
    private String school;
}
