package com.canno.spring.boot.integration.java18.proxy;

/**
 * User Canno
 * Date 2017/11/30
 * Time 9:57
 */
public class CgLibProxyTest {

    public static void main(String str[]){
        CgLibProxy proxy = new CgLibProxy();
        Dog dog = proxy.getProxy(new Dog());
        dog.go();
    }

}
