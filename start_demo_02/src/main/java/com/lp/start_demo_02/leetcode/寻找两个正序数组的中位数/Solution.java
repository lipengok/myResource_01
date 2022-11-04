package com.lp.start_demo_02.leetcode.寻找两个正序数组的中位数;


//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
//
// 算法的时间复杂度应该为 O(log (m+n)) 。
//
//
//
// 示例 1：
//
//
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
//
//
// 示例 2：
//
//
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
//
//
//
//
//
//
// 提示：
//
//
// nums1.length == m
// nums2.length == n
// 0 <= m <= 1000
// 0 <= n <= 1000
// 1 <= m + n <= 2000
// -106 <= nums1[i], nums2[i] <= 106
//
// Related Topics 数组 二分查找 分治
// 👍 5705 👎 0

/**
 * @Author lipeng
 * @Date 2022/8/3 13:48
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {
        int[] i1 = {1, 2};
        int[] i2 = {6, 4, 5, 3, 3};
        // 二分法
        System.out.println(search(i1, 2));
        System.out.println(findMedianSortedArrays(i1, i2));
        // printDemo(combine(i1,i2));
        printDemo(sort(combine(i1, i2)));
    }

    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] tmp = sort(combine(nums1, nums2));
        if (tmp.length % 2 == 1) {
            return tmp[tmp.length / 2];
        } else {
            return (tmp[tmp.length / 2] + tmp[tmp.length / 2 - 1]) / 2;
        }
    }

    // 将数组合并
    private static int[] combine(int[] nums1, int[] nums2) {
        int[] tms = new int[nums1.length + nums2.length];

        for (int i = 0; i < nums1.length; i++) {
            tms[i] = nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            tms[i + nums1.length] = nums2[i];
        }

        return tms;
    }

    // 数组排序(冒泡排序)
    private static int[] sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int a = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = a;
                }
            }
        }
        return nums;
    }

    // 数组排序 二分法 查找
    private static int search(int[] nums, int queryNum) {
        int start = 0;
        int end = nums.length - 1;
        int mid = (start + end) / 2;
        while (true) {
            if (start > end) {//起始值应始终小于结束值,如果大于,则没有搜索到相关的值
                return -1;
            }
            if (nums[mid] == queryNum) {
                return mid;
            } else if (nums[mid] > queryNum) {
                end = mid - 1;
                mid = (start + end) / 2;
            } else if (nums[mid] < queryNum) {
                start = mid + 1;
                mid = (start + end) / 2;
            }
        }
    }

    // 打印数组，测试用
    private static void printDemo(int[] arr) {
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
