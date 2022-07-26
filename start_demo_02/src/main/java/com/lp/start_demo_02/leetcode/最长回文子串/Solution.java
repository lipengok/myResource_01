package com.lp.start_demo_02.leetcode.最长回文子串;

import java.util.ArrayList;

/**
 * @Author lipeng
 * @Date 2022/7/25 15:33
 * @Version 1.0
 */
//给你一个字符串 s，找到 s 中最长的回文子串。
//
//
//
// 示例 1：
//
//
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
//
//
// 示例 2：
//
//
//输入：s = "cbbd"
//输出："bb"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 1000
// s 仅由数字和英文字母组成
//
// Related Topics 字符串 动态规划
// 👍 5491 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    public static void main(String[] args) {

    }
    // 判断字符串中的最长回文片段
    private static String longestPalindrome(String s) {
        int len = s.length();
        ArrayList<String> list = new ArrayList<>();
        char[] chars = s.toCharArray();
        if (check(s)){
            return reverse(s);
        }
        if (len == 1){
            return s;
        }
        for (int i = 2; i <= len; i++) {
            String str1 = "";
            for (int i1 = 0; i1 < i; i1++) {
                str1+=chars[i1];
                if (check(str1)){
                    list.add(str1);
                }
            }
        }

        return getLen(list);
    }

    // 判断一个字符串是不是回文
    private static boolean check(String s){
        char[] chars = s.toCharArray();
        boolean flag = true;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] != s.charAt(chars.length-1)){
                flag = false;
            }
        }
        return flag;
    }
    // 将字符串反转
    private static String reverse(String s){
        char[] chars = s.toCharArray();
        String string = "";
        for (int i = 0; i < chars.length; i++) {
            string+=chars[chars.length-i];
        }
        return string;
    }
    // 找出列表中字符串长度最长的字符串
    private static String getLen(ArrayList<String> list){
        String res = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length()>res.length()){
                res = list.get(i);
            }
        }
        return res;
    }
}
