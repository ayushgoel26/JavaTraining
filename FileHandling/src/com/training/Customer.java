package com.training;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Customer implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8L;
	private long customerID;
	private String customerName;
	private Address address;
	private transient long mobileNumber;
	
//	private static String mentorName = "Nandamuri Taraka Rama Rao Garu";
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Customer(long customerID, String customerName, long mobileNumber) {
		this.customerID = customerID;
		this.customerName = customerName;
		this.mobileNumber = mobileNumber;
	}



	public Customer(long customerID, String customerName, Address address, long mobileNumber) {
		this.customerID = customerID;
		this.customerName = customerName;
		this.address = address;
		this.mobileNumber = mobileNumber;
	}
	
	public long getCustomerID() {
		return customerID;
	}
	
	public void setCustomerID(long customerID) {
		this.customerID = customerID;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public long getMobileNumber() {
		return mobileNumber;
	}
	
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	

	@Override
	public String toString() {
		return customerID + "," + customerName + "," + mobileNumber;
	}

	@Override
	public boolean equals(Object obj) {
		if(this==obj)
			return true;
		if (obj==null)
			return false; 
		if(this.getClass()!=obj.getClass())
			return false; 
		Customer cust = (Customer)obj;
		return this.customerID == cust.customerID && this.customerName.equals(cust.customerName); 
	}

	@Override
	public int hashCode() {

		return super.hashCode();
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("One Customer Object Garbage Collected:="+this.customerID);
	}

	
	private void writeObject(ObjectOutputStream out){
		try {
			out.defaultWriteObject();
			out.writeObject(this.mobileNumber);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void readObject(ObjectInputStream in){
		try {
			
			in.defaultReadObject();
			this.mobileNumber = (long) in.readObject();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
