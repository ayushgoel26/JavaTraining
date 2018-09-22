package com.rentals.domains;

import java.util.HashSet;

public class Application {
	public static void main(String[] args) {
		
		Customer ayush = new Customer("Ayush", 9999888);
		HashSet<Items> itemBought = new HashSet<Items>();  
		String choice = "N";
		do {
			
			itemBought.add(new Furniture(5, 5));
		} while(choice == "Y"); 
		
		Bill bill1 = new Bill(101, ayush, itemBought);

	}
}
