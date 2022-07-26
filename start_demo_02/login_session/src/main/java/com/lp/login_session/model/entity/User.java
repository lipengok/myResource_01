package com.lp.login_session.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author lipeng
 * @Date 2022/7/25 10:58
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

    // 必须存在，hibernate需要实体类的无参构造函数
    public User(){}

    public User(Integer id, String name, String psw, String photo, String information, String school) {
        this.id = id;
        this.name = name;
        this.psw = psw;
        this.photo = photo;
        this.information = information;
        this.school = school;
    }
}
