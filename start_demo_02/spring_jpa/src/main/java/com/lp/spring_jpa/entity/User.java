package com.lp.spring_jpa.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author lipeng
 * @Date 2023/1/12 10:02
 * @Version 1.0
 */
@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    private Integer id;
    private String name;
    private String psw;
    private String photo;
    private String information;
    private String school;

    public User() {
    }
}
