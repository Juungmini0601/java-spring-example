package com.raon.spring.redis.example.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
	private Long id;
	private String username;
	private String email;
	private LocalDateTime createdAt;
}
