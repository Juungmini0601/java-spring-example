package com.raon.example.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.raon.example.kafka.domain.OrderEvent;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DeadLetterConsumer {

	@KafkaListener(topics = "orders.DLT", groupId = "dlt-group")
	public void listenDLT(@Payload OrderEvent order, Exception exception) {
		log.error("Received failed order in DLT: {}, Error: {}",
			order.getOrderId(), exception.getMessage());
	}
}