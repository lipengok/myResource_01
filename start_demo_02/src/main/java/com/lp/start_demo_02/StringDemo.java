package com.lp.start_demo_02;

import com.sun.org.apache.bcel.internal.generic.DCMPG;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author lipeng
 * @Date 2022/8/25 16:15
 * @Version 1.0
 */
public class StringDemo {

    public static void main(String[] args) {
        String primaryKey = "2122D83C";
        String str1 = "21044c77";
        demo(str1);
    }


    private static void demo(String str) {
        System.out.println(str.substring(0,4));
        System.out.println(str.substring(4));
    }
}
