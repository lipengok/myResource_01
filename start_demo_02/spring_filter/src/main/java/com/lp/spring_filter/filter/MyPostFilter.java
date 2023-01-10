package com.lp.spring_filter.filter;

import com.alibaba.fastjson2.JSON;
import com.lp.spring_filter.enity.Address;
import com.lp.spring_filter.filter.wapper.RequestWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author lipeng
 * @Date 2023/1/9 14:42
 * @Version 1.0
 */
@Slf4j
@Order(value = 2)   // 优先级设置
@WebFilter(urlPatterns = "/filter/addAddr/*", filterName = "myPostFilter")
public class MyPostFilter implements Filter {
    /**
     * 在ioc容器实例化filter前用此方法
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("过滤器初始化完成");
    }

    /**
     * 对请求数据进行拦截处理并使用
     * @param servletRequest    请求
     * @param servletResponse   响应
     * @param filterChain       过滤链
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("过滤器真正的业务执行");

        // 业务模拟：过滤出来请求中的cookie信息，并且打印在日志文件当中。
        // 业务模拟：获取请求的信息，将敏感信息剔除掉。

        // 从post请求中获取请求体中的数据
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse)servletResponse;

        RequestWrapper requestWrapper = new RequestWrapper(httpServletRequest);
        String param = requestWrapper.getBodyString();
        log.info(param);
        Address address = JSON.parseObject(param, Address.class);
        log.info("uId:"+address.getUId());
        log.info(address.toString());

        // 如果还有过滤链，交给下一个过滤器处理
        filterChain.doFilter(requestWrapper, httpServletResponse);
    }

    /**
     * 在ioc容器销毁filter实例前用此方法
     */
    @Override
    public void destroy() {
        log.info("过滤器销毁");
    }
}
