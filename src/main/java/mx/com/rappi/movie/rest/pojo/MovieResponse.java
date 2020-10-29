package mx.com.rappi.movie.rest.pojo;

import java.io.Serializable;
import java.util.Date;

public class MovieResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	private String imdbId;
	private String title;
	private String year;
	private String runtime;
    private String genre;
    private String director;
    private String writer;
    private String actors;
	private Date viewDate; 
	private Long rating;
	private String comments;

	public String getImdbId() {
		return imdbId;
	}

	public String getTitle() {
		return title;
	}

	public String getYear() {
		return year;
	}

	public String getRuntime() {
		return runtime;
	}

	public String getGenre() {
		return genre;
	}

	public String getDirector() {
		return director;
	}

	public String getWriter() {
		return writer;
	}

	public String getActors() {
		return actors;
	}

	public Date getViewDate() {
		return viewDate;
	}

	public Long getRating() {
		return rating;
	}

	public String getComments() {
		return comments;
	}
	
	public static class Builder {
		String imdbId;
		String title;
		String year;
		String runtime;
	    String genre;
	    String director;
	    String writer;
	    String actors;
		Date viewDate; 
		Long rating;
		String comments;
		
		public Builder setImdbId(String imdbId) {
			this.imdbId = imdbId;
			return this;
		}
		
		public Builder setTitle(String title) {
			this.title = title;
			return this;
		}
		
		public Builder setYear(String year) {
			this.year = year;
			return this;
		}
		
		public Builder setRuntime(String runtime) {
			this.runtime = runtime;
			return this;
		}
		
		public Builder setGenre(String genre) {
			this.genre = genre;
			return this;
		}
		
		public Builder setDirector(String director) {
			this.director = director;
			return this;
		}
		
		public Builder setWriter(String writer) {
			this.writer = writer;
			return this;
		}
		
		public Builder setActors(String actors) {
			this.actors = actors;
			return this;
		}
		
		public Builder setViewDate(Date viewDate) {
			this.viewDate = viewDate;
			return this;
		}
		
		public Builder setRating(Long rating) {
			this.rating = rating;
			return this;
		}
		
		public Builder setComments(String comments) {
			this.comments = comments;
			return this;
		}
		
		public MovieResponse build() {
			MovieResponse response = new MovieResponse();
			response.imdbId = this.imdbId;
			response.title = this.title;
			response.year = this.year;
			response.runtime = this.runtime;
			response.genre = this.genre;
			response.director = this.director;
			response.writer = this.writer;
			response.actors = this.actors;
			response.viewDate = this.viewDate;
			response.rating = this.rating;
			response.comments = this.comments;
			return response;
		}
		
	}
	
}
