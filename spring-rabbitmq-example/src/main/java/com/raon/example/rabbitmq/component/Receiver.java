package com.raon.example.rabbitmq.component;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Receiver {
	public void receiveMessage(String message) {
		System.out.println("[#] Received: " + message);
	}
}
