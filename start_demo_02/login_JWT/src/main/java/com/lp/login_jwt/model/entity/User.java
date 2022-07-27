package com.lp.login_jwt.model.entity;

import lombok.Data;

/**
 * @Author lipeng
 * @Date 2022/7/25 10:58
 * @Version 1.0
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String psw;
    private String photo;
    private String information;
    private String school;

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
