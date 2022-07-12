package com.lp.db_jdbctemplate.modle.enity;

import lombok.Data;

/**
 * @Author lipeng
 * @Date 2022/6/24 14:01
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

}
