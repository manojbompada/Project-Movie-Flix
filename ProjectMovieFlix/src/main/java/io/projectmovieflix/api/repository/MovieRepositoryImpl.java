package io.projectmovieflix.api.repository;

import io.projectmovieflix.api.entity.Movie;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public class MovieRepositoryImpl implements MovieRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Movie> findAll() {
		TypedQuery<Movie> query = em.createQuery("from Movie", Movie.class);
		return query.getResultList();
	}

	@Override
	public Movie findOne(String id) {
		return em.find(Movie.class, id);
	}

	@Override
	public Movie create(Movie movie) {
		em.persist(movie);
		return movie;
	}

	@Override
	public Movie update(Movie movie) {
		em.merge(movie);
		return movie;
	}

	@Override
	public void delete(Movie movie) {
		em.remove(movie);
		
	}

	@Override
	public Movie findByTitle(String title) {
		
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByTitle", Movie.class);
		query.setParameter("pTitle", title);
		List<Movie> movies = query.getResultList();
		
		if (movies != null && movies.size() == 1) {
			return movies.get(0);
		} else {
			return null;
		}		
	}
		
}
