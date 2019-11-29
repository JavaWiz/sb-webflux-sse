package com.javawiz.repository;

import com.javawiz.model.Movie;

import reactor.core.publisher.Flux;

public interface MovieRepository {
	Flux<Movie> findAll();
}
