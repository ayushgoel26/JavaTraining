package com.rentals.domains;

public class Car extends Items {
	private String carColor;

	public Car(String carMake, String carModel, String carColor, double carPrice) {
		super(carMake+"-"+carModel,carPrice);
		this.carColor = carColor;
	}

	public String getCarColor() {
		return carColor;
	}

	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}

	@Override
	public String toString() {
		return "Car [carColor=" + carColor + "]";
	}

	
}