package com.lp.start_demo_02.leetcode.两数之和;

//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
//
// 你可以按任意顺序返回答案。
//
//
//
// 示例 1：
//
//
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
//
//
// 示例 2：
//
//
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
//
//
// 示例 3：
//
//
//输入：nums = [3,3], target = 6
//输出：[0,1]
//
//
//
//
// 提示：
//
//
// 2 <= nums.length <= 104
// -109 <= nums[i] <= 109
// -109 <= target <= 109
// 只会存在一个有效答案
//
//
// 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
// Related Topics 数组 哈希表
// 👍 14909 👎 0

/**
 * @Author lipeng
 * @Date 2022/8/2 16:00
 * @Version 1.0
 */
public class Solution {
    public static void main(String[] args) {
        int[] pa = {1,3,9,6,3};
        //int[] res = twoSum(pa, 6);
        int[] res = twoSum2(pa, 6);
        String str = "["+res[0]+","+res[1]+"]";
        System.out.println(str);
    }

    private static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i!=j){
                    if (nums[i]+nums[j]==target){
                        res[0] = i;
                        res[1] = j;
                    }
                }
            }
        }
        return res;
    }

    private static int[] twoSum2(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]+nums[nums.length-i-1] == target){
                res[0] = i;
                res[1] = nums.length-i-1;
            }
        }
        return res;
    }
}
