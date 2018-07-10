package com.canno.spring.boot.integration.amq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * @author CannoGcc
 * @since 2018/7/5 16:03
 */
@Service
public class Consumer {
    /**
     * producer/consumer model
     *
     * @param text the message from listener
     */
    @JmsListener(destination = DestinationName.PRODUCER_MODEL)
    public void receiveMessage(String text){
        System.out.println("receive message : " + text);
    }

}
