package com.raon.spring.data.example.jdbc.connection;

import static com.raon.spring.data.example.jdbc.connection.ConnectionConstant.*;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConnectionTest {

	@Test
	void driverManager() throws Exception {
		Connection con1 = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		Connection con2 = DriverManager.getConnection(URL, USERNAME, PASSWORD);

		log.info("con1={}, class={}", con1, con1.getClass());
		log.info("con2={}, class={}", con2, con2.getClass());
	}

	@Test
	void dataSourceDriverManager() throws Exception {
		DriverManagerDataSource dataSource = new DriverManagerDataSource(URL, USERNAME, PASSWORD);
		useDataSource(dataSource);
	}

	@Test
	void dataSourceConnectionPool() throws Exception {
		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setJdbcUrl(URL);
		dataSource.setUsername(USERNAME);
		dataSource.setPassword(PASSWORD);
		dataSource.setMaximumPoolSize(10);
		dataSource.setPoolName("MyPool");
		
		useDataSource(dataSource);
		Thread.sleep(1000); // 커넥션 풀에서 커넥션 생성 시간 대기
	}

	private void useDataSource(DataSource dataSource) throws Exception {
		Connection con1 = dataSource.getConnection();
		Connection con2 = dataSource.getConnection();

		log.info("con1={}, class={}", con1, con1.getClass());
		log.info("con2={}, class={}", con2, con2.getClass());
	}
}
