package com.lp.spring_filter.enity;

import lombok.Data;

/**
 * @Author lipeng
 * @Date 2023/1/10 9:43
 * @Version 1.0
 */
@Data
public class Address {

    // 省
    private String province;

    // 市
    private String city;

    // 区
    private String town;

    String uId;

    @Override
    public String toString() {
        return "Address{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", town='" + town + '\'' +
                ", uId='" + uId + '\'' +
                '}';
    }
}
