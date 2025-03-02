package com.raon.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author    : kimjungmin
 * Created on : 2025. 3. 3.
 */
public class Invariance {
	public static void main(String[] args) {
		List<? super Integer> numbers = new ArrayList<>();

		// 정수
		numbers.add(10);
		// 반공변타입의 조회에서는 ?가 Integer의 상위타입 또는 Integer이다.
		Object object = numbers.get(0);
	}
}
