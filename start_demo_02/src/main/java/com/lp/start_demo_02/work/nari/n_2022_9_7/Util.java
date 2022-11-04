package com.lp.start_demo_02.work.nari.n_2022_9_7;

/**
 * @Author lipeng
 * @Date 2022/9/7 14:51
 * @Version 1.0
 */
public class Util {
    public static void main(String[] args) {
        String meterAddr1 = "0:1879987098";
        String meterAddr2 = "01: 1879987098 ";
        String meterAddr3 = ": 1879987098 ";
        String meterAddr4 = " 1879987098 ";

        System.out.println(convert(meterAddr1));
        System.out.println(convert(meterAddr2));
        System.out.println(convert(meterAddr3));
        System.out.println(convert(meterAddr4));
    }

    private static String convert(String meterAddr) {
        if (meterAddr.contains(":")) {
            String[] strings = meterAddr.split(":");
            return strings[1].trim();
        }
        return meterAddr.trim();
    }
}
