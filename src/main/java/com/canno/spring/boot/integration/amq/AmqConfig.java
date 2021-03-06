package com.canno.spring.boot.integration.amq;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;

/**
 * bean of activeMQ
 *
 * @author Canno
 * @since 2018/7/6 15:03
 */
@Configuration
@EnableJms
public class AmqConfig {

    @Bean(name = DestinationName.PRODUCER_MODEL)
    public Destination producerDes() {
        return new ActiveMQQueue(DestinationName.PUBLISHER_MODEL);
    }

    @Bean(name = DestinationName.PUBLISHER_MODEL)
    public Destination publisherDes() {
        return new ActiveMQTopic(DestinationName.PUBLISHER_MODEL);
    }

    @Deprecated
    @Bean(name = "topicContainerFactory1")
    public DefaultJmsListenerContainerFactory topicClient1(ConnectionFactory connectionFactory, DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = defaultJmsListenerContainerFactoryTopic(connectionFactory, configurer);
        factory.setClientId("10003");
        return factory;
    }

//    @Bean(name = "jmsTemplate")
//    public JmsTemplate jmsTemplate(ConnectionFactory connectionFactory){
//        JmsTemplate jmsTemplate = new JmsTemplate();
//        jmsTemplate.setConnectionFactory(connectionFactory);
//        return new JmsTemplate();
//    }

    @Deprecated
    @Bean(name = "topicContainerFactory2")
    public DefaultJmsListenerContainerFactory topicClient2(ConnectionFactory connectionFactory, DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = defaultJmsListenerContainerFactoryTopic(connectionFactory, configurer);
        factory.setClientId("10004");
        return factory;
    }

    /**
     * @param connectionFactory
     * @param configurer
     * @return
     */

    @Deprecated
    public DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactoryTopic(ConnectionFactory connectionFactory, DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        factory.setPubSubDomain(true);
        factory.setSessionTransacted(true);
        factory.setAutoStartup(true);
        //开启持久化订阅
        factory.setSubscriptionDurable(true);
        return factory;
    }
}
