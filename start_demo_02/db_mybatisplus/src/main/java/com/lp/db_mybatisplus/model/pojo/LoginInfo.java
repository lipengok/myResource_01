package com.lp.db_mybatisplus.model.pojo;

import com.lp.db_mybatisplus.entity.Seesion;
import com.lp.db_mybatisplus.entity.User;
import lombok.Data;

/**
 * @Author lipeng
 * @Date 2022/7/29 10:00
 * @Version 1.0
 */
@Data
public class LoginInfo {
    Integer id;
    // user
    private User user;
    // session
    private Seesion seesion;
}
