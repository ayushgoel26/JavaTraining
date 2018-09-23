package com.rentals.domains;

import java.io.*;
import java.util.*;


public class RentManager {
	
	String[] billNo ;
	String[] billDetails ;
	String[] custDetails ;
	String[] itemsList ;
	String[] itemDetails ;

	
	
	public RentManager() {
		super();
		// TODO Auto-generated constructor stub
	}

	HashSet<Bill> billSet = new HashSet<>(); 
	public HashMap<Customer, HashSet<Bill>> rentMap = new HashMap<>();
	
	public boolean printBill(Bill bill) {

		boolean result = false;
		PrintWriter writer = null;

		try {
			writer = new PrintWriter(new FileWriter(new File("BILLS.txt"), true));
			writer.println("Bill: " + bill.getInvoiceID() + "\n");

			for (Items item : bill.getItemSet()) {
				writer.println( item.getItemQuantity() + " " +item.getItemName() + " " + 
						" rented for " + item.getRentalDays() + " days at a price of " + item.getPrice());
			}

			writer.println("\nTotal: " + bill.findTotal() + "\n");

			result = true;

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			writer.close();
		}

		return result;

	}
	public boolean saveBill(){
		boolean status = false;
		ObjectOutputStream outStream = null;
		try {
			
			outStream = new ObjectOutputStream(new FileOutputStream(new File("BillDetails.ser")));
			outStream.writeObject(rentMap);
			status=true;
		
		} catch (Exception e) {
		
			e.printStackTrace();
		
		} finally{
		
			try {
				outStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		}
		return status;
	}
	
	public void retrieveBill(){
		Object obj = null;
		ObjectInputStream inStream = null;
		try {
			inStream = new ObjectInputStream(new FileInputStream(new File("BillDetails.ser")));
			obj = inStream.readObject();
			
			if(obj instanceof HashMap){
				this.rentMap = (HashMap<Customer, HashSet<Bill>> ) obj;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				inStream.close(); 
			} catch (Exception e2) {

			}
		}
	}
	
	
	public String addBill (Customer customer, Bill bill){
			if(this.rentMap.containsKey(customer)){
				HashSet<Bill> bills = this.rentMap.get(customer);
				boolean addBill = bills.add(bill);
				Object obj = this.rentMap.put(customer, bills);
				if (addBill && obj != null ){
					return "Bill Added for " + customer.getCustomerName();
				}
				else {
					return "Bill could not be fixed.";
				}
			} else {
				HashSet<Bill> bills = new HashSet<>();
				boolean addBill = bills.add(bill);
				Object obj = this.rentMap.put(customer, bills);
				if (addBill && obj == null ){
					return "Appointment Added for " + customer.getCustomerName();
				}
				else {
					return "Appointment could not be fixed.";
				}
			}
		}
	
}	
	
