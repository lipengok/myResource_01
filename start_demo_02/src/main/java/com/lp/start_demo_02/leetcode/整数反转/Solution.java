package com.lp.start_demo_02.leetcode.整数反转;

//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−231, 231 − 1] ，就返回 0。
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
//
//
// 示例 1：
//
//
//输入：x = 123
//输出：321
//
//
// 示例 2：
//
//
//输入：x = -123
//输出：-321
//
//
// 示例 3：
//
//
//输入：x = 120
//输出：21
//
//
// 示例 4：
//
//
//输入：x = 0
//输出：0
//
//
//
//
// 提示：
//
//
// -231 <= x <= 231 - 1
//
// Related Topics 数学
// 👍 3578 👎 0

/**
 * @Author lipeng
 * @Date 2022/8/4 8:50
 * @Version 1.0
 */
public class Solution {
    public static void main(String[] args) {
        int a = -120;
        System.out.println(reverse(a));
    }

    private static int reverse(int x) {
        StringBuilder stringBuilder = null;
        int res = 0;
        if (x < 0) {
            stringBuilder = convert(-x);
            res = -Integer.parseInt(stringBuilder.toString());
        } else {
            stringBuilder = convert(x);
            res = Integer.parseInt(stringBuilder.toString());
        }
        return res;
    }

    // 将整数转换成int数组
    private static StringBuilder convert(int i) {
        StringBuilder res = new StringBuilder();
        while (true) {
            res.append(i % 10);
            i = i / 10;
            if (i == 0) {
                break;
            }
        }
        return res;
    }

    // 测试：循环打印
    private static void printFor(int[] ints) {
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
