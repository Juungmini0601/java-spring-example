package com.raon.example.spring.reflection.component;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

/**
 * @author    : kimjungmin
 * Created on : 2025. 2. 24.
 *
 * 생성자 주입용
 */
@Component
@RequiredArgsConstructor
public class ConstructorInjectionComponent {
	private final Dependency dependency;
}
