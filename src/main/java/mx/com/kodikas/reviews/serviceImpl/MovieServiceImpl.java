package mx.com.kodikas.reviews.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.kodikas.reviews.dao.IMovieDao;
import mx.com.kodikas.reviews.dao.IUserDao;
import mx.com.kodikas.reviews.entities.Comment;
import mx.com.kodikas.reviews.entities.Movie;
import mx.com.kodikas.reviews.service.IMovieService;

@Service
public class MovieServiceImpl implements IMovieService{
	
	@Autowired
	private IMovieDao movieDao;
	
	@Autowired
	private IUserDao userDao;

	@Override
	public List<Movie> findAll() {
		return (List<Movie>) movieDao.findAll();
	}

	@Override
	public List<Movie> orderByDateAsc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movie findMovie(Movie movie) {
		return movieDao.findById(movie.getId()).get();
	}

	@Override
	public Movie findMovieById(Long idMovie) {
		return movieDao.findById(idMovie).get();
	}

	@Override
	@Transactional
	public Movie updateMovie(Movie movie) {
		return movieDao.save(movie);
	}

	@Override
	@Transactional
	public void deleteMovie(Movie movie) {
		movieDao.delete(movie);
		
	}

	@Override
	public List<Comment> getCommentsByMovie(Movie movie) {
		return movieDao.findById(movie.getId()).get().getComments();
	}

	@Override
	public List<Comment> getCommentsByMovieId(Long idMovie) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
