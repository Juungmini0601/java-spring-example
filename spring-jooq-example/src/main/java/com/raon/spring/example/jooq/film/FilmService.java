package com.raon.spring.example.jooq.film;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FilmService {
	private final FilmRepository filmRepository;

	public void getFilmActorPageResponse(Long page, Long pageSize) {
		filmRepository.findFilmWithActors(page, pageSize);
	}
}
