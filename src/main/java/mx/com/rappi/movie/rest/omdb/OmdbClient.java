package mx.com.rappi.movie.rest.omdb;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import mx.com.rappi.movie.rest.pojo.OmdbMovieResponse;

@Component
public class OmdbClient {

	private static final String KEY = "16620847"; 
	
	private String urlTitle = "http://www.omdbapi.com/?t={title}&apikey=".concat(KEY);
	
	private String urlId = "http://www.omdbapi.com/?i={title}&apikey=".concat(KEY);
	
	private RestTemplate restTemplate;
	
	public OmdbMovieResponse searchMovieByTitle(String title) {
		restTemplate = new RestTemplate();
		return restTemplate.getForObject(urlTitle, OmdbMovieResponse.class, title);
	}
	
	public OmdbMovieResponse searchMovieById(String id) {
		restTemplate = new RestTemplate();
		return restTemplate.getForObject(urlId, OmdbMovieResponse.class, id);
	} 
	
}
