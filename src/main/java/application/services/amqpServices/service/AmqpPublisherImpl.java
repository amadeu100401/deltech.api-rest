package application.services.amqpServices.service;

import application.common.DTOS.MessageWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class AmqpPublisherImpl implements AmqpPublisher {
    private RabbitTemplate rabbitTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    public <T> void sendMessage(String queueName, MessageWrapper<T> message) {

        String jsonMessage = objectMapper.writeValueAsString(message);

        rabbitTemplate.convertAndSend(queueName, jsonMessage);
    }
}
