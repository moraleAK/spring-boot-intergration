package com.canno.spring.boot.integration.amq;

import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Canno
 * @since 2018/7/5 16:03
 */
@Service
public class Producer {
    @Resource
    private JmsMessagingTemplate messagingTemplate;

    public void sendMessage(String destinationName, String message){
        messagingTemplate.convertAndSend(destinationName, message);
    }
}
