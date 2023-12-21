package com.lp.start_demo_02;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @Author lipeng
 * @Date 2023/6/6 15:21
 * @Version 1.0
 */
public class BigDecimalDemo2 {

    public static void main(String[] args) {
        // 加减乘除
        BigDecimal a = new BigDecimal("1.0");
        BigDecimal b = new BigDecimal("0.9");

        System.out.println(a.add(b));// 1.9
        System.out.println(a.subtract(b));// 0.1
        System.out.println(a.multiply(b));// 0.90
        System.out.println(a.divide(b));// 无法除尽，抛出 ArithmeticException 异常
        System.out.println(a.divide(b, 2, RoundingMode.HALF_UP));// 1.11
    }
}
