package com.lp.queue_demo.util;

import com.lp.queue_demo.Globe.ComGlobe;

import javax.xml.crypto.Data;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author lipeng
 * @Date 2023/5/19 10:26
 * @Version 1.0
 */
public class TimeUtil {

    private static Calendar calendar = Calendar.getInstance();

    /**
     * 日期解析
     *
     * @param date 日期
     * @return
     */
    public static String parse(Date date){
        return ComGlobe.simpleDateFormat.format(date);
    }

    /**
     * 日期增加年
     *
     * @param date 日期
     * @param years 增加的年数
     * @return
     */
    public static Date addYear(Date date, int years){
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, years);
        return calendar.getTime();
    }

    /**
     * 日期增加月
     *
     * @param date 日期
     * @param months 增加的月数
     * @return
     */
    public static Date addMonth(Date date, int months){
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, months);
        return calendar.getTime();
    }

    /**
     * 日期增加天
     *
     * @param date 日期
     * @param days 增加的天数
     * @return
     */
    public static Date addDay(Date date, int days){
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, days);
        return calendar.getTime();
    }

    /**
     * 日期增加小时
     *
     * @param date 日期
     * @param hours 增加的小时数
     * @return
     */
    public static Date addHour(Date date, int hours){
        calendar.setTime(date);
        calendar.add(Calendar.HOUR, hours);
        return calendar.getTime();
    }

    /**
     * 日期增加分钟
     *
     * @param date 日期
     * @param minutes 增加的分钟数
     * @return
     */
    public static Date addMinute(Date date, int minutes){
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minutes);
        return calendar.getTime();
    }

    /**
     * 日期增加秒
     *
     * @param date 日期
     * @param seconds 增加的秒数
     * @return
     */
    public static Date addSecond(Date date, int seconds){
        calendar.setTime(date);
        calendar.add(Calendar.SECOND, seconds);
        return calendar.getTime();
    }
}
