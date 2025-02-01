package com.raon.di;

import com.raon.di.annotation.Inject;
import com.raon.di.annotation.Service;
import com.raon.di.repository.JdbcTrainingRepository;

@Service
public class TrainingService {

	private final JdbcTrainingRepository trainingRepository;

	@Inject
	public TrainingService(JdbcTrainingRepository trainingRepository) {
		this.trainingRepository = trainingRepository;
	}

	public void selectAll() {
		trainingRepository.selectAll();
	}
}
