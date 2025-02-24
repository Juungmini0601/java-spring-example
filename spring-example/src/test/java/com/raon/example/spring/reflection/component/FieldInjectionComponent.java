package com.raon.example.spring.reflection.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author    : kimjungmin
 * Created on : 2025. 2. 24.
 *
 * reflection 회수가 달라지는지 보기 위한 컴포넌트
 */
@Component
public class FieldInjectionComponent {

	@Autowired
	private Dependency dependency;
}
