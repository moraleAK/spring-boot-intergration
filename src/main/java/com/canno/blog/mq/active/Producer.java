package com.canno.blog.mq.active;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;

/**
 * @author Canno
 * @since 2018/7/5 16:03
 */
@Service
public class Producer {
    @Resource
    private JmsMessagingTemplate messagingTemplate;

    public void sendMessage(String destinationName, String message){
        System.out.println("send :" + message);
        Destination destination = new ActiveMQQueue(destinationName);
        messagingTemplate.convertAndSend(destinationName, message);
    }
}
