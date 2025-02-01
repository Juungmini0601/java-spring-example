package com.raon.di.core;

import static org.reflections.ReflectionUtils.*;

import java.lang.reflect.Constructor;
import java.util.Set;

import com.raon.di.annotation.Inject;

public class MyBeanFactoryUtil {

	// Inject가 붙은 생성자를 하나 찾아서 반환한다.
	@SuppressWarnings({"rawtypes", "unchecked"})
	public static Constructor<?> getInjectedConstructor(Class<?> clazz) {
		Set<Constructor> constructors = getAllConstructors(clazz, withAnnotation(Inject.class));

		if (constructors.isEmpty()) {
			return null;
		}

		return constructors.iterator().next();
	}
}
