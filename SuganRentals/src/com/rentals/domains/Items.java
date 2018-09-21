package com.rentals.domains;

public abstract class Items {
	private String itemName;
	private double itemPrice;
	
	public Items(String itemName, double itemPrice) {
		super();
		this.itemName = itemName;
		this.itemPrice = itemPrice;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	@Override
	public String toString() {
		return "Items [itemName=" + itemName + ", itemPrice=" + itemPrice + "]";
	}
	
	
	

}
