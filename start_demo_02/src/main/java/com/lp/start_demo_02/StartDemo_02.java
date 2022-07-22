package com.lp.start_demo_02;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * 输入一个 int 型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * 保证输入的整数最后一位不是 0 。
 * 示例1
 * 输入：
 * 9876673
 * 输出：
 * 37689
 * @Author lipeng
 * @Date 2022/7/19 15:31
 * @Version 1.0
 */
public class StartDemo_02 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        InputStream in = System.in;
        // 输入的长度
        int available = in.available()-1;
        char[] chars = new char[available];
        while (available-- > 0) {
            chars[available] = (char) in.read();
        }
        StringBuilder resul = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (resul.lastIndexOf(String.valueOf(chars[i])) != -1){
                continue;
            }
            resul.append(chars[i]);
        }
        System.out.println(resul.toString());
    }
}
