package com.training;

public class Movie {
	
	private long movieId;
	private String movieName;
	
	public Movie() {
		super();
	}
	
	public Movie(long movieId, String movieName) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
	}
	
	public long getMovieId() {
		return movieId;
	}
	
	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}
	
	public String getMovieName() {
		return movieName;
	}
	
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + "]";
	}
	
}
