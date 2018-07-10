package com.canno.spring.boot.integration.java18.proxy;

/**
 * @author Canno
 * @since 2018/7/10 14:57
 */
public class JdkProxyTest {
    public static void main(String[] args) {
        Cat cat = new CatImpl();
        CatInvocationHandler invocationHandler = new CatInvocationHandler(cat);
        Cat catProxy = invocationHandler.getProxy(Cat.class);
        catProxy.go();
        catProxy.run();
    }
}
