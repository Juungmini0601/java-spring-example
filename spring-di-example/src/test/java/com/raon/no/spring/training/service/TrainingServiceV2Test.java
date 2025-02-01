package com.raon.no.spring.training.service;

import org.junit.jupiter.api.Test;

import com.raon.no.spring.training.repository.JdbcTrainingRepository;
import com.raon.no.spring.training.repository.MockTrainingRepository;
import com.raon.no.spring.training.repository.TrainingRepository;

class TrainingServiceV2Test {

	private final TrainingRepository jdbcTrainingRepository = new JdbcTrainingRepository();
	private final TrainingRepository mockTrainingRepository = new MockTrainingRepository();

	@Test
	void jdbcTrainingRepositoryTest() {
		TrainingServiceV2 trainingService = new TrainingServiceV2(jdbcTrainingRepository);
		trainingService.selectAll();
	}

	@Test
	void mockTrainingRepositoryTest() {
		TrainingServiceV2 trainingService = new TrainingServiceV2(mockTrainingRepository);
		trainingService.selectAll();
	}
}