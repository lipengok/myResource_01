package com.lp.start_demo_02.leetcode.两数相加;

//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
//
//
// 示例 1：
//
//
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
//
//
// 示例 2：
//
//
//输入：l1 = [0], l2 = [0]
//输出：[0]
//
//
// 示例 3：
//
//
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
//
//
//
//
// 提示：
//
//
// 每个链表中的节点数在范围 [1, 100] 内
// 0 <= Node.val <= 9
// 题目数据保证列表表示的数字不含前导零
//
// Related Topics 递归 链表 数学
// 👍 8428 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;

/**
 * @Author lipeng
 * @Date 2022/8/3 8:47
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(9);
        arr1.add(9);
        arr1.add(9);
        arr1.add(9);
        arr1.add(9);
        arr1.add(9);
        arr1.add(9);
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(9);
        arr2.add(9);
        arr2.add(9);
        arr2.add(9);

        System.out.println(reversArr(addTwoNumbers(arr1, arr2)));
    }

    public static ArrayList<Integer> addTwoNumbers(ArrayList<Integer> l1, ArrayList<Integer> l2) {
        Integer i1 = reversInteger(l1);
        Integer i2 = reversInteger(l2);
        return arrToInteger(i1 + i2);
    }

    // 将数组内的元素倒叙并转换成int类型
    private static Integer reversInteger(ArrayList<Integer> arr) {
        String str = "";
        for (int i = 0; i < arr.size(); i++) {
            arr.set(i, arr.get(arr.size() - i - 1));
            str += arr.get(i);
        }
        return Integer.parseInt(str);
    }

    // 将数字转换成字符串
    private static ArrayList<Integer> arrToInteger(Integer integer) {
        ArrayList<Integer> list = new ArrayList<>();
        char[] chars = integer.toString().toCharArray();
        for (char aChar : chars) {
            list.add(Integer.parseInt(aChar + ""));
        }
        return list;
    }

    private static ArrayList<Integer> reversArr(ArrayList<Integer> arr) {
        ArrayList list = new ArrayList();
        for (int i = 0; i < arr.size(); i++) {
            list.add(i, arr.get(arr.size() - i - 1));
        }
        return list;
    }
}
