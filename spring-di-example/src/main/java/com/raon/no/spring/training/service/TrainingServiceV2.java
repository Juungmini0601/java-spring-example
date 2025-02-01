package com.raon.no.spring.training.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.raon.no.spring.training.repository.TrainingRepository;

@Service
public class TrainingServiceV2 {

	private final TrainingRepository trainingRepository;

	public TrainingServiceV2(@Qualifier("JdbcTrainingRepository") TrainingRepository trainingRepository) {
		this.trainingRepository = trainingRepository;
	}

	public void selectAll() {
		trainingRepository.selectAll();
	}
}
