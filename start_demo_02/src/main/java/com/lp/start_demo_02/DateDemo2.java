package com.lp.start_demo_02;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @Author lipeng
 * @Date 2023/6/7 10:42
 * @Version 1.0
 */
public class DateDemo2 {

    public static void main(String[] args) {
        // 使用12小时制
        // SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        // 使用24小时制
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date now = new Date();
        System.out.println(format.format(now));

        String date1 = format.format(setNight(now));
        System.out.println(date1);
    }

    /**
     * 将指定时间的 ”时分秒“ 置0
     *
     * @param date
     * @return
     */
    private static Date setNight(Date date){
        // 使用北京时区
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }
}
