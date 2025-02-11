package com.raon.example.rabbitmq.workerqueue;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
	public static final String QUEUE_NAME = "WorkQueue";

	@Bean
	public Queue queue() {
		// duralbe param을 true로 줘서 재처리 가능하도록
		return new Queue(QUEUE_NAME, true);
	}

	@Bean
	public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
		return new RabbitTemplate(connectionFactory);
	}

	@Bean
	public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
		MessageListenerAdapter messageListenerAdapter) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(QUEUE_NAME);
		container.setMessageListener(messageListenerAdapter);
		return container;
	}

	@Bean
	public MessageListenerAdapter listenerAdapter(WorkQueueConsumer consumer) {
		return new MessageListenerAdapter(consumer, "workQueueTask");
	}
}
