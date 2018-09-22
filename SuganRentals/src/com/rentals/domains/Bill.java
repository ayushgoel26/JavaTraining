package com.rentals.domains;

import java.io.Serializable;
import java.util.HashSet;

public class Bill implements Serializable{
	
	private long invoiceID;
	private Customer customer;
	private HashSet<Items> itemSet;
	
	//Calculated Variables
	private double totalAmount;

	public Bill(long invoiceID, HashSet<Items> itemSet) {
		super();
		this.invoiceID = invoiceID;
		this.itemSet = itemSet;
	}
	
	public Bill(long invoiceID, Customer customer) {
		super();
		this.invoiceID = invoiceID;
		this.customer = customer;
		this.itemSet = new HashSet<>();
	}



	public Bill(long invoiceID, Customer customer, HashSet<Items> itemSet) {
		super();
		this.invoiceID = invoiceID;
		this.customer = customer;
		this.itemSet = itemSet;
	}

	public long getInvoiceID() {
		return invoiceID;
	}

	public void setInvoiceID(long invoiceID) {
		this.invoiceID = invoiceID;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public HashSet<Items> getItemSet() {
		return itemSet;
	}

	public void setItemSet(HashSet<Items> itemSet) {
		this.itemSet = itemSet;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (invoiceID ^ (invoiceID >>> 32));
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
		Bill other = (Bill) obj;
		if (invoiceID != other.invoiceID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return invoiceID + ":=" + customer + ";" + itemSet + ";" + totalAmount;
	}
	
	public boolean addItem(Items item){
		boolean status = false;
		if(this.itemSet.add(item)){
			status = true;
		}
		return status;
	}
	
	public double findTotal(){
		
		 for(Items item : this.itemSet){
			 this.totalAmount = this.totalAmount + item.getPrice();
		 }
		 return this.totalAmount;
	}
}