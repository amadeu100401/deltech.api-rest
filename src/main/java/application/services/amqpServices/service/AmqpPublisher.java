package application.services.amqpServices.service;

import application.common.DTOs.MessageWrapper;

public interface AmqpPublisher {
    <T> void sendMessage(String queueName, MessageWrapper<T> message);
}
