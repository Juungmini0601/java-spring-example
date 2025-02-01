package com.raon.spring.di;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.raon.no.spring.training.service.TrainingServiceV2;
import com.raon.no.spring.training.service.TrainingServiceV3;

@SpringBootTest
public class GetBean {

	@Autowired
	AnnotationConfigApplicationContext ac;

	@Test
	void test() {
		TrainingServiceV2 service = ac.getBean(TrainingServiceV2.class);

		service.selectAll();
	}

	@Test
	void getBeanAll() {
		TrainingServiceV3 service = ac.getBean(TrainingServiceV3.class);

		service.printBean();
	}
}
