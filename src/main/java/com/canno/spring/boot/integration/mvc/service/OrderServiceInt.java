package com.canno.spring.boot.integration.mvc.service;

import com.canno.spring.boot.integration.java18.animation.Canno;

/**
 * @author Canno
 * @since 2018/7/10 16:11
 */
public interface OrderServiceInt {
    @Canno
    public boolean orderInit(long amount);
}
