package com.raon.no.spring.training.repository;

import java.util.List;

import com.raon.no.spring.training.model.Training;

public interface TrainingRepository {
	List<Training> selectAll();
}
