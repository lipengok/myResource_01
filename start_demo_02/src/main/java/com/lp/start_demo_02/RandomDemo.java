package com.lp.start_demo_02;

import java.util.Random;

/**
 * @Author lipeng
 * @Date 2023/5/20 10:19
 * @Version 1.0
 */
public class RandomDemo {


    public static void main(String[] args) {
        Random random = new Random();

        // 取0-5的随机数
        for (int i = 0; i < 100; i++) {
            int a = random.nextInt(6);
            System.out.println(a);
        }
    }
}
