package com.raon.spring.di;

import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.raon.no.spring.training.service.TrainingServiceV1;

import lombok.AllArgsConstructor;

public class ApplicationContextTest {

	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();

	@Test
	@DisplayName("모든 빈 출력")
	void findAllBean() {
		String[] beanDefinitionNames = ac.getBeanDefinitionNames();

		Arrays.stream(beanDefinitionNames).forEach(name -> {
			Object bean = ac.getBean(name);
			System.out.println("name: " + name + ", bean: " + bean);
		});
	}

	@Test
	@DisplayName("내 빈은 싱글톤인가?")
	void isSingleton() {
		ac = new AnnotationConfigApplicationContext(TestConfig.class);
		Object bean1 = ac.getBean("trainingServiceV1");
		Object bean2 = ac.getBean("trainingServiceV1");

		System.out.println("bean1: " + bean1);
		System.out.println("bean2: " + bean2);

		Assertions.assertThat(bean1).isSameAs(bean2);
	}

	@Test
	@DisplayName("Config 클래스 살펴보기")
	void configClass() {
		ac = new AnnotationConfigApplicationContext(TestConfig.class);

		System.out.println(ac.getBean(TestConfig.class));
	}

	@Configuration
	@AllArgsConstructor
	private static class TestConfig {

		@Bean
		public TrainingServiceV1 trainingServiceV1() {
			return new TrainingServiceV1();
		}
	}
}
