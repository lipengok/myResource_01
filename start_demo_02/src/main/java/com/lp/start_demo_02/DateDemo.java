package com.lp.start_demo_02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Calendar;
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

        // String str = formatDate(new Date(System.currentTimeMillis()));
        // System.out.println(str);

        // localdate-plusdate
        // plusDaysDemo();

//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(new Date());
//        int yd = calendar.get(Calendar.DAY_OF_YEAR);
//        int md = calendar.get(Calendar.DAY_OF_MONTH);
//        System.out.println("yd"+yd);
//        System.out.println("md"+md);
//
//        calendar.add(Calendar.DAY_OF_MONTH, 12);
//        md = calendar.get(Calendar.DAY_OF_MONTH);
//        System.out.println("md"+md);
//
//        calendar.set(Calendar.DAY_OF_MONTH, 1);
//        md = calendar.get(Calendar.DAY_OF_MONTH);
//        System.out.println("md"+md);


        Date start = new Date();
        // 2023-05-19 00:00:00
        start.setTime(1684425600);

        Date end = new Date();
        // 2023-05-25 00:00:00
        end.setTime(1684944000);

        System.out.println(getPoint(start, end, (short)96));

        System.out.println((1684944000000L-1684425600000L) / (96 * 1000));
    }

    public static short getPoint(Date startTime, Date endTime, short freezeCycleNum) {
        Calendar startCalTime = Calendar.getInstance();
        startCalTime.setTime(startTime);
        startCalTime.set(Calendar.MILLISECOND, 0);
        startCalTime.set(Calendar.SECOND, 0);

        Calendar endCalTime = Calendar.getInstance();
        endCalTime.setTime(endTime);
        endCalTime.set(Calendar.MILLISECOND, 0);
        endCalTime.set(Calendar.SECOND, 0);

        short pointNum = (short) ((endCalTime.getTimeInMillis() - startCalTime.getTimeInMillis())
                / (freezeCycleNum * 1000));
        return pointNum;

    }

    private static final String PATTERN = "yyyy-MM-dd hh:mm:ss";

    /**
     * 日期格式化成字符串
     *
     * @param date
     */
    private static String formatDate(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(PATTERN);
        return simpleDateFormat.format(date);
    }

    private static Date parseDate(String dateString) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(PATTERN);
        Date date = simpleDateFormat.parse(dateString);
        return date;
    }

    private static void locDateTimeDemo() {
        System.out.println("#############LocalDateTime Demo#############");
        LocalDateTime localDateTime1 = LocalDateTime.of(2022, Month.AUGUST, 24, 11, 30, 26, 501);
        System.out.println("第一种初始化方式：" + localDateTime1);
        int year = localDateTime1.getYear();
        System.out.println("year" + year);
        int month = localDateTime1.getMonth().getValue();
        System.out.println("month" + month);
        int day1 = localDateTime1.getDayOfMonth();
        System.out.println("getDayOfMonth" + day1);
        int day2 = localDateTime1.getDayOfYear();
        System.out.println("getDayOfYear" + day2);
        LocalDate localDate = localDateTime1.toLocalDate();
        System.out.println(localDate);
    }

    private void test() {
        // 初始化时间
        LocalDateTime localDateTime1 = LocalDateTime.of(2022, Month.AUGUST, 22, 11, 30, 26, 501);
        System.out.println("dateTime1：" + localDateTime1);

        LocalDateTime localDateTime2 = truncTimeTag(96, localDateTime1);
        System.out.println("dateTime2：" + localDateTime2);
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

    public static void plusDaysDemo() {
        LocalDate date = LocalDate.now();
        System.out.println(date);
        LocalDate date1 = date.plusDays(0);
        System.out.println(date1);
    }
}
