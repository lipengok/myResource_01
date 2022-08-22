package com.lp.dubbo_api_demo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author lipeng
 * @Date 2022/6/24 14:01
 * @Version 1.0
 */
@Data
public class User implements Serializable {
    private Integer id;
    private String name;
    private String psw;
    private String photo;
    private String information;
    private String school;

}
