package com.canno.spring.boot.integration.java18.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * User Canno
 * Date 2017/11/30
 * Time 9:48
 */
public class CatInvocationHandler implements InvocationHandler {
    private Object target;

    public CatInvocationHandler(Object target) {
        super();
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // to do before invoke target method
        System.out.println("------------------before------------------");

        // 执行目标对象的方法
        Object result = method.invoke(target, args);

        // to do after invoke target method
        System.out.println("-------------------after------------------");

        return result;
    }

    public <T> T getProxy(Class<T> clazz) {
        return (T) (Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                target.getClass().getInterfaces(), this));
    }
}
