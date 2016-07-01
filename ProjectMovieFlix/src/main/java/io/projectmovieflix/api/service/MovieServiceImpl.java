package io.projectmovieflix.api.service;

import io.projectmovieflix.api.entity.Movie;
import io.projectmovieflix.api.exception.MovieNotFound;
import io.projectmovieflix.api.repository.MovieRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private MovieRepository repository;

	@Override
	public List<Movie> findAll() {
		return repository.findAll();
	}

	@Override
	public Movie findOne(String id) {
		Movie existingMovie = repository.findOne(id);
		if(existingMovie == null){
			throw new MovieNotFound("Movie with id: "+ id+" not found");
		}
		return existingMovie;		
	}

	@Override
	public Movie create(Movie movie) {
		Movie existingMovie = repository.findByTitle(movie.getTitle());
		if(existingMovie == null){
			throw new MovieNotFound("Movie with title "+movie.getTitle()+ " already exists");
		}
		return repository.create(movie);
	}

	@Override
	public Movie update(String id, Movie movie) {
		Movie existingMovie = repository.findOne(id);
		if(existingMovie == null){
			throw new MovieNotFound("Movie with id: "+ id+" not found");
		}
		return repository.update(movie);	
	}

	@Override
	public void delete(String id) {
		Movie existingMovie = repository.findOne(id);
		if(existingMovie == null){
			throw new MovieNotFound("Movie with id: "+ id+" not found");
		}
	     repository.delete(existingMovie);
	}

}
