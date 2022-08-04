package com.lp.db_mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
 * @Author lipeng
 * @Date 2022/6/29 14:52
 * @Version 1.0
 */
@Data
@TableName("user")
public class User {

    /**
     * ## IdType的值代表的意义：主键类型
     * NONE：默认值，该类型为未设置主键类型(注解里等于跟随全局,全局里约等于 INPUT)
     * INPUT：用户自己设置的 ID
     * AUTO：数据库自增的ID
     * ASSIGN_ID：当用户传入为空时，自动分配类型为 Number 或 String 的主键（雪花算法）
     * ASSIGN_UUID：当用户传入为空时，自动分配类型为 String 的主键
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
    @TableField(value = "name", fill = FieldFill.DEFAULT)
    private String name;
    private String psw;
    private String information;
    private String photo;
    private String school;

}
