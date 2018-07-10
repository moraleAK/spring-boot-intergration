package com.canno.spring.boot.integration.zee;

/**
 * @author CannoGcc
 * @since 2018/7/9 9:38
 */
public class Dog implements AbstractZoo {
    @Override
    public void go() {
        System.out.println("撒开大脚丫子 狂奔  " );
    }

    @Override
    public void shout() {
        System.out.println("汪汪汪");
    }
}
