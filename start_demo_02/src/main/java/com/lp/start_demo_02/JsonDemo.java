package com.lp.start_demo_02;

import com.alibaba.fastjson2.JSON;
import java.util.Date;

/**
 * @Author lipeng
 * @Date 2022/8/9 16:43
 * @Version 1.0
 */
public class JsonDemo {
    public static void main(String[] args) {
        String json = JSON.toJSONString(new Date());
        System.out.println(json);
        Date date = JSON.parseObject(json, Date.class);
        System.out.println(date);
    }
}
