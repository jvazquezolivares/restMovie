package mx.com.kodikas.reviews.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.kodikas.reviews.entities.Comment;
import mx.com.kodikas.reviews.entities.Movie;
import mx.com.kodikas.reviews.service.IMovieService;

@RestController
@RequestMapping("/api/movies")
public class MovieRestController {
	
	@Autowired
	IMovieService movieService; 
	
	@GetMapping("listAll")
	public ResponseEntity<?> listAll(){
		List<Movie> movies = movieService.findAll();
		if(movies != null && !movies.isEmpty()) {
			return new ResponseEntity<>(movies, HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping("movie/{id}")
	public ResponseEntity<?> findMovie(@PathVariable Long id) {
		Movie entity = movieService.findMovieById(id);
		if(entity != null) {
			return new ResponseEntity<>(entity, HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("movie/{id}/comments")
	public ResponseEntity<?> movieComments(@PathVariable Long id) {
		Movie movie = movieService.findMovieById(id);
		List<Comment> movieComments = null;
		if(movie != null) {
			movieComments = movie.getComments();
			return new ResponseEntity<>(movieComments, HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("create")
	public ResponseEntity<?> createMovie(@RequestBody Movie movieParam){
		Movie movie = movieService.createMovie(movieParam);
		if (movie != null) {
			return new ResponseEntity<>(movie, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
}
