package mx.com.kodikas.reviews.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.kodikas.reviews.entities.Comment;
import mx.com.kodikas.reviews.entities.Movie;

@RestController
@RequestMapping("/api/movies")
public class MovieRestController {
	
	@GetMapping("listAll")
	public List<Movie> listAll(){
		return null;
	}
	
	@GetMapping("movie/{id}")
	public Movie findMovie(@PathVariable Long id) {
		return null;
	}
	
	@GetMapping("movie/{id}/comments")
	public List<Comment	> movieComments(@PathVariable Long id) {
		return null;
	}
	
	@PutMapping("movie")
	public Movie updateMovie(Movie movie) {
		return null;
	}

}
