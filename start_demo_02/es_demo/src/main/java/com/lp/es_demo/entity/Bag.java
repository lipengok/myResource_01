package com.lp.es_demo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @Author lipeng
 * @Date 2022/7/19 13:46
 * @Version 1.0
 */
@Data
@Document(indexName = "bag",type = "docs", shards = 1, replicas = 0)
public class Bag {

    @Id
    private Integer id;
    // 用户id
    private Integer uId;
    // 书包名称
    private String name;
    // 书包容量
    private Double size;
    // 书包容量单位
    private String unit;
    // 书包价格
    private Double price;
    // 书包类型
    private Integer type;
    // 书包颜色
    private String color;

}
