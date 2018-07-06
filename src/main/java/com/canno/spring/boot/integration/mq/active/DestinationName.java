package com.canno.spring.boot.integration.mq.active;

/**
 * @author Canno
 * @since 2018/7/6 14:48
 */
public interface DestinationName {
    /**
     * the destination of producer/customer model
     */
    String PRODUCER_MODEL = "model.producer";

    /**
     *  the destination of publisher/subscriber model
     */
    String PUBLISHER_MODEL = "model.publisher";

}
