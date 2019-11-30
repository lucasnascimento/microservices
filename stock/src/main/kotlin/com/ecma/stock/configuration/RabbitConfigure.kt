package com.ecma.stock.configuration

import com.ecma.stock.constants.RabbitConstants
import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.FanoutExchange
import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.annotation.EnableRabbit
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.amqp.support.converter.MessageConverter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * @author s2it_csilva
 * @since 11/13/19 2:02 PM
 * @version : $<br/>
 *          : $
 *
 */
@EnableRabbit
@Configuration
class RabbitConfigure {

    @Bean
    fun rabbitTemplate(connectionFactory: ConnectionFactory): RabbitTemplate {
        val rabbitTemplate = RabbitTemplate(connectionFactory)
        rabbitTemplate.messageConverter = messageConverter()
        return rabbitTemplate
    }

    @Bean
    fun messageConverter(): MessageConverter {
        return Jackson2JsonMessageConverter()
    }


    @Bean
    internal fun exchangeProduct(): FanoutExchange {
        return FanoutExchange(RabbitConstants.PRODUCT_EX)
    }

    @Bean
    internal fun queueProduct(): Queue {
        return Queue(RabbitConstants.PRODUCT_QUEUE)
    }

    @Bean
    internal fun bindingQueueProduct(): Binding {
        return BindingBuilder.bind(queueProduct()).to(exchangeProduct())
    }


}