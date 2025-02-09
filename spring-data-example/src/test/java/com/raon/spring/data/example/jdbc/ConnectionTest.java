package com.raon.spring.data.example.jdbc;

import static org.assertj.core.api.Assertions.*;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@JdbcTest
// 테스트 환경에서 임베디들 꼽으려고하는데 비활성화
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ConnectionTest {

	@Autowired
	private DataSource dataSource;

	@Test
	@DisplayName("1) Connection 조회")
	void testConnection() throws Exception {
		try (Connection connection = dataSource.getConnection()) {

			assertThat(connection).isNotNull();
			assertThat(connection.getMetaData().getDatabaseProductName()).isNotBlank();

			log.info("Database name: {}", connection.getMetaData().getDatabaseProductName());
		}
	}
}
