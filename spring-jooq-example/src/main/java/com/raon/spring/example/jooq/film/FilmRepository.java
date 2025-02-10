package com.raon.spring.example.jooq.film;

import java.util.List;

import org.jooq.DSLContext;
import org.jooq.generated.tables.JActor;
import org.jooq.generated.tables.JFilm;
import org.jooq.generated.tables.JFilmActor;
import org.jooq.generated.tables.pojos.Film;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Repository;

@Repository
public class FilmRepository {

	private final DSLContext dslContext;

	public FilmRepository(DSLContext dslContext) {
		this.dslContext = dslContext;
	}

	private final JFilm FILM = JFilm.FILM;

	public Film findById(Long id) {
		return dslContext.select(FILM.fields())
			.from(FILM)
			.where(FILM.FILM_ID.eq(id))
			.fetchOneInto(Film.class);
	}

	public SimpleFilmInfo findSimpleById(Long id) {
		return dslContext.select(
				FILM.FILM_ID,
				FILM.TITLE,
				FILM.DESCRIPTION
			).from(FILM)
			.where(FILM.FILM_ID.eq(id))
			.fetchOneInto(SimpleFilmInfo.class);
	}

	public List<FilmWithActor> findFilmWithActors(Long page, Long pageSize) {
		JFilmActor FILM_ACTOR = JFilmActor.FILM_ACTOR;
		JActor ACTOR = JActor.ACTOR;

		return dslContext.select(
				DSL.row(FILM.fields()),
				DSL.row(FILM_ACTOR.fields()),
				DSL.row(ACTOR.fields())
			).from(FILM)
			.innerJoin(FILM_ACTOR).on(FILM.FILM_ID.eq(FILM_ACTOR.FILM_ID))
			.innerJoin(ACTOR).on(FILM_ACTOR.ACTOR_ID.eq(ACTOR.ACTOR_ID))
			.limit(pageSize).offset(pageSize * (page - 1))
			.fetchInto(FilmWithActor.class);
	}
}
