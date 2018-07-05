package com.canno.blog.mq.active;

import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;
import org.springframework.stereotype.Service;

import javax.jms.ConnectionFactory;

/**
 * @author Canno
 * @since 2018/7/5 16:24
 */
@Service
public class Subscriber {

    @JmsListener(destination = "canno.topic"/*, containerFactory = "myJmsContainerFactory"*/)
    public void subscribe(String message){
        System.out.println("receive topic message :" + message);
    }

    @Bean
    JmsListenerContainerFactory<?> myJmsContainerFactory(ConnectionFactory connectionFactory){
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setPubSubDomain(true);
        return factory;
    }
}
