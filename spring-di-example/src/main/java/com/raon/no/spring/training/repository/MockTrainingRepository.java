package com.raon.no.spring.training.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.raon.no.spring.training.model.Training;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
@Primary
@Qualifier("mockTrainingRepository")
public class MockTrainingRepository implements TrainingRepository {

	@Override
	public List<Training> selectAll() {
		log.info("MockTrainingRepository.selectAll");
		return List.of();
	}
}
