package com.rentals.domains;

public class Furniture extends Items {
	
	private String furnitureColor;

	public Furniture(String itemName, double itemPrice, String furnitureColor) {
		super(itemName, itemPrice);
		this.furnitureColor = furnitureColor;
	}

	public String getFurnitureColor() {
		return furnitureColor;
	}

	public void setFurnitureColor(String furnitureColor) {
		this.furnitureColor = furnitureColor;
	}

	@Override
	public String toString() {
		return "Furniture [furnitureColor=" + furnitureColor + "]";
	}
	
	
}
