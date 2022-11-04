package com.lp.start_demo_02.leetcode.字符串转换整数;

/**
 * @Author lipeng
 * @Date 2022/7/26 13:52
 * @Version 1.0
 */
//请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
//
// 函数 myAtoi(string s) 的算法如下：
//
//
// 读入字符串并丢弃无用的前导空格
// 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
// 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
// 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤
//2 开始）。
// 如果整数数超过 32 位有符号整数范围 [−231, 231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固
//定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
// 返回整数作为最终结果。
//
//
// 注意：
//
//
// 本题中的空白字符只包括空格字符 ' ' 。
// 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
//
//
//
//
// 示例 1：
//
//
//输入：s = "42"
//输出：42
//解释：加粗的字符串为已经读入的字符，插入符号是当前读取的字符。
//第 1 步："42"（当前没有读入字符，因为没有前导空格）
//         ^
//第 2 步："42"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
//         ^
//第 3 步："42"（读入 "42"）
//           ^
//解析得到整数 42 。
//由于 "42" 在范围 [-231, 231 - 1] 内，最终结果为 42 。
//
// 示例 2：
//
//
//输入：s = "   -42"
//输出：-42
//解释：
//第 1 步："   -42"（读入前导空格，但忽视掉）
//            ^
//第 2 步："   -42"（读入 '-' 字符，所以结果应该是负数）
//             ^
//第 3 步："   -42"（读入 "42"）
//               ^
//解析得到整数 -42 。
//由于 "-42" 在范围 [-231, 231 - 1] 内，最终结果为 -42 。
//
//
// 示例 3：
//
//
//输入：s = "4193 with words"
//输出：4193
//解释：
//第 1 步："4193 with words"（当前没有读入字符，因为没有前导空格）
//         ^
//第 2 步："4193 with words"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
//         ^
//第 3 步："4193 with words"（读入 "4193"；由于下一个字符不是一个数字，所以读入停止）
//             ^
//解析得到整数 4193 。
//由于 "4193" 在范围 [-231, 231 - 1] 内，最终结果为 4193 。
//
//
//
//
// 提示：
//
//
// 0 <= s.length <= 200
// s 由英文字母（大写和小写）、数字（0-9）、' '、'+'、'-' 和 '.' 组成
//
// Related Topics 字符串
// 👍 1472 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    public static void main(String[] args) {
        int res = myAtoi("   -42");
        System.out.println(res);
    }

    private static int myAtoi(String s) {
        // 字符串转成字符串数组
        char[] chars = s.toCharArray();
        String res = "";
        int flag = 0;
        int index = 0;
        // 遍历字符数组，筛选出转成int类型范围在48-57的字符而且数字前面有‘-’也要一并输出
        for (int i = 0; i < chars.length; i++) {
            int a = chars[i];
            if (a >= 48 && a <= 57) {
                res += chars[i];
                flag = flag + 1;
            }
            if (flag == 1) {
                index = i;
            }
        }
        // 获取筛选出的数字的第一个字符在输入字符的坐标
        // 根据坐标，获取坐标的前一位的字符，如果是'-'，则添加到结果字符串的首位
        if (index != 0) {
            if ('-' == s.charAt(index - 1)) {
                res = "-" + res;
            }
        }
        return Integer.parseInt(res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

