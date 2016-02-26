package com.whitney.queue.config;

import org.apache.activemq.broker.BrokerService;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class MessageQueueConfig {
    @PostConstruct
    void init() throws Exception {
        BrokerService broker = new BrokerService();
        broker.setPersistent(false);
        broker.addConnector("tcp://localhost:6161");
        broker.start();
    }
}