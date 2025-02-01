package com.raon.spring.redis.example.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class LeaderboardService {
	private final RedisTemplate<String, String> redisTemplate;
	private static final String LEADERBOARD_KEY = "game:leaderboad";

	public void addScore(String userId, double score) {
		redisTemplate.opsForZSet().incrementScore(LEADERBOARD_KEY, userId, score);
		log.info("Score added for user: {} with score: {}", userId, score);
	}

	public List<String> getTopPlayers(int count) {
		Set<String> topScores = redisTemplate.opsForZSet().reverseRange(LEADERBOARD_KEY, 0, count - 1);
		return new ArrayList<>(topScores != null ? topScores : Collections.emptySet());
	}

	public Long getUserRank(String userId) {
		return redisTemplate.opsForZSet().reverseRank(LEADERBOARD_KEY, userId);
	}

	public Double getUserScore(String userId) {
		return redisTemplate.opsForZSet().score(LEADERBOARD_KEY, userId);
	}
}
