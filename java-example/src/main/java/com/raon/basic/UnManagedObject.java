package com.raon.basic;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * UnManaged언어인 Java는 어떻게 객체의 메모리 주소를 이용해 Hash Code를 생성할까?
 *
 * -> 충격적 발견 객체의 메모리 주소를 사용한다는 내용이 JDK21에서는 없음
 * -> 내부 구현 코드를 살펴본 결과 HashCode는 6가지 방법으로 생성 될 수 있음
 * -> 하긴 메모리 주소를 이용해서 생성되면 GC 이후 세대간 이동이 생길 경우 HashCode가 달라진다는 소리?
 */
@Getter
@AllArgsConstructor
public class UnManagedObject {
	private String name;
	private int age;
}
