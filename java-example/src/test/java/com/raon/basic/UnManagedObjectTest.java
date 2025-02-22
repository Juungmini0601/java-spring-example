package com.raon.basic;

import java.util.Objects;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class UnManagedObjectTest {

	@Test
	@DisplayName("1.Unmanaged Object")
	void test1() {
		UnManagedObject unManagedObject = new UnManagedObject("test", 10);

		log.info("Object default toString: {}", unManagedObject); // 16진수 해시코드

		log.info("instance hashcode: {}", unManagedObject.hashCode()); // 동일
		log.info("Object hashCode: {}", System.identityHashCode(unManagedObject)); // 동일
		log.info("Objects hashCode: {}", Objects.hashCode(unManagedObject)); // 동일
	}
}