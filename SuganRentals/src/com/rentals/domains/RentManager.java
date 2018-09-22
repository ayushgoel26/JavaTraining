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
	
	/*
	public boolean writeToTextFile(Bill bill){
		boolean result = false;
		PrintWriter writer = null; 
		try {
			writer = new PrintWriter(new FileWriter(new File("RentDetails.txt"),true));
			writer.println(bill.toString());
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			writer.close();
		}
		return result;
	}
	
	public HashMap<Customer, HashSet<Bill>> readFromTextFile(File file){
		
		HashMap<Customer, HashSet<Bill>> map = new HashMap<>();		
		BufferedReader reader = null; 
		
		try {
			reader = new BufferedReader(new FileReader(file));
			String detailsAsString;
			while((detailsAsString = reader.readLine()) != null){
				splitData(detailsAsString); 
				Customer cust = new Customer(custDetails[0],Long.parseLong(custDetails[1]));
				HashSet<Items> itemSet = new HashSet<>();
				int a = itemsList.length;
				for(String i : itemsList){
					itemDetails = i.split("-");
					switch (itemDetails[0]) {
					case "Car":
						itemSet.add(new Car(Integer.parseInt(itemDetails[2]), Integer.parseInt(itemDetails[3])));
						break;
					case "Furniture":
						itemSet.add(new Furniture(Integer.parseInt(itemDetails[2]), Integer.parseInt(itemDetails[3])));
						break;
					case "Fan":
						itemSet.add(new Fan(Integer.parseInt(itemDetails[2]), Integer.parseInt(itemDetails[3])));
						break;
					case "Utensil":
						itemSet.add(new Utensil(Integer.parseInt(itemDetails[2]), Integer.parseInt(itemDetails[3])));
						break;
					default:
						break;
					} 
				}
				Bill bill = new Bill(0, cust, itemSet);
				bill.findTotal();
				map.put(cust, null);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
		
	}
	
	
	
	
	public void splitData(String str){
		billNo = str.split(":="); // Invoice ID in billDetails[0]
		billDetails = billNo[1].split(";"); // Customer Details in [0]; Total in [2]; item set in [1]
		custDetails = billDetails[0].split("*"); 
		itemsList = billDetails[1].split(",");		
		
		
	}
	*/
	//101:=Ayush*98988263763876;[Car-2000.0-3-4, Furniture-450.0-2-3];26700.0

		/*
		 * := invoice id and detail
		 * ;  bill details into customer details, items and total
		 * *  customer name and number 
		 * ,  different items
		 * -  item details - name quanity price days 
		 * 
		 * */

