package com.lp.excel_demo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
 * @Author lipeng
 * @Date 2022/11/3 11:26
 * @Version 1.0
 */
@Data
@TableName("user")
public class User {

    /**
     * IdType.AUTO
     * 数据库中id自增
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * ## FieldFill的值代表的意义：填充策略
     * DEFAULT：不处理
     * INSERT：插入时填充
     * UPDATE：更新时填充
     * INSERT_UPDATE：插入或者新增时填充
     */
    @TableField(value = "name")
    private String name;
    private String psw;
    private String information;
    private String photo;
    private String school;
}
