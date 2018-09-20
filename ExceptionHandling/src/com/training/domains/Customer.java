package com.training.domains;

public class Customer {
	private long CustomerID;
	private String customerName;
	private Address address;
	private long mobileNumber;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Customer(long customerID, String customerName, Address address, long mobileNumber) {
		CustomerID = customerID;
		this.customerName = customerName;
		this.address = address;
		this.mobileNumber = mobileNumber;
	}
	
	public long getCustomerID() {
		return CustomerID;
	}
	
	public void setCustomerID(long customerID) {
		CustomerID = customerID;
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
	public boolean equals(Object obj) {
		if(this==obj)
			return true;
		if (obj==null)
			return false; 
		if(this.getClass()!=obj.getClass())
			return false; 
		Customer cust = (Customer)obj;
		return this.CustomerID == cust.CustomerID && this.customerName.equals(cust.customerName); 
	}

	@Override
	public int hashCode() {

		return super.hashCode();
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("One Customer Object Garbage Collected:="+this.CustomerID);
	}
	
	
	
	
}
