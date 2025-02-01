package com.raon.di.core;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;

import com.raon.di.TrainingService;
import com.raon.di.annotation.Repository;
import com.raon.di.annotation.Service;
import com.raon.di.repository.JdbcTrainingRepository;

class MyBeanFactoryTest {
	private Reflections reflections;
	private MyBeanFactory myBeanFactory;

	@BeforeEach
	public void beforeEach() {
		reflections = new Reflections("com.raon.di");
		Set<Class<?>> preInstantiatedClass = getTypesAnnotatedWith(Service.class, Repository.class);
		myBeanFactory = new MyBeanFactory(preInstantiatedClass);
	}

	private Set<Class<?>> getTypesAnnotatedWith(Class<? extends Annotation>... annotations) {
		return Arrays.stream(annotations)
			.flatMap(annotation -> reflections.getTypesAnnotatedWith(annotation).stream())
			.collect(Collectors.toSet());
	}

	@Test
	public void diTest() {
		TrainingService trainingService = myBeanFactory.getBean(TrainingService.class);
		JdbcTrainingRepository repository = myBeanFactory.getBean(JdbcTrainingRepository.class);

		trainingService.selectAll();
		Assertions.assertThat(trainingService).isNotNull();
		Assertions.assertThat(repository).isNotNull();
	}
}