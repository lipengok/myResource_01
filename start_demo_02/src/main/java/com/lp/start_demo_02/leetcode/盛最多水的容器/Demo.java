package com.lp.start_demo_02.leetcode.盛最多水的容器;

import java.util.ArrayList;

/**
 * @Author lipeng
 * @Date 2022/7/26 14:55
 * @Version 1.0
 */
//给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
//
// 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//
// 返回容器可以储存的最大水量。
//
// 说明：你不能倾斜容器。
//
//
//
// 示例 1：
//
//
//
//
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
//
// 示例 2：
//
//
//输入：height = [1,1]
//输出：1
//
//
//
//
// 提示：
//
//
// n == height.length
// 2 <= n <= 105
// 0 <= height[i] <= 104
//
// Related Topics 贪心 数组 双指针
// 👍 3666 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class Demo {
    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        int max = maxArea(height);
        System.out.println(max);
    }
    private static int maxArea(int[] height) {
        int max = 0;
        // 遍历数组
        for (int i = 1; i <= height.length; i++) {
            // 第n条线的x
            int x1 = i;
            // 第n条线的y
            int y1 = height[i-1];
            for (int i1 = 1; i1 <= height.length; i1++) {
                // 第n条线的x
                int x2 = i1;
                // 第n条线的y
                int y2 = height[i1-1];
                int element2 = docker(x1,y1,x2,y2);
                if (element2>max){
                    max = element2;
                }
            }
        }
        return max;
    }

    // 计算两个坐标(x1,y1)(x2,y2)与x轴组成的最大存水量
    private static int docker(int x1,int y1,int x2,int y2){
        int len = Math.abs(x2-x1);
        int width = Math.max(y1,y2)-Math.abs(y1-y2);
        return len*width;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
