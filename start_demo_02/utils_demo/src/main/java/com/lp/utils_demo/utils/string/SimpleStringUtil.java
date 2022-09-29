package com.lp.utils_demo.utils.string;

/**
 * @Author lipeng
 * @Date 2022/9/27 10:21
 * @Version 1.0
 */
public class SimpleStringUtil {

    public static String subStr(String str, int startIndex){
        // 取 ”：“ 之后的内容
        str = str.split(":")[1];
        String subStr = str.substring(startIndex, str.length());

        // 将字符串首尾空格去除
        return subStr.trim();
    }
}
