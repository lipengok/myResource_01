package com.lp.start_demo_02;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;

/**
 * @Author lipeng
 * @Date 2023/6/9 10:53
 * @Version 1.0
 */
public class ArrayListDemo {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < 99; i++) {
            list.add(String.valueOf(i));
        }

        System.out.println(JSON.toJSONString(list.subList(0,5)));

    }
}
