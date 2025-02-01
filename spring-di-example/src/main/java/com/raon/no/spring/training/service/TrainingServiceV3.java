package com.raon.no.spring.training.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.raon.no.spring.training.repository.TrainingRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TrainingServiceV3 {

	private final Map<String, TrainingRepository> trainingRepositoryMap;
	private final List<TrainingRepository> trainingRepositoryList;

	public void printBean() {
		System.out.println("trainingRepositoryMap = " + trainingRepositoryMap);
		System.out.println("trainingRepositoryList = " + trainingRepositoryList);
	}
}
