package com.raon.basic;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class SyncExampleTest {

	@Test
	@DisplayName("마크워드의 해시코드가 사라지면 어떻게 되는 걸까?")
	void test1() {
		Object obj = new Object();

		int initHashCode = obj.hashCode();
		log.info("initHashCode: {}", initHashCode);

		int hashCodeInSyncBlock;

		synchronized (obj) {
			hashCodeInSyncBlock = obj.hashCode();
			log.info("hashCodeInSyncBlock: {}", hashCodeInSyncBlock);
		}

		int afterHashCode = obj.hashCode();
		log.info("afterHashCode: {}", afterHashCode);

		// 충격적인 발견 왜 모두 동일하지?
		assertThat(hashCodeInSyncBlock)
			.isEqualTo(initHashCode)
			.isEqualTo(afterHashCode);
	}
}