package com.lp.start_demo_02;

import java.io.UnsupportedEncodingException;

/**
 * 进制转换
 * @Author lipeng
 * @Date 2023/1/5 11:20
 * @Version 1.0
 */
public class BaseDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        Integer num1 = 5;
        Integer num2 = 0x5A;
        System.out.println(num1+"10进制转成二进制是："+base10To2(num1));
        System.out.println(num2+"16进制转成10进制是："+base16To10(num2));
        System.out.println(num2+"16进制转成2进制是："+base16To2(num2));
    }
    // 8进制转成2进制
    private static String base8To2(int num) {
        return Integer.toBinaryString(base8To10(num));
    }
    // 10进制转成2进制
    private static String base10To2(int num) {
        return Integer.toBinaryString(num);
    }
    // 16进制转成2进制
    private static String base16To2(int num) {
        return Integer.toBinaryString(base16To10(num));
    }

    // 16进制转成10进制（2位）
    private static int base16To10(int num) {
        return num & 0xff;
    }
    // 8进制转成10进制（2位）
    private static int base8To10(int num) {
        return num & 77;
    }
    // 2进制转成10进制（2位）
    private static int base2To10(int num) {
        return num & 22;
    }
    // 0：2进制，1：8进制，2：16进制
    private static int baseNumTo10(int num, int type) {
        int res = 0;
        switch (type) {
            case 0:
                res = num & 22;
                break;
            case 1:
                res = num & 77;
                break;
            case 2:
                res = num & 0xff;
                break;
            default:
                break;
        }
        return res;
    }
}
