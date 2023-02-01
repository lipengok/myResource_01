package com.lp.excel_demo.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author lipeng
 * @Date 2022/11/3 11:26
 * @Version 1.0
 */
@Data               // 生成所有参数的ge，set方法
@AllArgsConstructor // 生成所有参数构造方法
@NoArgsConstructor  // 生成无参构造方法
@TableName("user")
public class User {

    /**
     * IdType.AUTO
     * 数据库中id自增
     */
    @ExcelProperty(value = "用户ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * ## FieldFill的值代表的意义：填充策略
     * DEFAULT：不处理
     * INSERT：插入时填充
     * UPDATE：更新时填充
     * INSERT_UPDATE：插入或者新增时填充
     */
    @ExcelProperty(value = "用户名")
    @TableField(value = "name")
    private String name;

    @ExcelProperty(value = "用户密码")
    @TableField(value = "psw")
    private String psw;

    @ExcelProperty(value = "用户信息")
    @TableField(value = "information")
    private String information;

    @ExcelProperty(value = "用户照片")
    @TableField(value = "photo")
    private String photo;

    @ExcelProperty(value = "用户学校")
    @TableField(value = "school")
    private String school;
}
