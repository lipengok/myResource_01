package com.lp.zk_curator.util;

import java.util.ArrayList;
import java.util.List;

/**
 * List工具类
 *
 * @Author lipeng
 * @Date 2023/6/9 11:09
 * @Version 1.0
 */
public class ListUtil {

    /**
     * List转成ArrayList
     *
     * @param list
     * @return
     */
    public static ArrayList<Object> toArrayListObject(List<Object> list){
        ArrayList<Object> objects = new ArrayList<>();
        for (Object object : list) {
            objects.add(object);
        }
        return objects;
    }

    /**
     * List转成ArrayList
     *
     * @param list
     * @return
     */
    public static ArrayList<String> toArrayListString(List<String> list){
        ArrayList<String> strings = new ArrayList<>();
        for (String string : list) {
            strings.add(string);
        }
        return strings;
    }
}
