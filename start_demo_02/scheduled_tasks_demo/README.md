# 简介

## springboot自带的定时任务
@Schedule <br>
使用起来比较方便。<br>
@EnableScheduling：启动定时任务功能。<br>
@Scheduled(cron="0/2 * * * * ?")：设置定时的规则（每2秒执行一次）。<br>
cron的规则说明：<br>
0 0 0 * * *         -- 每天零时执行一次<br>
0 0/15 14,18 * * ?  -- 每天14点整和18点整，每隔15分钟执行一次<br>
0 15 10 ? * 1-6     -- 每个月的周一到周六 10:15分执行一次<br>
0 0 2 ? * 6L        -- 每个月的最后一个周六凌晨2点执行一次<br>
0 0 2 LW * ?        -- 每个月的最后一个工作日凌晨2点执行一次<br>
0 0 2-4 ? * 1#1     -- 每个月的第一个周一凌晨2点到4点期间，每个整点都执行一次<br>

@Scheduled(fixedRate = 5000)：上一次 项目启动时间点之后 5 秒执行一次。<br>
@Scheduled(initialDelay = 50000,fixedRate = 6000)：第一次延迟50秒执行，之后按照fixedRate的规则每6秒执行一次<br>

## 第三方插件quartz
quartz支持集群定时任务。


## 基础的定时方案
