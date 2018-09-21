package com.training;

import java.io.*;
import java.util.*;

public class Application {

	public static void main(String[] args) {
		Restaurant rest1 = new Restaurant("Shift", "Bangalore", 1.5, 54841568);
		Restaurant rest2 = new Restaurant("Echoes", "Delhi", 2.5, 54841568);
		Restaurant rest3 = new Restaurant("TOIT", "Bangalore", 4.0, 54841568);
		Restaurant rest4 = new Restaurant("Float", "Bangalore", 3.0, 54841568);

		System.out.println(writeToTextFile(rest4));
		System.out.println(writeToTextFile(rest2));
		System.out.println(writeToTextFile(rest1));
		System.out.println(writeToTextFile(rest3));

		
		TreeSet<Restaurant> restaurantSet = readFromTextFile(new File("RestaurantDB.txt"));
		
		for(Restaurant rest : restaurantSet)
			System.out.println(rest.getRestaurantName() + " "+ rest.getRestaurantLocation() + " " + rest.getRestaurantRating());
	}
	
	public static boolean writeToTextFile(Restaurant restaurant){
		boolean result = false;
		PrintWriter writer = null; 
		try {
			writer = new PrintWriter(new FileWriter(new File("RestaurantDB.txt"),true));
			writer.println(restaurant.toString());
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			writer.close();
		}
		return result;
	}
	
	public static TreeSet<Restaurant> readFromTextFile(File file){
		TreeSet<Restaurant> restaurantSet = new TreeSet<>();
		BufferedReader reader = null; 
		try {
			reader = new BufferedReader(new FileReader(file));
			String restAsString;
			while((restAsString = reader.readLine()) != null){
				String[] restaurants = restAsString.split(",");
				Restaurant restaurant = new Restaurant(restaurants[0],restaurants[1],Float.parseFloat(restaurants[2]),Long.parseLong(restaurants[3]));
				restaurantSet.add(restaurant);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return restaurantSet;
		
	}
}
