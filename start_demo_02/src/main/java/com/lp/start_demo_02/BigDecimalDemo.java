package com.lp.start_demo_02;

import java.math.BigDecimal;

/**
 * @Author lipeng
 * @Date 2023/6/6 15:21
 * @Version 1.0
 */
public class BigDecimalDemo {

    public static void main(String[] args) {
        BigDecimal demo = new BigDecimal("2.89");
        System.out.println(demo);

        Double demo2 = demo.doubleValue();
        System.out.println(demo2);

        // 保留4位小数
        Double demo3 = Double.valueOf(Math.round(demo2*10000))/10000;
        System.out.println(demo3);
    }
}
