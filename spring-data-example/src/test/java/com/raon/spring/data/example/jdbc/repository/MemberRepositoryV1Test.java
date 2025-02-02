package com.raon.spring.data.example.jdbc.repository;

import static com.raon.spring.data.example.jdbc.connection.ConnectionConstant.*;
import static org.assertj.core.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.raon.spring.data.example.jdbc.domain.Member;
import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class MemberRepositoryV1Test {

	MemberRepositoryV1 memberRepositoryV1;

	@BeforeEach
	void beforeEach() throws Exception {
		HikariDataSource hikariDataSource = new HikariDataSource();
		hikariDataSource.setJdbcUrl(URL);
		hikariDataSource.setUsername(USERNAME);
		hikariDataSource.setPassword(PASSWORD);

		memberRepositoryV1 = new MemberRepositoryV1(hikariDataSource);
	}

	@Test
	void crud() throws Exception {
		log.info("start");
		// insert
		Member member = new Member("memberV0", 10000);
		memberRepositoryV1.save(member);
		// select
		Member memberById = memberRepositoryV1.findById(member.getMemberId());
		assertThat(memberById).isNotNull();
		// update
		memberRepositoryV1.update(member.getMemberId(), 20000);
		Member updatedMember = memberRepositoryV1.findById(member.getMemberId());
		assertThat(updatedMember.getMoney()).isEqualTo(20000);
		// delete
		memberRepositoryV1.delete(member.getMemberId());
		assertThatThrownBy(() -> memberRepositoryV1.findById(member.getMemberId()))
			.isInstanceOf(NoSuchElementException.class);
	}
}