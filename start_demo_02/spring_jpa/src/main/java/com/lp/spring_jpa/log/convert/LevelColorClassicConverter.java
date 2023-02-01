package com.lp.spring_jpa.log.convert;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

/**
 * 日志模板：基于日志级别的颜色的转换器
 *
 * @Author lipeng
 * @Date 2023/1/30 9:17
 * @Version 1.0
 */
public class LevelColorClassicConverter extends ClassicConverter {

    private static final String END_COLOR = "\u001b[m";

    private static final String ERROR_COLOR = "\u001b[0;31m";

    private static final String WARN_COLOR = "\u001b[0;33m";

    @Override
    public String convert(ILoggingEvent event) {
        StringBuffer sbuf = new StringBuffer();
        sbuf.append(getColor(event.getLevel()));
        String result = String.format("%5s", event.getLevel());
        sbuf.append(result);
        sbuf.append(END_COLOR);
        return sbuf.toString();
    }

    /**
     * Returns the appropriate characters to change the color for the specified logging
     * level.
     */
    private String getColor(Level level) {
        switch (level.toInt()) {
            case Level.ERROR_INT:
                return ERROR_COLOR;
            case Level.WARN_INT:
                return WARN_COLOR;
            default:
                return "";
        }
    }
}
