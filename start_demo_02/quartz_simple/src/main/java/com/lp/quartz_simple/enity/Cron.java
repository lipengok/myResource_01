package com.lp.quartz_simple.enity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * cron表达式的实体类
 *
 * @Author lipeng
 * @Date 2023/6/12 10:31
 * @Version 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cron {

    private static StringBuilder cron = new StringBuilder();

    // 秒, 取值是0 ~ 59
    private String second;
    // 间隔数（单位秒）
    private String s_interval;

    // 分. 取值是0 ~ 59
    private String min;
    private String m_interval;

    // 小时, 取值是0 ~ 23
    private String hour;
    private String h_interval;

    // 天/日, 取值是0 ~ 31
    private String day;
    private String d_interval;

    // 月份, 取值是1 ~ 12
    private String month;
    private String M_interval;

    // 星期, 取值是1 ~ 7, 星期一，星期二...， 还有 1 表示星期日
    private String week;
    private String w_interval;

    /**
     * 生成cron表达式
     *
     * @return
     */
    public String gen(){

        trans(second, s_interval);
        trans(min, m_interval);
        trans(hour, h_interval);
        trans(day, d_interval);
        trans(month, M_interval);
        trans(week, w_interval);

        return cron.toString();
    }

    /**
     * 参数转换
     * @param unit      cron的单位
     * @param interval  cron单位对应的周期
     * @return
     */
    private static StringBuilder trans(String unit, String interval){
        if (null != unit){
            cron.append(unit);
            if (null != interval){
                cron.append("/")
                        .append(interval);
            }
            cron.append(" ");
        }else {
            cron.append("* ");
        }
        return cron;
    }

    public static void main(String[] args) {
        Cron cron = new Cron();
        cron.setSecond("0");
        cron.setS_interval("5");
        System.out.println(cron.gen());
    }
}
