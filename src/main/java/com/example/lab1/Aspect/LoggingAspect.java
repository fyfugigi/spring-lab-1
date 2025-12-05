package com.example.lab1.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Aspect
@Component
@Order(1)
public class LoggingAspect {

    private static final Logger logger = LogManager.getLogger(LoggingAspect.class);

    @Before("com.example.lab1.Aspect.MyPointcuts.allGetMethods()")
    public void beforeGetAdvice(JoinPoint jp) {
        MethodSignature sig = (MethodSignature) jp.getSignature();
        logger.info("Before GET method: {}", sig.getName());
    }

    @Before("com.example.lab1.Aspect.MyPointcuts.allModifyMethods()")
    public void beforeModifyAdvice(JoinPoint jp) {
        MethodSignature sig = (MethodSignature) jp.getSignature();
        logger.info("Before MODIFY method: {}", sig.getName());
    }

    @AfterReturning(pointcut = "com.example.lab1.Aspect.MyPointcuts.controllerMethods()", returning = "result")
    public void afterControllerReturningAdvice(JoinPoint jp, Object result) {
        logger.info("Controller {} returned: {}", jp.getSignature().getName(), result);
    }

    @AfterThrowing(pointcut = "com.example.lab1.Aspect.MyPointcuts.allGetMethods()", throwing = "ex")
    public void afterGetThrowingAdvice(Exception ex) {
        logger.error("Exception in GET method: {}", ex.getMessage(), ex);
    }
}
