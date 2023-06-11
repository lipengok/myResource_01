package com.lp.start_demo_02.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @Author lipeng
 * @Date 2023/6/9 16:42
 * @Version 1.0
 */
public class DateUtil {

    // 使用12小时制
    public static SimpleDateFormat format12 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    // 使用24小时制
    public static SimpleDateFormat format24 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    // 使用北京时区
    public static Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));

    /**
     * 将指定时间的 ”时分秒“ 置0
     *
     * @param date
     * @return
     */
    private static Date setNight(Date date){
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 将指定时间的 ”时分秒“ 置0
     *
     * @param date
     * @return
     */
    private static String setNightToString(Date date){
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return format24.format(calendar.getTime());
    }
}
