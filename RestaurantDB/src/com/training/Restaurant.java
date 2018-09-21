package com.training;

import java.io.Serializable;

public class Restaurant implements Serializable, Comparable<Restaurant> {

	private String restaurantName;
	private String restaurantLocation;
	private double restaurantRating;
	private long restaurantNumber;

	public Restaurant(String restaurantName, String restaurantLocation, double restaurantRating, long restaurantNumber) {
		this.restaurantName = restaurantName;
		this.restaurantLocation = restaurantLocation;
		this.restaurantRating = restaurantRating;
		this.restaurantNumber = restaurantNumber;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getRestaurantLocation() {
		return restaurantLocation;
	}

	public void setRestaurantLocation(String restaurantLocation) {
		this.restaurantLocation = restaurantLocation;
	}

	public double getRestaurantRating() {
		return restaurantRating;
	}

	public void setRestaurantRating(float restaurantRating) {
		this.restaurantRating = restaurantRating;
	}

	public long getRestaurantNumber() {
		return restaurantNumber;
	}

	public void setRestaurantNumber(long restaurantNumber) {
		this.restaurantNumber = restaurantNumber;
	}
	
	@Override
	public String toString() {
		return restaurantName + "," + restaurantLocation + "," + restaurantRating + "," + restaurantNumber;
	}

	@Override
	public int compareTo(Restaurant otherRestaurant) {
		if(this.getRestaurantRating()>otherRestaurant.getRestaurantRating()) return -1;
		if(this.getRestaurantRating()<otherRestaurant.getRestaurantRating()) return 1;
		return 0;
	}

}
