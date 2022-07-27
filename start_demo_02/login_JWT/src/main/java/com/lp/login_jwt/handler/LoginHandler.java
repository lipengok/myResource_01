package com.lp.login_jwt.handler;

import com.alibaba.fastjson.JSON;
import com.lp.login_jwt.model.dto.UserTokenDto;
import com.lp.login_jwt.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 * @Author lipeng
 * @Date 2022/7/27 15:17
 * @Version 1.0
 */
@Component
@Slf4j
public class LoginHandler implements HandlerInterceptor {

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 进入Controller层之前拦截请求，默认是拦截所有请求
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        log.info("进入Controller层之前拦截请求，默认是拦截所有请求");
        boolean flag = false;
        try {
            String authorToken = httpServletRequest.getHeader("Authorization");
            String token = authorToken.substring("Bearer".length() + 1).trim();
            UserTokenDto userTokenDto = (UserTokenDto) JSON.parse(token);
            String tokenKey = String.valueOf(userTokenDto.getUserId());
            String redisToken = redisUtil.get(tokenKey);
            if (redisToken!=null && token==redisToken){
                flag = true;
                // 濒临到期的token，自动续期
                Long time = redisUtil.getExpireTime(tokenKey);
                if (time < 1*30*60){
                    redisUtil.set(tokenKey, token);
                    log.info("濒临到期的token：用户的token自动续期");
                }
            }
        }catch (Exception e){
            log.error("用户认证失败", e);
        }

        return flag;
    }

    /**
     * 处理完请求后但还未渲染试图之前进行的操作
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        log.info("处理完请求后但还未渲染试图之前进行的操作");
    }

    /**
     * 视图渲染后但还未返回到客户端时的操作
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        log.info("视图渲染后但还未返回到客户端时的操作");
    }


}
