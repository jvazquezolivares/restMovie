package mx.com.kodikas.reviews.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public List<Movie> listAll(){
		return null;
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
	public List<Comment	> movieComments(@PathVariable Long id) {
		return null;
	}
	
	@PutMapping("movie/{id}")
	public ResponseEntity<?> updateMovie(
			@PathVariable(value="id")Long id, @RequestBody Movie movie) {
		Movie entity = movieService.findMovieById(id);
		
		return null;
	}

}
