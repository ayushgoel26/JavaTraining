package com.training.dao.impl;

import java.util.List;

import com.training.entity.Movie;
import com.training.entity.MovieDAO;
import com.training.utils.DbConnection;

import java.sql.*;

public class MovieDAOImpl implements MovieDAO {
	
	private Connection con;
	
	public MovieDAOImpl() {
		super();
		con = DbConnection.getOracleConnection();
	}

	@Override
	public int addMovie(Movie movie) {
		
		String sql = "Insert into movieag values(?,?,?,?,?)";
		PreparedStatement pstmt = null;
		int rowAdded = 0;
		
		try {
			pstmt = con.prepareStatement(sql); 
			pstmt.setLong(1, movie.getMovieId());
			pstmt.setString(2, movie.getMovieName());
			pstmt.setString(3, movie.getDirector());
			pstmt.setString(4, movie.getGenre());
			pstmt.setDouble(5, movie.getRating());
			
			rowAdded = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rowAdded;
	}

	@Override
	public List<Movie> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int remove(long movieId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateRating(long movieId, double currentRating) {
		// TODO Auto-generated method stub
		return 0;
	}
	

	public void closeConnection(){
		
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
