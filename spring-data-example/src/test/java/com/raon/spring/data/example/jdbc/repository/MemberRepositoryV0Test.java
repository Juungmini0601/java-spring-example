package com.raon.spring.data.example.jdbc.repository;

import static org.assertj.core.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import com.raon.spring.data.example.jdbc.domain.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class MemberRepositoryV0Test {

	MemberRepositoryV0 memberRepositoryV0 = new MemberRepositoryV0();

	@Test
	void crud() throws Exception {
		// save
		Member member = new Member("memberV0", 10000);
		memberRepositoryV0.save(member);
		// select
		Member findMember = memberRepositoryV0.findById(member.getMemberId());
		log.info("findMember={}", findMember);
		assertThat(findMember).isEqualTo(member);
		// update
		memberRepositoryV0.update(member.getMemberId(), 20000);
		Member updatedMember = memberRepositoryV0.findById(member.getMemberId());
		assertThat(updatedMember.getMoney()).isEqualTo(20000);
		// delete
		memberRepositoryV0.delete(member.getMemberId());
		assertThatThrownBy(() -> memberRepositoryV0.findById(member.getMemberId()))
			.isInstanceOf(NoSuchElementException.class);
	}
}