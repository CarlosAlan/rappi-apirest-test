package mx.com.rappi.movie.rest.omdb;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import mx.com.rappi.movie.rest.pojo.OmdbMovieResponse;

@Component
public class OmdbClient {

	private static final String KEY = "16620847"; 
	
	private String url = "http://www.omdbapi.com/?t={title}&apikey=".concat(KEY);
	
	private RestTemplate restTemplate;
	
	public OmdbMovieResponse searchMovieByTitle(String title) {
		restTemplate = new RestTemplate();
		return restTemplate.getForObject(url, OmdbMovieResponse.class, title);
	}
	
}
