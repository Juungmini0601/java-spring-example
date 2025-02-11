package com.raon.example.rabbitmq.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raon.example.rabbitmq.component.Sender;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/messages")
@RequiredArgsConstructor
public class MessageQueueController {
	private final Sender sender;

	@RequestMapping("/send")
	public String send(@RequestBody String message) {
		for (int i = 0; i < 100; i++) {
			sender.send(message + i);
		}

		return "[#] Message sent! : " + message;
	}
}
