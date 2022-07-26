package com.lp.start_demo_02.leetcode.Z字形变换;

/**
 * @Author lipeng
 * @Date 2022/7/25 16:13
 * @Version 1.0
 */
// todo 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
//
// 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
//
//
//P   A   H   N
//A P L S I I G
//Y   I   R
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
//
// 请你实现这个将字符串进行指定行数变换的函数：
//
//
//string convert(string s, int numRows);
//
//
//
// 示例 1：
//
//
//输入：s = "PAYPALISHIRING", numRows = 3
//输出："PAHNAPLSIIGYIR"
//
//示例 2：
//
//
//输入：s = "PAYPALISHIRING", numRows = 4
//输出："PINALSIGYAHRPI"
//解释：
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
//
//
// 示例 3：
//
//
//输入：s = "A", numRows = 1
//输出："A"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 1000
// s 由英文字母（小写和大写）、',' 和 '.' 组成
// 1 <= numRows <= 1000
//
// Related Topics 字符串
// 👍 1743 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    public static void main(String[] args) {

    }
    private static String convert(String s, int numRows) {
        int len = s.length();
        // 二维数组列数
        int cells=0;
        if (len%3==0||len%3==2){
            cells = len/2;
        }else {
            cells = len/2+1;
        }
        // 二维数组行数
        int rows = numRows;
        // 构建二维数据
        char[][] arr = new char[rows][cells];
        char[] chars = s.toCharArray();
        for (int j = 0; j < len; j++) {
            if (len%rows!=0){
                // todo 特殊排序方式
                arr[j][0] = s.charAt(j);
            }
            for (int i = 0; i < cells; i++) {
                arr[i][0] = s.charAt(j);
            }
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
