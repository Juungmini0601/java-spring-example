package com.raon.example.spring.circular;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

/**
 * @author    : kimjungmin
 * Created on : 2025. 2. 28.
 */
@Component
@RequiredArgsConstructor
public class CircularB {

	private CircularA a;

}
