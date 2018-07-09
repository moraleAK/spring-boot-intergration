package com.canno.spring.boot.integration.zee;

/**
 * @author Canno
 * @since 2018/7/9 9:39
 */
public class Cat implements AbstractZoo {
    @Override
    public void go() {
        System.out.println("悄然无息 听不到我");
    }

    @Override
    public void shout() {
        System.out.println("喵喵喵");
    }
}
