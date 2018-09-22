package com.rentals.domains;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
		Customer cust = new Customer();
		HashSet<Items> itemBought = new HashSet<Items>();  
		RentManager shopkeeper = new RentManager();
		
		String choice = "Y";
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your name: ");
		String custName = sc.nextLine();
		
		System.out.println("Enter contact Number: ");
		long custNumber = Long.parseLong(sc.nextLine());

		cust.setCustomerContactNo(custNumber);
		cust.setCustomerName(custName);
	
		do {
			System.out.println("What would you like to rent: ");
			System.out.println("Enter 1 for Furniture \nEnter 2 for Car \nEnter 3 for Fan \nEnter 4 for Utensils: ");
			int itemType = Integer.parseInt(sc.nextLine());
			
			System.out.println("Enter Quantity: ");
			int itemQuantity = Integer.parseInt(sc.nextLine());
			
			System.out.println("Enter the number of day: ");
			int itemDaysRented = Integer.parseInt(sc.nextLine());
			
			switch (itemType) {
			case 1:
				itemBought.add(new Furniture(itemQuantity, itemDaysRented));
				break;
			case 2:
				itemBought.add(new Car(itemQuantity, itemDaysRented));
				break;
			case 3:
				itemBought.add(new Fan(itemQuantity, itemDaysRented));
				break;
			case 4:
				itemBought.add(new Utensil(itemQuantity, itemDaysRented));
				break;
			default:
				System.out.println("Invalid Entry!");
				break;
			}
		
			System.out.println("Need to rent more? (Y/N): ");
			choice = sc.nextLine();
		} while(choice.equals("Y")); 
		sc.close();

		Bill bill = new Bill(101, itemBought);
		bill.findTotal();
		System.out.println(bill);
		shopkeeper.addBill(cust, bill);
		shopkeeper.saveBill();
		shopkeeper.retrieveBill();
		
		System.out.println(shopkeeper.rentMap);
		//shopkeeper.writeToTextFile(bill);
		//HashMap<Customer, HashSet<Bill>> a = shopkeeper.readFromTextFile(new File("RentDetails.txt"));
		
	}
}














