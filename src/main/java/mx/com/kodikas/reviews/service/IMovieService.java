package mx.com.kodikas.reviews.service;

import java.util.List;

import mx.com.kodikas.reviews.entities.Comment;
import mx.com.kodikas.reviews.entities.Movie;

public interface IMovieService {
    public List<Movie> findAll();
    
    public List<Movie> orderByDateAsc();
    
    public Movie findMovie(Movie movie);
    
    public Movie findMovieById(Long idMovie);
    
    public Movie updateMovie(Movie movie);
    
    public void deleteMovie(Movie movie);
    
    public List<Comment> getCommentsByMovie(Movie movie);
    
    public List<Comment> getCommentsByMovieId(Long idMovie);
    
    public Movie createMovie(Movie movie);
    
}
