package com.lp.scheduled_tasks_demo.controller;

import com.lp.scheduled_tasks_demo.schedule.sleep.SleepSchedule;
import com.lp.scheduled_tasks_demo.schedule.timer.TimerSchedule;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Timer;

/**
 * @Author lipeng
 * @Date 2022/10/11 9:31
 * @Version 1.0
 */
@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    // 启动sleep的定时任务
    @GetMapping("/sleep")
    public String sleepSchedule(){
        SleepSchedule sleepSchedule = new SleepSchedule();
        sleepSchedule.run();
        return "启动sleep的定时任务";
    }

    // 启动timer的定时任务
    @GetMapping("/timer")
    public String timerSchedule(){
        Timer timer = new Timer();
        // 延迟时间
        long delayTime = 0;
        // 间隔时间
        long stepTime = 1000;
        // 执行定时任务
        timer.scheduleAtFixedRate(new TimerSchedule(), delayTime, stepTime);
        return "启动timer的定时任务";
    }
}
