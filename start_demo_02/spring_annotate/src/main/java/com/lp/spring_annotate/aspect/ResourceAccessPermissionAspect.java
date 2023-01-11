package com.lp.spring_annotate.aspect;

import com.lp.spring_annotate.annotation.DemoAnnotation;
import com.lp.spring_annotate.el.ExpressionEvaluator;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.expression.AnnotatedElementKey;
import org.springframework.expression.EvaluationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * aop实现参数注入
 * @Author lipeng
 * @Date 2023/1/11 9:55
 * @Version 1.0
 */

@Component
@Aspect
@Slf4j
public class ResourceAccessPermissionAspect {
    private ExpressionEvaluator<String> evaluator = new ExpressionEvaluator<>();

    @Pointcut("@annotation(com.lp.spring_annotate.annotation.DemoAnnotation)")
    private void pointCut() {}

    @Before("pointCut()")
    public void doPermission(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        DemoAnnotation permission = method.getAnnotation(DemoAnnotation.class);
        if (joinPoint.getArgs() == null) {
            return;
        }

        // [重点]EL表达式的方式读取对应参数值
        EvaluationContext evaluationContext = evaluator.createEvaluationContext(joinPoint.getTarget(),
                joinPoint.getTarget().getClass(), ((MethodSignature) joinPoint.getSignature()).getMethod(),
                joinPoint.getArgs());
        AnnotatedElementKey methodKey =
                new AnnotatedElementKey(((MethodSignature) joinPoint.getSignature()).getMethod(),
                        joinPoint.getTarget().getClass());

        // 读取objectID，如果以#开头则按照EL处理，否则按照普通字符串处理
        String objectId;
        if (StringUtils.startsWith(permission.objectId(), "#")) {
            objectId = evaluator.condition(permission.objectId(), methodKey, evaluationContext, String.class);
        } else {
            objectId = permission.objectId();
        }

        // TODO 对objectID进行业务自定义逻辑处理
    }
}


