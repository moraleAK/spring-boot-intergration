package com.canno.blog.mq.active;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;

/**
 * @author Canno
 * @since 2018/7/5 16:21
 */
@Service
public class Publisher {
    @Resource
    private JmsMessagingTemplate messagingTemplate;

    public void publish(String destinationName, String message){
        System.out.println("send topic message :" + message);
        messagingTemplate.convertAndSend(destinationName, message);
    }
}
