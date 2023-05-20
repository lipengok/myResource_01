package com.lp.start_demo_02;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author lipeng
 * <p>
 * localTime参考：https://blog.csdn.net/weixin_49114503/article/details/121651459
 * @Date 2023/5/18 9:20
 * @Version 1.0
 */
public class TimeDemo {

    public static void main(String[] args) {

    }

    // 计算两个时间点相差的时间
    private static void getTimeStep() {
        LocalTime start = LocalTime.parse("10:51:01.167526700");
        LocalTime end = LocalTime.parse("15:52:03.167526701");

        //between的用法是end-start的时间，若start的时间大于end的时间，则所有的值是负的
        Duration duration = Duration.between(start, end);
        System.out.println("两个时间相差：" + duration.toMillis() + "秒，相差：" + duration.toHours() + "小时，相差：" + duration.toMinutes() + "分钟");

    }

    // LocalDate ->只对年月日做出处理

    /**
     * .LocalTime ->只对时分秒纳秒做出处理
     * 获取时分秒
     *
     * @return
     */
    private static Map<String, Integer> localTimeFun() {
        Map<String, Integer> map = new HashMap<>();
        LocalTime time = LocalTime.now();
        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();
        map.put("hour", hour);
        map.put("minute", minute);
        map.put("second", second);
        return map;
    }

    /**
     * calendar方式获取时间
     *
     * @param date
     * @return
     */
    private static Map<String, Integer> calendarFun(Date date) {
        Map<String, Integer> map = new HashMap<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        map.put("hour", hour);
        map.put("minute", minute);
        map.put("second", second);
        return map;
    }
}
