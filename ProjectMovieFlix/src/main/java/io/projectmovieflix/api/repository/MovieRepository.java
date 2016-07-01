package io.projectmovieflix.api.repository;


import io.projectmovieflix.api.entity.Movie;

import java.util.List;

public interface MovieRepository {
	
	public List<Movie> findAll();

	public Movie findOne(String id);
	
	public Movie findByTitle(String title);

	public Movie create(Movie movie);

	public Movie update(Movie movie);

	public void delete(Movie movie);
}
