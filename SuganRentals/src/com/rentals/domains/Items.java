package com.rentals.domains;

import java.io.Serializable;

import com.rentals.ifaces.*;

public class Items implements Billable, Serializable {
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
		return this.itemName + " at a price of " + this.itemPrice + " for " + this.rentalDays + "days - " + this.itemQuantity +  " pieces";
	}


	@Override
	public double getPrice() {
		if (this.rentalDays > 10) {
			return this.itemPrice * this.itemQuantity * this.rentalDays * 0.9;
		}
		return this.itemPrice * this.itemQuantity * this.rentalDays;
	}
	
	
}
