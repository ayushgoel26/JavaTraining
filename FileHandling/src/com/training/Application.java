package com.training;

import java.io.File;
import java.util.List;

public class Application {

	public static void main(String[] args) {
		
		Address addr1 = new Address("Gandhi Street", "Nehru Nagar", "Chennai", 600117);
		Customer ramesh1 = new Customer(101, "Ramesh Babu", addr1,98404040);
		boolean custSaved;
		ObjectHandling objHandle = new ObjectHandling();
		
		//Serialisation
		custSaved = objHandle.saveObject(ramesh1);
		
		if(custSaved){
			System.out.println("cust added");
		}
		else{
			System.out.println("cust not added");
		}
		
		//De-serialisation
		Customer obj = (Customer) objHandle.loadObject();
		System.out.println(obj);
		
		boolean status = objHandle.writeToTextFile(ramesh1);
		if(status){
			System.out.println("File Created");
		}else{
			System.out.println("No File created");
		}

		List<Customer> custList = objHandle.readFromTextFile(new File("customer.txt"));
		System.out.println(custList);
		
	
	}

	
}
