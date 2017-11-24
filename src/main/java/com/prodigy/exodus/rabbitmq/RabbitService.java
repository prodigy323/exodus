package com.prodigy.exodus.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.prodigy.exodus.models.Teams;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RabbitService {

	@Value("${app.exodus.rabbit.queue}")
    private String queueName;
	
	@Value("${app.exodus.rabbit.exchange}")
    private String exchange;
    
    @Value("${app.exodus.rabbit.responseMessage}")
    private String sendToRabbitMessage;

    @Autowired
    private RabbitTemplate rabbitTemplate;
    
	// Create the queue named spring-boot
	@Bean
	Queue queue() {
		return new Queue(queueName, false);
	}

	// Create the topic exchange to distribute to the queues
	@Bean
	TopicExchange exchange() {
		return new TopicExchange(exchange);
	}

	// Binds the queue to the exchange
	@Bean
	Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(queueName);
	}
	
	// Message converter for java object
	@Bean
	public MessageConverter jsonMessageConverter(){
	    return new Jackson2JsonMessageConverter();
	}
	
	public String sendToQueue(String request) {
		log.info("Sending message...");
		rabbitTemplate.setMessageConverter(jsonMessageConverter());
        rabbitTemplate.convertAndSend(queueName, request);
        return sendToRabbitMessage;
	}

}
