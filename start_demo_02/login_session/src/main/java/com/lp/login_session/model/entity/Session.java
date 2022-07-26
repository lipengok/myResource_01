package com.lp.login_session.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author lipeng
 * @Date 2022/7/26 16:39
 * @Version 1.0
 */
@Data
@Entity
@Table(name = "session")
public class Session {
    @Id
    private Integer id;
    private String value;

}
