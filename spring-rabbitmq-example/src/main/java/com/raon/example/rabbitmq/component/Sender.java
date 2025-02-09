package com.raon.example.rabbitmq.component;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class Sender {

	private final RabbitTemplate rabbitTemplate;

	public void send(String message) {
		rabbitTemplate.convertAndSend("helloqueue", message);
		log.info("[#] Sending: {}", message);
	}
}
