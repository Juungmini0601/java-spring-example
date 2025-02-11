package com.raon.example.rabbitmq.workerqueue;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class WorkQueueProducer {
	private final RabbitTemplate rabbitTemplate;

	public void sendWorkQueue(String message, int duration) {
		rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME, message);
		log.info("[#] WorkQueueProducer: {} ({}ms)", message, duration);
	}
}
