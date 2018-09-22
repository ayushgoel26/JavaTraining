package com.rentals.domains;

import java.io.Serializable;

public class Customer implements Serializable{
	private String customerName;
	private long customerContactNo;
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String customerName) {
		this(customerName, 0);
	} 
	
	public Customer(String customerName, long customerContactNo) {
		super();
		this.customerName = customerName;
		this.customerContactNo = customerContactNo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getCustomerContactNo() {
		return customerContactNo;
	}

	public void setCustomerContactNo(long customerContactNo) {
		this.customerContactNo = customerContactNo;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (customerContactNo ^ (customerContactNo >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (customerContactNo != other.customerContactNo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return customerName + "*" + customerContactNo;
	}
	
}
