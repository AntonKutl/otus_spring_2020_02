package ru.otus.service;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandlingException;
import org.springframework.stereotype.Service;

@Service
public class OrderErrorHandler  {

    public void handleFailedOrder(Message<MessageHandlingException> message) {
        System.out.println(message.getPayload());
    }
}
