package mx.com.rappi.movie.rest.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.rappi.movie.rest.dto.MovieEntity;
import mx.com.rappi.movie.rest.omdb.OmdbClient;
import mx.com.rappi.movie.rest.pojo.MovieResponse;
import mx.com.rappi.movie.rest.pojo.OmdbMovieResponse;
import mx.com.rappi.movie.rest.repository.MovieRepository;

@Service
public class MovieService {

	private static final Logger logger = LoggerFactory.getLogger(MovieService.class);
	
	@Autowired
	private OmdbClient omdbClient;
	
	@Autowired
	private MovieRepository movieRepository;
	
	public MovieResponse getMovieByTitle(String title) {
		OmdbMovieResponse movie = omdbClient.searchMovieByTitle(title);
		MovieEntity entity = null;
		try{
			entity = movieRepository.findByImdbId(movie.getImdbID());
		}catch(Exception e){
			logger.error("Error: unseen movie");
		}
		return new MovieResponse.Builder()
						.setImdbId(movie.getImdbID())
						.setTitle(movie.getTitle())
						.setYear(movie.getYear())
						.setRuntime(movie.getRuntime())
						.setGenre(movie.getGenre())
						.setDirector(movie.getDirector())
						.setWriter(movie.getWriter())
						.setActors(movie.getActors())
						.setViewDate(entity == null ? new Date() : entity.getViewDate())
						.setRating(entity == null ? 0L : entity.getRating())
						.setComments(entity == null ? "" : entity.getComments())
						.buid();
	}
	
	public void addMovie(MovieEntity entity) {
		try {
			movieRepository.save(entity);
		}catch(IllegalArgumentException iae) {
			logger.error("Error");
		}
	} 
	
	public List<MovieResponse> allMovies() {
		
		List<MovieResponse> response = new ArrayList<>();
		
		List<MovieEntity> seenMovies = movieRepository.findAll();
		
		for(MovieEntity seenMovie: seenMovies) {
			OmdbMovieResponse movie = omdbClient.searchMovieById(seenMovie.getImdbId());
			response.add(new MovieResponse.Builder()
						.setImdbId(movie.getImdbID())
						.setTitle(movie.getTitle())
						.setYear(movie.getYear())
						.setRuntime(movie.getRuntime())
						.setGenre(movie.getGenre())
						.setDirector(movie.getDirector())
						.setWriter(movie.getWriter())
						.setActors(movie.getActors())
						.setViewDate(seenMovie.getViewDate())
						.setRating(seenMovie.getRating())
						.setComments(seenMovie.getComments())
						.buid()
						);
		}
		
		return response;
		
	}
	
	public void deleteMovie(Long id) {
		movieRepository.deleteById(id);
	}
	
	public void updateMovie(MovieEntity entity) {
		Optional<MovieEntity> entityToUpdate = movieRepository.findById(entity.getId());
		if(entityToUpdate.isPresent()) {
			entityToUpdate.get().setRating(entity.getRating());
			entityToUpdate.get().setComments(entity.getComments());
			movieRepository.save(entityToUpdate.get());
		}else {
			logger.error("La entidad no existe");
		}
	}
	
}
