package com.raon.di.core;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class MyBeanFactory {
	// 의존성을 주입하기 위한 타입들을 외부에서 넣어준다.
	private final Set<Class<?>> preInstantiatedBeans;
	// 초기화가 완료된 빈이 들어갈 저장소
	private final Map<Class<?>, Object> beans = new HashMap<>();

	public MyBeanFactory(Set<Class<?>> preInstantiatedBeans) {
		this.preInstantiatedBeans = preInstantiatedBeans;
		initialize();
	}

	// 초기화 메소드
	public void initialize() {
		preInstantiatedBeans.
			forEach(clazz -> beans.put(clazz, createInstance(clazz)));
	}

	// 타입을 받아서 빈을 생성한다.
	private Object createInstance(Class<?> concreteClass) {
		// 1. 생성자를 찾아온다.
		Constructor<?> constructor = findConstructor(concreteClass);
		List<Object> parameters = new ArrayList<>();
		// 2. 클래스의 파라미터타입의 빈을 모두 조회하여 리스트에 넣어준다.
		// 만일 파라미터의 빈이 초기화 되지 않았다면 생성해서 넣어준다.
		Arrays.stream(Objects.requireNonNull(constructor).getParameterTypes())
			.forEach(type -> parameters.add(getParameterByClass(type)));

		try {
			// 3. 인스턴스를 생성하여 반환한다.
			return constructor.newInstance(parameters.toArray());
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}

	// Inject가 붙어 있는 생성자를 찾고 없으면 첫번째 생성자를 반환한다.
	private Constructor<?> findConstructor(Class<?> concreteClass) {
		Constructor<?> constructor = MyBeanFactoryUtil.getInjectedConstructor(concreteClass);

		if (Objects.nonNull(constructor)) {
			return constructor;
		}

		return concreteClass.getConstructors()[0];
	}

	private Object getParameterByClass(Class<?> clazz) {
		Object bean = getBean(clazz);

		if (Objects.isNull(bean)) {
			return createInstance(clazz);
		}

		return bean;
	}

	public <T> T getBean(Class<T> requiredType) {
		return (T)beans.get(requiredType);
	}
}
