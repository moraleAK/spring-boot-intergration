package com.canno.spring.boot.integration.mq.active;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;
import org.springframework.stereotype.Service;

import javax.jms.ConnectionFactory;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * @author Canno
 * @since 2018/7/5 16:24
 */
@Service
@Configuration
public class Subscriber implements MessageListener {
    private final ConnectionFactory connectionFactory;

    @Override
    public void onMessage(Message message) {
        System.out.println(message);
    }

    @Autowired
    public Subscriber(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    /**
     * config #containerFactory unknown cause cannot receive message
     *
     * @param message
     */
    @JmsListener(destination = DestinationName.PUBLISHER_MODEL, containerFactory = "topicContainerFactory1")
    public void subscribe(Message message){
        System.out.println("receive topic message :" + message);
    }

    @JmsListener(destination = DestinationName.PUBLISHER_MODEL, containerFactory = "topicContainerFactory2")
    public void subscribe2(String message){
        System.out.println("The enemy also has " + message + "seconds to reach the battlefield. :" );
    }

    @Bean(name = "myJmsContainerFactory")
    JmsListenerContainerFactory<?> myJmsContainerFactory(){
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setPubSubDomain(true);
        factory.setAutoStartup(true);
        return factory;
    }
}
