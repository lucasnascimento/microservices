package com.acme.ecommerce.configuration;

import com.acme.ecommerce.constants.RabbitConstants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author s2it_csilva
 * @version : $<br/>
 * : $
 * @since 11/13/19 9:29 AM
 */
@EnableRabbit
@Configuration
public class RabbitConfigure {

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    FanoutExchange exchangeSale() {
        return new FanoutExchange(RabbitConstants.SALE_EX);
    }

    @Bean
    Queue queueSale () {
        return new Queue(RabbitConstants.SALE_QUEUE);
    }

    @Bean
    Binding bindingQueueSale() {
        return BindingBuilder.bind(queueSale()).to(exchangeSale());
    }
}
