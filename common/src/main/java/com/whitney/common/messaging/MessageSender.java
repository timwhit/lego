package com.whitney.common.messaging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class MessageSender {
    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private ObjectMapper mapper;

    public void sendMessage(Object message, String destination) {
        try {
            String s = mapper.writeValueAsString(message);

            MessageCreator messageCreator = session -> session.createTextMessage(s);

            this.jmsTemplate.send(destination, messageCreator);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}