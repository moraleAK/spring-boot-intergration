package com.canno.spring.boot.integration.java18.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * User Canno
 * Date 2017/11/30
 * Time 10:04
 */
public class CgLibProxy implements MethodInterceptor {
    private Object target;

    public <T> T getProxy(T target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        // set callback method
        enhancer.setCallback(this);
        // create proxy object
        return (T) enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("----------------------before---------------");
        methodProxy.invokeSuper(o, objects);
        System.out.println("----------------------after-----------------");
        return null;
    }

}
