package com.lp.start_demo_02;

import java.util.Scanner;

/**
 * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。
 * 如果小数点后数值大于等于 0.5 ,向上取整；小于 0.5 ，则向下取整。
 * 数据范围：保证输入的数字在 32 位浮点数范围内
 * 示例1
 * 输入：
 * 5.5
 * 输出：
 * 6
 * 说明：
 * 0.5>=0.5，所以5.5需要向上取整为6
 * @Author lipeng
 * @Date 2022/7/19 15:31
 * @Version 1.0
 */
public class StartDemo_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num = scanner.nextDouble();
        int res = 0;
        if(num%1<0.5){
            res = (int)num;
        }else{
            res = (int)num+1;
        }
        System.out.println(res);
    }
}
