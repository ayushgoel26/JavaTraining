package com.training;

import com.training.dao.impl.MovieDAOImpl;
import com.training.entity.*;
import com.training.utils.DbConnection;

public class Application {

	public static void main(String[] args) {
		
		System.out.println(DbConnection.getOracleConnection());
		
		Movie movie = new Movie(101, "Gold", "Reema Kagti", "Historical Drama", 4.8);
		
		MovieDAO dao = new MovieDAOImpl();
		int rowAdded = dao.addMovie(movie);
		System.out.println(rowAdded + ":= Row Added");
		
		
		MovieDAOImpl obj = (MovieDAOImpl) dao; 
		obj.closeConnection();
	}

}
