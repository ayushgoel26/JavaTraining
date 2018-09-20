package com.training.domains;

public class Application {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Address addr1 = new Address("Gandhi Street", "Nehru Nagar", "Chennai", -600117);
		Address addr2 = new Address("Rajiv Street", "Inidra Nagar", "Chennai", 500001);
		Customer ramesh1 = new Customer(101, "Ramesh Babu", addr1,98404040);
		Customer ramesh2 = new Customer(101, "Ramesh Babu", addr2,98404040);
		ramesh2 = null; 
		System.out.println("Are they equal? " + ramesh1.equals(ramesh2));
		Customer ramesh3 = null;
		System.out.println(ramesh1.equals(ramesh3));
		
		try {
			ramesh1.getAddress().setPincode(-5050);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.gc();

	}
	

}
