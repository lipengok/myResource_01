package com.lp.springbootbuslog.aop;

import com.lp.springbootbuslog.entity.SysLog;
import com.lp.springbootbuslog.listener.EventPubListener;
import com.lp.springbootbuslog.utils.IpUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @Author lipeng
 * @Date 2022/10/28 13:59
 * @Version 1.0
 */
@Aspect
@Component
public class SysLogAspect {

    private final Logger logger = LoggerFactory.getLogger(SysLogAspect.class);

    @Autowired
    private EventPubListener eventPubListener;

    /**
     * 以注解所标注的方法作为切入点
     * 将Log注解作为切入点
     */
    @Pointcut("@annotation(com.lp.springbootbuslog.aop.Log)")
    public void sysLog() {}


    /**
     * 在切点之后织入
     * @throws Throwable
     */
    @After("sysLog()")
    public void doAfter(JoinPoint joinPoint) {
        // 从注解中获取各种参数
        Log log = ((MethodSignature) joinPoint.getSignature()).getMethod()
                .getAnnotation(Log.class);
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String method = request.getMethod();

        String url = request.getRequestURL().toString();
        String ip = IpUtils.getIpAddr(request);
        SysLog sysLog = new SysLog();
        sysLog.setBusinessType(log.businessType().getCode());
        sysLog.setTitle(log.title());
        sysLog.setRequestMethod(method);
        sysLog.setOperIp(ip);
        sysLog.setOperUrl(url);
        // 从登录中token获取登录人员信息即可
        sysLog.setOperName("jack");
        sysLog.setOperTime(Timestamp.valueOf(LocalDateTime.now()));
        // 发布消息
        eventPubListener.pushListener(sysLog);
        logger.info("=======日志发送成功，内容：{}",sysLog);
    }
}


