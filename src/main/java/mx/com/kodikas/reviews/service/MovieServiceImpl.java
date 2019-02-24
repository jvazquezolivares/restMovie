package mx.com.kodikas.reviews.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.kodikas.reviews.dao.IMovieDao;
import mx.com.kodikas.reviews.entities.Comment;
import mx.com.kodikas.reviews.entities.Movie;
import mx.com.kodikas.reviews.entities.User;

@Service
public class MovieServiceImpl implements IMovieService{
	
	@Autowired
	private IMovieDao movieDao;

	@Override
	public List<Movie> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Movie> orderByDateAsc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movie findMovie(Movie movie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movie findMovieById(Long idMovie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movie updateMovie(Movie movie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteMovie(Movie movie) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Movie> getMoviesByUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comment> getCommentsByMovie(Movie movie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comment> getCommentsByMovieId(Long idMovie) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
