package com.lp.start_demo_02.leetcode.最长公共前缀;


/**
 * 递归
 * @Author lipeng
 * @Date 2022/7/29 10:45
 * @Version 1.0
 */
//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。
//
//
//
// 示例 1：
//
//
//输入：strs = ["flower","flow","flight"]
//输出："fl"
//
//
// 示例 2：
//
//
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。
//
//
//
// 提示：
//
//
// 1 <= strs.length <= 200
// 0 <= strs[i].length <= 200
// strs[i] 仅由小写英文字母组成
//
// Related Topics 字符串
// 👍 2362 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    public static void main(String[] args) {
        String[] str = new String[]{"flower","flow","flight"};
        String[] str1 = new String[]{"dog","racecar","car"};
        longestCommonPrefix(str);
    }
    private static String longestCommonPrefix(String[] strs) {
        String count2 = dell(strs[0],strs[1]);
        for (int i = 0; i < strs.length;i++) {
            // 获取字符串们同位置的相同字符，并输出
            String c = strs[i];
            count2 = dell(c,count2);
        }
        System.out.println(count2);
        return null;
    }

    // 获取字符串们同位置的相同字符，并输出
    private static String dell(String str1,String str2){
        String count = "";
        int len = Math.min(str1.length(),str2.length());
        for (int i = 0; i < len; i++) {
            char tmp = str1.charAt(i);
            char tmp2 = str2.charAt(i);
            if (tmp == tmp2){
                count+=tmp;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
