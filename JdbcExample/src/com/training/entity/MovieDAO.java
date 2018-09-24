package com.training.entity;

import java.util.List;

public interface MovieDAO {
	
	public int addMovie(Movie movie);
	public List<Movie> findAll();
	public int remove(long movieId);
	public int updateRating(long movieId, double currentRating);
	
}
