package com.canno.blog.mq.active;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * @author Canno
 * @since 2018/7/5 16:03
 */
@Service
public class Consumer {
    /**
     * producer/consumer schame
     *
     * @param text
     */
    @JmsListener(destination = "canno.test")
    public void receiveMessage(String text){
        System.out.println("receive message : " + text);
    }

}
