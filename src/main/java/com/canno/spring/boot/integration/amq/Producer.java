package com.canno.spring.boot.integration.amq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
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
    @Autowired
    @Qualifier("jmsTemplate")
    JmsTemplate jmsTemplate;

    private final Destination destination;

    @Autowired
    public Producer(@Qualifier(DestinationName.PRODUCER_MODEL) Destination destination) {
        this.destination = destination;
    }

    public void sendMessage(String destinationName, String message) {
        messagingTemplate.convertAndSend(destinationName, message);
    }

    @Deprecated
    public void sendMessage(String message) {
        jmsTemplate.send(destination, session -> session.createObjectMessage(message));
    }
}
