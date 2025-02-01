package com.raon.no.spring.training.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.raon.no.spring.training.model.Training;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
@Qualifier("JdbcTrainingRepository")
public class JdbcTrainingRepository implements TrainingRepository {

	@Override
	public List<Training> selectAll() {
		log.info("JdbcTrainingRepository.selectAll");

		return List.of();
	}
}
