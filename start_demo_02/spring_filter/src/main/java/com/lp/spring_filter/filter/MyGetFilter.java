package com.lp.spring_filter.filter;


import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @Author lipeng
 * @Date 2023/1/10 14:30
 * @Version 1.0
 */
@Slf4j
@Order(value = 1)   // 优先级设置
@WebFilter(urlPatterns = "/filter/addrList/*", filterName = "myGetFilter")
public class MyGetFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse)servletResponse;

        Map map = httpServletRequest.getParameterMap();
        Set<String> set = map.keySet();
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            String value = iterator.next();
            log.info(value+"=>[{}]", map.get(value));
        }
        // 如果还有过滤链，交给下一个过滤器处理
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    @Override
    public void destroy() {

    }
}
