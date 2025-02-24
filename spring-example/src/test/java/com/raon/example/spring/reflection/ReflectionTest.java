package com.raon.example.spring.reflection;

import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.Field;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.raon.example.spring.reflection.component.ConstructorInjectionComponent;
import com.raon.example.spring.reflection.component.FieldInjectionComponent;
import com.raon.example.spring.reflection.component.SetterInjection;

import lombok.extern.slf4j.Slf4j;

/**
 * @author    : kimjungmin
 * Created on : 2025. 2. 24.
 *
 * 필드 Injection, 생성자 Injection에서 추가적인 Reflection이 존재 하는지?
 */
@Slf4j
@SpringBootTest
public class ReflectionTest {

	@Autowired
	private ConstructorInjectionComponent constructorComponent;

	@Autowired
	private FieldInjectionComponent fieldComponent;

	@Autowired
	private SetterInjection setterComponent;

	@Test
	@DisplayName("스프링 의존성 주입 과정 추적")
	void traceDependencyInjection() {
		log.info("ConstructorInjectionComponent -> {}", constructorComponent);
		log.info("FieldInjectionComponent -> {}", fieldComponent);
		log.info("SetterInjection -> {}", setterComponent);
	}

	@Test
	@DisplayName("스프링에서 생성자 주입이 잘 동작한다.")
	void constructionInjectionTest1() throws Exception {
		Field dependencyField = ConstructorInjectionComponent.class.getDeclaredField("dependency");
		dependencyField.setAccessible(true);
		Object dependencyObject = dependencyField.get(constructorComponent);

		log.info("constructorComponent: {}", constructorComponent);
		log.info("dependencyObject: {}", dependencyObject);

		assertThat(constructorComponent).isNotNull();
		assertThat(dependencyObject).isNotNull();
	}

	@Test
	@DisplayName("스프링에서 필드 주입이 잘 동작한다.")
	void fieldInjectionTest1() throws Exception {
		Field dependencyField = FieldInjectionComponent.class.getDeclaredField("dependency");
		dependencyField.setAccessible(true);
		Object dependencyObject = dependencyField.get(fieldComponent);

		log.info("fieldComponent: {}", fieldComponent);
		log.info("dependencyObject: {}", dependencyObject);

		assertThat(fieldComponent).isNotNull();
		assertThat(dependencyObject).isNotNull();
	}
}

