package com.lp.start_demo_02;

/**
 * 字符串操作
 * @Author lipeng
 * @Date 2022/8/25 16:15
 * @Version 1.0
 */
public class StringDemo {

    public static void main(String[] args) {
        // String primaryKey = "2122D83C";
        // String str = "21044c77";
        // String str2 = "aN4A3gBoiAEiZmZmZioJYAAAAQBGQwAARkM2OTNBAABWMS4wBgMXOUcyNTY0MTI4AAAxMzc2VjEuNAQIFJcW";
        // demo(str1);
        // System.out.println(demo1(str1));
        // System.out.println(str.getBytes()[5]);
        // demo4(str2.getBytes());

        // 数字字符串转成整形字符串
//        String str1 = "111";
//        int[] temps = strToIntArray(str1);
//        StringBuilder str = new StringBuilder();
//        for (int i = 0; i < temps.length; i++) {
//            str.append(temps[i]);
//        }
//        System.out.println(str.toString());

    }


    private static void demo(String str) {
        System.out.println(str.substring(0,4));
        System.out.println(str.substring(4));
    }

    private static String demo1(String str) {
        int pare = Integer.parseInt(str.substring(4, str.length()));
        return str.substring(0, 4).concat(String.format("%04X", pare));
    }

    private static void demo3(byte[] bytes) {
        System.out.println(bytes[5]&0xFF);
    }

    private static void demo4(byte[] bytes) {
        System.out.println(Byte.toString(bytes[12]));
        System.out.println(bytes[12]&0x0F);
        System.out.println(bytes[12]&0xFF);
        System.out.println(bytes[14]&0xFF);
        System.out.println(bytes[12]>16? bytes[14]&0xFF:bytes[12]&0xFF);;
    }

    /**
     * 数字字符串转成int数组
     */
    public static int[] strToIntArray(String inStr){
        char[] chars = inStr.toCharArray();
        int[] temps = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            temps[i] = chars[i]-48;
        }
        return temps;
    }
}
