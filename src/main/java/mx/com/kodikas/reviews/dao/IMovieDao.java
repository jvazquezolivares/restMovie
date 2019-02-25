package mx.com.kodikas.reviews.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.kodikas.reviews.entities.Movie;

public interface IMovieDao extends JpaRepository<Movie, Long>{

}
