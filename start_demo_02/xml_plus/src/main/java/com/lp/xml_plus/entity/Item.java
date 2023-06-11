package com.lp.xml_plus.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 与xml文件中的item数据对应
 *
 * @Author lipeng
 * @Date 2023/5/25 14:55
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    private String id;

    private String dataItemId;

    private String dataItemName;
}
