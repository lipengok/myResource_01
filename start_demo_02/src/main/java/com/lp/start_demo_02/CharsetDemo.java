package com.lp.start_demo_02;

import java.io.UnsupportedEncodingException;

/**
 * 编码格式转换
 *
 * @Author lipeng
 * @Date 2023/6/16 11:22
 * @Version 1.0
 */
public class CharsetDemo {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String n1 = "xuSong";
        String n2 = "许嵩";

        System.out.println(n1);
        System.out.println(toGbk(n1));

        System.out.println(n2);
        System.out.println(toGbk(n2));
    }

    private static String toGbk(String str) throws UnsupportedEncodingException {
        byte[] bytes = str.getBytes();
        return new String(bytes,"GBK");
    }
}
