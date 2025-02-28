package com.raon.example.spring.lookup;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ObjectFactoryCreatingFactoryBean;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author    : kimjungmin
 * Created on : 2025. 2. 28.
 *
 * https://mangkyu.tistory.com/168
 */
@SpringBootTest
class MyComponentTest {

	@TestConfiguration
	static class DLConfiguration {

		@Bean
		ObjectFactoryCreatingFactoryBean factoryBean() {
			ObjectFactoryCreatingFactoryBean factoryBean = new ObjectFactoryCreatingFactoryBean();
			factoryBean.setTargetBeanName("myComponent");
			return factoryBean;
		}
	}

	@Autowired
	ApplicationContext ac;

	@Test
	@DisplayName("1. Application Context DependcnyLookup test")
	void test1() {
		// Application Context를 이용하면 DL 방식으로 찾을 수 있음
		// 이외에도 ObejectFactoryBean, ServiceLocatorFactoryBean을 이용하면 가져 올 수 있네
		Object bean = ac.getBean("myComponent");

		assertThat(bean).isNotNull();
	}

}
