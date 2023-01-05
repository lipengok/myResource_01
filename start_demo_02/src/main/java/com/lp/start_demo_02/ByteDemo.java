package com.lp.start_demo_02;

import java.util.HashMap;
import java.util.Map;

/**
 * 字节处理
 * @Author lipeng
 * @Date 2022/8/26 14:04
 * @Version 1.0
 */
public class ByteDemo {
    // 二进制
    private static Integer BASE2 = 0;
    // 八进制
    private static Integer BASE8 = 1;
    // 十六进制
    private static Integer BASE16 = 2;

    public static void main(String[] args) throws Exception {
        System.out.println("base16To10:" + base16To10(0x10));
        System.out.println("base8To10:" + base8To10(10));
        System.out.println("base2To10:" + base2To10(10));
        System.out.println("base2To10:" + base2To10(1000));
        System.out.println("baseNumTo10:" + baseNumTo10(10, 0));
        System.out.println("baseTo10:" + baseTo10("10100", 0));
        System.out.println("baseTo10:" + baseTo10("0x1ac", 2));
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

    /**
     * 任何进制转换成10
     * base的含义：
     * 0：二进制，1：8进制，2：16进制
     *
     * @param num  要转换的数字
     * @param base 要转换的数字的进制
     * @return
     */
    private static int baseTo10(String num, int base) throws Exception {
        int len = num.length();
        char[] chars = num.toCharArray();
        int sum = 0;
        switch (base) {
            case 0:
                // 2进制
                int tmp1 = 1;
                for (int i = len - 1; i >= 0; i--) {
                    int a = Integer.parseInt(String.valueOf(chars[i]));
                    // 判断是否符合2进制的规则
                    if (a < 0 || a > 1) {
                        throw new Exception(num + "不符合2进制规则");
                    }
                    sum += a * tmp1;
                    tmp1 *= 2;
                }
                break;
            case 1:
                // 8进制
                int tmp2 = 1;
                for (int i = len - 1; i >= 0; i--) {
                    int a = Integer.parseInt(String.valueOf(chars[i]));
                    // 判断是否符合2进制的规则
                    if (a < 0 || a > 7) {
                        throw new Exception(num + "不符合8进制规则");
                    }
                    sum += a * tmp2;
                    tmp2 *= 8;
                }
                break;
            case 2:
                // 16进制判断
                if (len <= 2 || chars[0] != '0' || chars[1] != 'x') {
                    throw new Exception("param is not base16!");
                }
                // 将十六进制的每一个元素（字母）转换成数字
                int tmp3 = 1;
                for (int i = len - 1; i >= 2; i--) {
                    // 判断是否符合16进制的规则
                    if ((int) chars[i] > 102) {
                        throw new Exception(num + "不符合16进制规则");
                    }
                    int a = 0;
                    switch (chars[i]) {
                        case 'a':
                            a = 10;
                            break;
                        case 'b':
                            a = 11;
                            break;
                        case 'c':
                            a = 12;
                            break;
                        case 'd':
                            a = 13;
                            break;
                        case 'e':
                            a = 14;
                            break;
                        case 'f':
                            a = 15;
                            break;
                        default:
                            a = Integer.parseInt(String.valueOf(chars[i]));
                            break;
                    }
                    sum += a * tmp3;
                    tmp3 *= 16;
                }
                break;

        }
        return sum;
    }

    private static int base10To2(int num) {
        return num & 0xff;
    }

    /**
     * 位图法
     * 说明：所谓bitmap，就是用每一位来存放某种状态。
     * 适用于大规模数据，但数据状态又不是很多的情况。通常是用来 “判断某个数据存不存在”。
     */
    public static void wei1(){
        int[] i1 = {1234, 2345};

        // 将1234的作为key，状态为1：存在，放到内存中。
        Map map = new HashMap<Integer, Boolean>();
        map.put(1234, 1);
        map.put(2345, 1);
    }
}
