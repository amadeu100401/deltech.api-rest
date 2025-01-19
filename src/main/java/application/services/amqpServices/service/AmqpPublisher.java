package application.services.amqpServices.service;

import application.common.DTOS.MessageWrapper;

public interface AmqpPublisher {
    <T> void sendMessage(String queueName, MessageWrapper<T> message);
}
