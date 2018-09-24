package com.training.entity;

import java.util.List;

public interface MovieDAO {
	
	public int addMovie(Movie movie) throws Exception;
	public List<Movie> findAll() throws Exception;
	
	public int remove(long movieId) throws Exception;
	public int updateRating(long movieId, double currentRating) throws Exception;
	
	public Movie findByPrimaryKey(long movieId) throws Exception;
}
