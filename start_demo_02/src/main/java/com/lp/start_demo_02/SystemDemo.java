package com.lp.start_demo_02;

/**
 * @Author lipeng
 * @Date 2022/9/7 16:21
 * @Version 1.0
 */
public class SystemDemo {
    public static void main(String[] args) {
        byte[] srcBytes = new byte[]{2, 4, 0, 0, 0};  // 源数组
        byte[] destBytes = new byte[5]; // 目标数组
        System.arraycopy(srcBytes, 0, destBytes, 0, 5);
        for (int i = 0; i < destBytes.length; i++) {
            System.out.println(destBytes[i]);
        }
    }
}
