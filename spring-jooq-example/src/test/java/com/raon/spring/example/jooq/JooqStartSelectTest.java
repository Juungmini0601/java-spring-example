package com.raon.spring.example.jooq;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.jooq.generated.tables.pojos.Film;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.raon.spring.example.jooq.film.FilmRepository;
import com.raon.spring.example.jooq.film.FilmWithActor;
import com.raon.spring.example.jooq.film.SimpleFilmInfo;

@SpringBootTest
public class JooqStartSelectTest {

	@Autowired
	FilmRepository filmRepository;

	@Test
	@DisplayName("1) 영화 정보 조회")
	void test() {
		Film film = filmRepository.findById(1L);
		assertThat(film).isNotNull();
	}

	@Test
	@DisplayName("2) 영화 정보 간략 조회")
	void test2() {
		SimpleFilmInfo simpleFilmInfo = filmRepository.findSimpleById(1L);
		assertThat(simpleFilmInfo).hasNoNullFieldsOrProperties();
	}

	@Test
	@DisplayName("3) 영화와 영화에 출연한 배우를 조회한다.")
	void test3() {
		List<FilmWithActor> filmWithActors = filmRepository.findFilmWithActors(1L, 10L);

		System.out.println(filmWithActors);
	}
}
