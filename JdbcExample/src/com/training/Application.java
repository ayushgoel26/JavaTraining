package com.training;

import java.util.List;

import com.training.dao.impl.MovieDAOImpl;
import com.training.entity.*;
import com.training.utils.DbConnection;

public class Application {


	
	
	
	
	
	public static void main(String[] args) {

		System.out.println(DbConnection.getOracleConnection());
		MovieDAO<Movie> dao = new MovieDAOImpl();

		int key = 6;
		try {
			switch (key) {
			
			case 1:
				
				Movie gold = new Movie(101, "Gold", "Reema Kagti", "Historical Drama", 4.8);
				// Movie 3idiots = new Movie(102, "3 idiots", "Rajkumar Hirani", "Comedy Drama", 4.9);
				// Movie sholay = new Movie(103, "Sholay", "Ramesh Sippy", "Drama", 4.5);
				int rowAdded = dao.add(gold);
				System.out.println(rowAdded + ":= Row Added");
				break;
				
			case 2:
				
				List<Movie> movieList = dao.findAll();
				movieList.forEach(System.out::println);
				// System.out.println(movieList);
				break;
				
			case 3:
				
				Movie movie = (Movie) dao.findByPrimaryKey(103);
				if (movie != null)
					System.out.println(movie);
				else
					System.out.println("movie id is invalid");
				break;
				
			case 4:
				
				int rows = dao.remove(101);
				System.out.println(rows + " row(s) deleted");
				break;
				
			case 5:
				
				int rowUpdated = (dao).updateRating(101, 5.0);
				System.out.println(rowUpdated + " row(s) updated");
				break;
			
			case 6: 
				
				break;
				
			default:
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		MovieDAOImpl obj = (MovieDAOImpl) dao;
		obj.closeConnection();

	}

}
