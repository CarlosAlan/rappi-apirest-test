package mx.com.rappi.movie.rest.controller;

import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import mx.com.rappi.movie.rest.dto.MovieEntity;
import mx.com.rappi.movie.rest.pojo.MovieResponse;
import mx.com.rappi.movie.rest.service.MovieService;

@SpringBootTest
public class ControllerTest {

	@Mock
	private MovieService movieService;
	
	@InjectMocks
	private MovieController movieController = new MovieController();
	
	@Test
	public void findTest() {
		
		MovieResponse movie = new MovieResponse.Builder()
				.setImdbId("imdbf6354")
				.setTitle("Test")
				.setYear("2020")
				.setRuntime("1:30")
				.setGenre("Terror")
				.setDirector("Rappi")
				.setWriter("Rappi")
				.setActors("GoNet")
				.setViewDate(new Date())
				.setRating(0L)
				.setComments("Sin comentarios")
				.build();
		
		Mockito.when(movieService.getMovieByTitle("Test")).thenReturn(movie);
		
		assertThatCode(() -> {
			movieController.movie("Test");
		}).doesNotThrowAnyException();
		
	}
	
	@Test
	public void getAllSeenMoviesTest() {
		List<MovieResponse> movies = new ArrayList<>();
		
		movies.add(new MovieResponse.Builder()
				.setImdbId("imdbf6354")
				.setTitle("Test")
				.setYear("2020")
				.setRuntime("1:30")
				.setGenre("Terror")
				.setDirector("Rappi")
				.setWriter("Rappi")
				.setActors("GoNet")
				.setViewDate(new Date())
				.setRating(0L)
				.setComments("Sin comentarios")
				.build()
			);
		
		Mockito.when(movieService.allMovies()).thenReturn(movies);
		
		assertThatCode(() -> {
			movieController.getAllMoviesSeen();
		}).doesNotThrowAnyException();
		
	}
	
	@Test
	public void addSeenMovieTest() {
		MovieEntity entity = new MovieEntity();
		entity.setImdbId("imbd36874");
		entity.setTitle("Test");
		
		Mockito.doNothing().when(movieService).addMovie(entity);
		
		assertThatCode(() -> {
			movieController.addMovie(entity);
		}).doesNotThrowAnyException();
		
	}
	
	@Test
	public void removeSeenMovieTest() {
		
		Mockito.doNothing().when(movieService).deleteMovie(3L);
		
		assertThatCode(() -> {
			movieController.deleteMovieById(3L);
		}).doesNotThrowAnyException();
		
	}
	
	@Test
	public void updateSeenMovieTest() {
		MovieEntity entity = new MovieEntity();
		entity.setImdbId("imbd36874");
		entity.setTitle("Test");
		
		Mockito.doNothing().when(movieService).updateMovie(entity);
		
		assertThatCode(() -> {
			movieController.updateMovie(entity);
		}).doesNotThrowAnyException();
		
	}
	
}
