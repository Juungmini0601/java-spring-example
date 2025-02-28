package com.raon.example.spring.circular;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

/**
 * @author    : kimjungmin
 * Created on : 2025. 2. 28.
 *
 * 순환참조가 필드주입에만 있는게 아니라 생성자 주입을 사용해도 있을 수 있는거 아닌가?
 * 확인시 필드 주입 생성자 주입 모두 순환 참조 발생 가능함
 */
@Component
@RequiredArgsConstructor
public class CircularA {

	private final CircularB b;

}
