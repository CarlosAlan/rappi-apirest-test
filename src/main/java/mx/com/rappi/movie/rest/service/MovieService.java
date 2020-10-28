package mx.com.rappi.movie.rest.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.rappi.movie.repository.MovieRepository;
import mx.com.rappi.movie.rest.dto.MovieEntity;
import mx.com.rappi.movie.rest.omdb.OmdbClient;
import mx.com.rappi.movie.rest.pojo.OmdbMovieResponse;

@Service
public class MovieService {

	private static final Logger logger = LoggerFactory.getLogger(MovieService.class);
	
	@Autowired
	private OmdbClient omdbClient;
	
	@Autowired
	private MovieRepository movieRepository;
	
	public OmdbMovieResponse getMovieByTitle(String title) {
		
		return omdbClient.searchMovieByTitle(title);	
	}
	
	public void addMovie(MovieEntity entity) {
		try {
			movieRepository.save(entity);
		}catch(IllegalArgumentException iae) {
			logger.error("Error");
		}
	} 
	
	public List<MovieEntity> allMovies() {
		return movieRepository.findAll();
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
