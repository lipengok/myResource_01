package com.lp.start_demo_02;

/**
 * @Author lipeng
 * @Date 2023/3/15 10:01
 * @Version 1.0
 */
public class TestDemo {

    public static void main(String[] args) {
        System.out.println(transTmnlAddrHexToDec("800102AA"));
        System.out.println(transTmnlAddrDecToHex("80010682"));
    }

    /**
     * 将16进制终端地址转换为数据库中的十进制
     *
     * @param tmnlAddr
     * @return
     */
    public static String transTmnlAddrHexToDec(String tmnlAddr) {
        try {
            String tmpStr = null;
            int length = tmnlAddr.length();
            System.out.println(tmnlAddr.substring(0, 4));
            System.out.println(tmnlAddr.substring(4, length));
            if (length != 8) {
                return null;
            }
            int tmpAddr = Integer.parseInt(tmnlAddr.substring(4, length), 16);
            tmpStr = tmnlAddr.substring(0, 4).concat(Integer.toString(tmpAddr));
            return tmpStr;
        } catch (Exception e) {
            System.out.println("-----终端地址十六进制转十进制失败:[{}]");
            return null;
        }
    }

    /**
     * 将数据库中的十进制终端地址转换为16进制
     * @param tmnlAddr
     * @return
     */
    public static String transTmnlAddrDecToHex(String tmnlAddr) {
        String tmpStr = null;
        try {
            int length = tmnlAddr.length();
            if (length <= 4 || length > 9) {
                return tmnlAddr;
            }
            int tmpAddr = Integer.parseInt(tmnlAddr.substring(4, length));
            tmpStr = tmnlAddr.substring(0, 4).concat(String.format("%04X", tmpAddr));
        } catch (Exception ex) {
            return null;
        }
        return tmpStr;
    }
}
