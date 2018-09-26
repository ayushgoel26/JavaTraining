package com.training.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.training.entity.Movie;
import com.training.entity.MovieDAO;
import com.training.entity.DAO;
import com.training.utils.DbConnection;

import java.sql.*;

public class MovieDAOImpl implements MovieDAO<Movie> {

	private Connection con;

	public MovieDAOImpl() {
		super();
		con = DbConnection.getOracleConnection();
	}

	@Override
	public int add(Movie movie) throws Exception {

		String sql = "Insert into movieag values(?,?,?,?,?)";
		PreparedStatement pstmt = null;
		int rowAdded = 0;
		pstmt = con.prepareStatement(sql);
		pstmt.setLong(1, movie.getMovieId());
		pstmt.setString(2, movie.getMovieName());
		pstmt.setString(3, movie.getDirector());
		pstmt.setString(4, movie.getGenre());
		pstmt.setDouble(5, movie.getRating());

		rowAdded = pstmt.executeUpdate();

		pstmt.close();

		return rowAdded;
	}

	@Override
	public int updateRating(long movieId, double currentRating) throws Exception {
		String sql = "update movieag set rating = ? where movieId = ?";
		PreparedStatement pstmt = null;
		int rowUpdated = 0;

		pstmt = con.prepareStatement(sql);
		pstmt.setDouble(1, currentRating);
		pstmt.setLong(2, movieId);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			rowUpdated = rowUpdated + 1;
		}
		pstmt.close();

		return rowUpdated;
	}

	@Override
	public Movie findByPrimaryKey(long movieId) throws Exception {
		String sql = "select * from movieag where movieId = ?";
		PreparedStatement pstmt = null;
		Movie movie = null;

		pstmt = con.prepareStatement(sql);
		pstmt.setLong(1, movieId);

		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			String movieName = rs.getString("movieName");
			String director = rs.getString("director");
			String genre = rs.getString("genre");
			Double rating = rs.getDouble("rating");

			movie = new Movie(movieId, movieName, director, genre, rating);
		}

		pstmt.close();

		return movie;
	}

	@Override
	public List<Movie> findAll() throws Exception {
		String sql = "select * from movieag";
		PreparedStatement pstmt = null;

		List<Movie> movieList = new ArrayList<>();

		pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			long movieId = rs.getLong("movieId");
			String movieName = rs.getString("movieName");
			String director = rs.getString("director");
			String genre = rs.getString("genre");
			Double rating = rs.getDouble("rating");

			Movie movie = new Movie(movieId, movieName, director, genre, rating);
			movieList.add(movie);

		}
		pstmt.close();

		return movieList;
	}

	@Override
	public int remove(long movieId) throws Exception {

		int rowsDeleted = 0;

		String sql = "DELETE FROM MOVIEAG WHERE MOVIEID=?";
		PreparedStatement pstmt = null;

		pstmt = con.prepareStatement(sql);
		pstmt.setLong(1, movieId);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			rowsDeleted = rowsDeleted + 1;
		}
		pstmt.close();

		return rowsDeleted;
	}

	public void closeConnection() {

		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
