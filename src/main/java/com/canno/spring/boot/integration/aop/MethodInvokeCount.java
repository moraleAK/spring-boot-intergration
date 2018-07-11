package com.canno.spring.boot.integration.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * @author Canno
 * @since 2018/7/10 15:08
 */
@Aspect
@Configuration
public class MethodInvokeCount {
    private static int invokeCount = 0;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Count visits that marked as {@link com.canno.spring.boot.integration.java18.animation.Canno}
     *
     * @param joinPoint aspect
     * @return the method result
     * @throws Throwable exception
     */
    @Around("@annotation(com.canno.spring.boot.integration.java18.animation.Canno)")
    public Object count(ProceedingJoinPoint joinPoint) throws Throwable {
        Object o = joinPoint.proceed();
        synchronized (this) {
            invokeCount++;
            System.out.println(invokeCount);
        }
        logger.info("@#!@#$%$%^&&&*^&*(^&()_*)(+__");
        return o;
    }

    /**
     * Invoke method named orderInit(), execute it.
     *
     * @param point ProceedingJoinPoint
     * @return -
     * @throws Throwable -
     */
    @Around("execution(public boolean orderInit(..))")
    public Object cc(ProceedingJoinPoint point) throws Throwable {
        return point.proceed();
    }

    public static int getInvokeCount() {
        return invokeCount;
    }

    @Around("@annotation(org.springframework.web.bind.annotation.RequestMapping))")
    public Object requestInfo(ProceedingJoinPoint joinPoint) {
        Object o = null;
        joinPoint.getArgs();
        try {
            o = joinPoint.proceed();
        } catch (Throwable throwable) {
            logger.error(throwable.getMessage(), throwable);
        }

        return o;
    }
}
