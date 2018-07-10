package com.canno.spring.boot.integration.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author Canno
 * @since 2018/7/10 15:08
 */
@Aspect
@Configuration
public class Count {
    private static int count = 0;

    @Around("@annotation(com.canno.spring.boot.integration.java18.animation.Canno)")
    public Object count(ProceedingJoinPoint joinPoint) throws Throwable {
        Object o = joinPoint.proceed();
        synchronized (this){
            count++;
            System.out.println(count);
        }
        System.out.println("@#!@#$%$%^&&&*^&*(^&()_*)(+__");
        return o;
    }

    @Around("execution(public boolean orderInit(..))")
    public Object cc(ProceedingJoinPoint point) throws Throwable {
        count ++ ;
        System.out.println(count);
        return point.proceed();
    }
}
