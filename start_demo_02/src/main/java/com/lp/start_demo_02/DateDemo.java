package com.lp.start_demo_02;

import java.time.*;
import java.util.Date;

/**
 * @Author lipeng
 * @Date 2022/8/19 15:04
 * @Version 1.0
 */
public class DateDemo {
    public static void main(String[] args) {
        new DateDemo().test();
    }

    private void test(){
        // 初始化时间
        LocalDateTime localDateTime1 = LocalDateTime.of(2022, Month.AUGUST, 22, 11, 30, 26,501);
        System.out.println("dateTime1："+localDateTime1);

        LocalDateTime localDateTime2 = truncTimeTag(96, localDateTime1);
        System.out.println("dateTime2："+localDateTime2);
    }

    // 时标处理
    private LocalDateTime truncTimeTag(int cycleNum, LocalDateTime dateTime) {
        switch (cycleNum) {
            case 24:
                dateTime = dateTime.withMinute(0);
                break;
            case 48:
                dateTime = dateTime.withMinute(dateTime.getMinute() < 30 ? 0 : 30);
                break;
            case 96:
                dateTime = dateTime.withMinute(dateTime.getMinute() / 15 * 15);
                break;
            default:
                int interval = 1440 / cycleNum;
                dateTime = dateTime.withMinute(dateTime.getMinute() / interval * interval);
                break;
        }
        dateTime = dateTime.withSecond(0);
        dateTime = dateTime.withNano(0);
        return dateTime;
    }

    // LocalDateTime2Date处理
    private static Date LocalDateTime2Date(LocalDateTime localDateTime) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        return Date.from(instant);
    }
}
