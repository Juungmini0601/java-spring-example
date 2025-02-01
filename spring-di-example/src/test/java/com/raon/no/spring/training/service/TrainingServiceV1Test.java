package com.raon.no.spring.training.service;

import org.junit.jupiter.api.Test;

class TrainingServiceV1Test {

	private final TrainingServiceV1 trainingServiceV1 = new TrainingServiceV1();

	@Test
	void test() {
		// trainingRepository를 변경 시킬 방법이 없음
		trainingServiceV1.selectAll();
	}
}