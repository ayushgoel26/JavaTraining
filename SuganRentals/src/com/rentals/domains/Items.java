package com.rentals.domains;

import com.rentals.ifaces.*;

public class Items implements Billable {
	private String itemName;
	private double itemPrice;
	private int itemQuantity;
	private int rentalDays;
	

	public Items(String itemName, double itemPrice, int itemQuantity, int rentalDays) {
		super();
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemQuantity = itemQuantity;
		this.rentalDays = rentalDays;
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

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public int getRentalDays() {
		return rentalDays;
	}

	public void setRentalDays(int rentalDays) {
		this.rentalDays = rentalDays;
	}

	@Override
	public String toString() {
		return this.itemName + "," + this.itemPrice + "," + this.itemQuantity + "," + this.rentalDays;
	}


	@Override
	public double getPrice() {
		return this.itemPrice * this.itemQuantity * this.rentalDays;
	}
	
	
}
