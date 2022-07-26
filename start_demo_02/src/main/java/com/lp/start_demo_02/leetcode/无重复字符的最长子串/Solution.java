package com.lp.start_demo_02.leetcode.无重复字符的最长子串;

/**
 * @Author lipeng
 * @Date 2022/7/25 15:15
 * @Version 1.0
 */
//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
//
//
//
// 示例 1:
//
//
//输入: s = "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
//
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
//
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
//
//
//
// 提示：
//
//
// 0 <= s.length <= 5 * 104
// s 由英文字母、数字、符号和空格组成
//
// Related Topics 哈希表 字符串 滑动窗口
// 👍 7880 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static void main(String[] args) {
        int count = lengthOfLongestSubstring("yuhhhhoollp");
        System.out.println(count);
    }
    private static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int count = 0;
        boolean[] tmp = new boolean[1024];
        for (int i = 0; i < chars.length; i++) {
            if (!tmp[chars[i]]){
                count++;
            }
            tmp[chars[i]]=true;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

