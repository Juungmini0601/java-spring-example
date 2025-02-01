package com.raon.spring.redis.example.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raon.spring.redis.example.model.User;
import com.raon.spring.redis.example.service.RedisCacheService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/users")
@Slf4j
public class UserController {
	private final RedisCacheService redisCacheService;

	@Autowired
	public UserController(RedisCacheService redisCacheService) {
		this.redisCacheService = redisCacheService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable Long id) {
		return redisCacheService.getCachedData("user:" + id, User.class)
			.map(ResponseEntity::ok)
			.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		user.setCreatedAt(LocalDateTime.now());
		redisCacheService.cacheData("user:" + user.getId(), user, 3600);
		return ResponseEntity.ok(user);
	}
}
