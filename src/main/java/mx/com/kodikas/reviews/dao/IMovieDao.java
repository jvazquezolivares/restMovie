package mx.com.kodikas.reviews.dao;

import org.springframework.data.repository.CrudRepository;

import mx.com.kodikas.reviews.entities.Movie;

public interface IMovieDao extends CrudRepository<Movie, Long>{

}
