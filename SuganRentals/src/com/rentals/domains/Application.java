package com.rentals.domains;

import java.util.HashSet;
import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
		
		RentManager shopkeeper = new RentManager();

		String choice = "Y";
		int id = 101;
		String newCust = "Y";

		Scanner sc = new Scanner(System.in);

		do {
			Customer cust = new Customer();
			HashSet<Items> itemBought = new HashSet<Items>();
			
			System.out.println("Enter your name: ");
			String custName = sc.nextLine();

			System.out.println("Enter contact Number: ");
			long custNumber = Long.parseLong(sc.nextLine());

			cust.setCustomerContactNo(custNumber);
			cust.setCustomerName(custName);
			Bill bill = new Bill(id, itemBought);
			do {

				System.out.println("What would you like to rent: ");
				System.out
						.println("Enter 1 for Furniture \nEnter 2 for Car \nEnter 3 for Fan \nEnter 4 for Utensils: ");
				int itemType = Integer.parseInt(sc.nextLine());

				System.out.println("Enter Quantity: ");
				int itemQuantity = Integer.parseInt(sc.nextLine());

				System.out.println("Enter the number of day: ");
				int itemDaysRented = Integer.parseInt(sc.nextLine());
				
				if(itemDaysRented > 10)
					System.out.println("10% discount will be given on " + itemType);

				switch (itemType) {
				case 1:
					bill.addItem(new Furniture(itemQuantity, itemDaysRented));
					break;
				case 2:
					bill.addItem(new Car(itemQuantity, itemDaysRented));
					break;
				case 3:
					bill.addItem(new Fan(itemQuantity, itemDaysRented));
					break;
				case 4:
					bill.addItem(new Utensil(itemQuantity, itemDaysRented));
					break;
				default:
					System.out.println("Invalid Entry!");
					break;
				}
				

				System.out.println("Need to rent more? (Y/N): ");
				choice = sc.nextLine();

			} while (choice.equals("Y"));
			bill.findTotal();
			shopkeeper.addBill(cust, bill);
			shopkeeper.saveBill();
			shopkeeper.printBill(bill);
			id++;
			System.out.println("Another Customer? (Y/N): ");
			newCust = sc.nextLine();
		} while (newCust.equals("Y"));
		shopkeeper.retrieveBill();

		sc.close();

		System.out.println(shopkeeper.rentMap);

	}
}