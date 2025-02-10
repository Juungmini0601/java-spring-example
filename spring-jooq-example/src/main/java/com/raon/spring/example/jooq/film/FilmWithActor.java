package com.raon.spring.example.jooq.film;

import org.jooq.generated.tables.pojos.Actor;
import org.jooq.generated.tables.pojos.Film;
import org.jooq.generated.tables.pojos.FilmActor;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class FilmWithActor {
	private final Film film;
	private final FilmActor filmActor;
	private final Actor actor;
}
