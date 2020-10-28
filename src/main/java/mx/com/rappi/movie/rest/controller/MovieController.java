package mx.com.rappi.movie.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import mx.com.rappi.movie.rest.dto.MovieEntity;
import mx.com.rappi.movie.rest.pojo.GeneralResponse;
import mx.com.rappi.movie.rest.pojo.OmdbMovieResponse;
import mx.com.rappi.movie.rest.service.MovieService;

@RestController
@RequestMapping("/api/v1/movies/")
public class MovieController {

	@Autowired
	MovieService service;

	@GetMapping("/ping")
	public GeneralResponse ping() throws JsonProcessingException {
	    return new GeneralResponse("OK", "Welcome to api movie CRUD");
	}
	
	@GetMapping("/find/{title}")
	public OmdbMovieResponse movie(@PathVariable(value = "title") String request) {
		return service.getMovieByTitle(request);
	}
	
	@GetMapping("/all")
	public List<MovieEntity> getAllMoviesSeen(){
		return service.allMovies();
	}
	
	@PostMapping("/add")
	public GeneralResponse addMovie(@Validated @RequestBody MovieEntity request) {
		service.addMovie(request);
		return new GeneralResponse("OK", "Successful operation");
	}
	
	@DeleteMapping("/delete/{id}")
	public GeneralResponse deleteMovieById(@PathVariable(value = "id") Long id) {
		service.deleteMovie(id);
		return new GeneralResponse("OK", "Successful operation");
	}
	
	@PutMapping("/update")
	public GeneralResponse updateMovie(@Validated @RequestBody MovieEntity request) {
		service.updateMovie(request);
		return new GeneralResponse("OK", "Successful operation");
		
	}
}
