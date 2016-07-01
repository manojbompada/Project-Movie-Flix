package io.projectmovieflix.api.service;

import io.projectmovieflix.api.entity.Movie;

import java.util.List;

public interface MovieService {
	public List<Movie> findAll();
	public Movie findOne(String id);
	public Movie create(Movie movie);
	public Movie update(String id, Movie movie);
	public void delete(String id);
}	
