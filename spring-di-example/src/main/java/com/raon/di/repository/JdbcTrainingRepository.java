package com.raon.di.repository;

import java.util.List;

import com.raon.di.annotation.Repository;
import com.raon.di.model.Training;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class JdbcTrainingRepository {

	public List<Training> selectAll() {
		log.info("JdbcTrainingRepository.selectAll");
		return List.of();
	}
}
