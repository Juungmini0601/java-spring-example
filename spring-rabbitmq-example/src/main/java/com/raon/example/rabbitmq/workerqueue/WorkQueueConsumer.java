package com.raon.example.rabbitmq.workerqueue;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class WorkQueueConsumer {
	public void workQueueTask(String message) {
		log.info("[#] WorkQueueConsumer: {}", message);
	}
}
