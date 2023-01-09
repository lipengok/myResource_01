package com.lp.spring_filter.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Author lipeng
 * @Date 2023/1/9 14:42
 * @Version 1.0
 */
@Slf4j
@Order(value = 2)   // 优先级设置
@WebFilter(urlPatterns = "/filter/*", filterName = "demoFilter")
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("过滤器初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("过滤器真正的业务执行");

        // 业务模拟：过滤出来请求中的cookie信息，并且打印在日志文件当中。

        // 当前过滤器处理完了交给下一个过滤器处理
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        log.info("过滤器销毁");
    }
}
