package com.raon.spring.redis.example.service;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class RedisCacheService {
	private final RedisTemplate<String, Object> redisTemplate;

	public void cacheData(String key, Object data, long timeoutSeconds) {
		try {
			redisTemplate.opsForValue().set(key, data, timeoutSeconds, TimeUnit.SECONDS);
		} catch (Exception e) {
			log.error("Error caching data: {}", e.getMessage());
			throw new RuntimeException("Cache operation failed", e);
		}
	}

	public <T> Optional<T> getCachedData(String key, Class<T> type) {
		try {
			Object data = redisTemplate.opsForValue().get(key);

			if (data == null) {
				return Optional.empty();
			}

			return Optional.empty();
		} catch (Exception e) {
			log.error("Error getting cached data: {}", e.getMessage());
			return Optional.empty();
		}
	}

	public void deleteCachedData(String key) {
		try {
			redisTemplate.delete(key);
			log.info("Cache deleted successfully for key: {}", key);
		} catch (Exception e) {
			log.error("Error deleting cached data: {}", e.getMessage());
			throw new RuntimeException("Cache operation failed", e);
		}
	}
}
