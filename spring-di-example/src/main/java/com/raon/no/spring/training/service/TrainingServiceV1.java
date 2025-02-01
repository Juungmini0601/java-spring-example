package com.raon.no.spring.training.service;

import com.raon.no.spring.training.repository.JdbcTrainingRepository;
import com.raon.no.spring.training.repository.TrainingRepository;

public class TrainingServiceV1 {

	private final TrainingRepository trainingRepository = new JdbcTrainingRepository();

	public void selectAll() {
		trainingRepository.selectAll();
	}
}
