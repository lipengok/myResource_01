package com.lp.start_demo_02;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * 描述
 * 输入一个整数，将这个整数以字符串的形式逆序输出
 * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 * <p>
 * <p>
 * 数据范围： 0 \le n \le 2^{30}-1 \0≤n≤2
 * 30
 * −1
 * 输入描述：
 * 输入一个int整数
 * <p>
 * 输出描述：
 * 将这个整数以字符串的形式逆序输出
 * <p>
 * 示例1
 * 输入：
 * 1516000
 * 复制
 * 输出：
 * 0006151
 */
public class StartDemo_04 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        InputStream in = System.in;
        // 输入流的长度
        int available = in.available() - 1;
        char[] chars = new char[available];
        while (available-- > 0) {
            chars[available] = (char) in.read();
        }
        System.out.println(chars);
    }
}
