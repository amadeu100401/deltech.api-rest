package infra.config;

import application.common.constants.QueueConstants;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {
    public static final String EXCHANGE_NAME = "delbankExchange";
    public static final String ROUTING_KEY = "delbankRoutingKey";

    @Bean
    public RabbitListenerContainerFactory<?> rabbitListenerContainerFactory(ConnectionFactory connectionFactory,
                                                                            Jackson2JsonMessageConverter converter) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(converter);
        return factory;
    }

    @Bean
    public Queue waitQueue() {
        return QueueBuilder.durable(QueueConstants.SAVE_BANK_ACCOUNT_WAIT)
                .deadLetterExchange(EXCHANGE_NAME)
                .deadLetterRoutingKey(QueueConstants.SAVE_BANK_ACCOUNT_IN_ROUTING_KEY)
                .ttl(5000) //5s
                .build();
    }

    @Bean
    public Queue inEntity() {
        return QueueBuilder.durable(QueueConstants.SAVE_BANK_ACCOUNT_IN).build();
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(EXCHANGE_NAME); // Exchange principal
    }

    @Bean
    public Binding bindingWaitQueue() {
        return BindingBuilder.bind(waitQueue()).to(exchange()).with(QueueConstants.SAVE_BANK_ACCOUNT_WAIT_ROUTING_KEY);
    }

    @Bean
    public Binding bindingInQueue() {
        return BindingBuilder.bind(inEntity()).to(exchange()).with(QueueConstants.SAVE_BANK_ACCOUNT_IN_ROUTING_KEY);
    }
}
