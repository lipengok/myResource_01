package com.lp.es_demo2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 *
 * shards表示分片数量，其中副本replicas
 *
 * @Author lipeng
 * @Date 2022/7/19 13:46
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "bag", type = "_doc", shards = 1, replicas = 0)
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
