package com.raon.spring.data.example.jdbc.domain;

import lombok.Data;

@Data
public class Member {

	private String memberId;
	private Integer money;

	public Member() {
	}

	public Member(String memberId, Integer money) {
		this.memberId = memberId;
		this.money = money;
	}
}
