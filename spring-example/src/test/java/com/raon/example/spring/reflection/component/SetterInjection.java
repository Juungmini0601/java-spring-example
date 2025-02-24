package com.raon.example.spring.reflection.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author    : kimjungmin
 * Created on : 2025. 2. 24.
 */
@Component
public class SetterInjection {
	private Dependency dependency;

	@Autowired
	public void setDependency(Dependency dependency) {
		this.dependency = dependency;
	}
}
