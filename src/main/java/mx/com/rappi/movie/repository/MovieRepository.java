package mx.com.rappi.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.rappi.movie.rest.dto.MovieEntity;

public interface MovieRepository extends JpaRepository<MovieEntity, Long>{
	
}
