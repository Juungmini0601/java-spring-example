package com.raon.spring.example.jooq;

import org.jooq.DSLContext;
import org.jooq.generated.tables.JActor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FirstLookJooqTest {

	@Autowired
	DSLContext dslContext;

	@Test
	void test() {
		dslContext.selectFrom(JActor.ACTOR)
			.limit(10)
			.fetch();
	}
}
