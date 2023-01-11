package com.lp.spring_annotate.interceptor;

import com.lp.spring_annotate.annotation.AuthToken;
import com.lp.spring_annotate.annotation.UnAuthToken;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 拦截器
 *
 * 验证所有的url请求：那些需要验证，哪些不需要验证
 * @Author lipeng
 * @Date 2023/1/11 14:40
 * @Version 1.0
 */
public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        if (response.getStatus() == 404) {
            throw new Exception("路径没找到");
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        if (method.isAnnotationPresent(UnAuthToken.class)) {
            return true;
        }
        // 如果不是映射到方法查看controller层注解
        if (method.isAnnotationPresent(AuthToken.class) || handlerMethod.getBeanType().isAnnotationPresent(AuthToken.class)) {
            //登录验证
            AuthToken authToken = method.isAnnotationPresent(AuthToken.class) ? method.getAnnotation(AuthToken.class) : handlerMethod.getBeanType().getAnnotation(AuthToken.class);
            if (authToken.value()) {
                // 从 http 请求头中取出 token
                String token = request.getHeader("token");
                // token认证
                if (null == token) {
                    throw new Exception("token为空");
                }
            }
        }
        return true;
    }
}
