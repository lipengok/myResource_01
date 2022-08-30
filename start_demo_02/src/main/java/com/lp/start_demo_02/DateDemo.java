package com.lp.start_demo_02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;

/**
 * @Author lipeng
 * @Date 2022/8/19 15:04
 * @Version 1.0
 */
public class DateDemo {
    public static void main(String[] args) {
        // new DateDemo().test();
        // locDateTimeDemo();

        String str = formatDate(new Date(System.currentTimeMillis()));
        System.out.println(str);
    }

    private static final String PATTERN = "yyyy-MM-dd hh:mm:ss";

    /**
     * 日期格式化成字符串
     * @param date
     */
    private static String formatDate(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(PATTERN);
        return simpleDateFormat.format(date);
    }

    private static Date parseDate(String dateString) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(PATTERN);
        Date date = simpleDateFormat.parse(dateString);
        return date;
    }

    private static void locDateTimeDemo(){
        System.out.println("#############LocalDateTime Demo#############");
        LocalDateTime localDateTime1 = LocalDateTime.of(2022, Month.AUGUST, 24, 11, 30, 26,501);
        System.out.println("第一种初始化方式："+localDateTime1);
        int year = localDateTime1.getYear();
        System.out.println("year"+year);
        int month = localDateTime1.getMonth().getValue();
        System.out.println("month"+month);
        int day1 = localDateTime1.getDayOfMonth();
        System.out.println("getDayOfMonth"+day1);
        int day2 = localDateTime1.getDayOfYear();
        System.out.println("getDayOfYear"+day2);
        LocalDate localDate = localDateTime1.toLocalDate();
        System.out.println(localDate);
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
