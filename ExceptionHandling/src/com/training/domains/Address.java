package com.training.domains;

public class Address {
	private String addressLine1;
	private String addressLine2;
	private String city;
	private long pincode;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(String addressLine1, String addressLine2, String city, long pincode) {
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		
		if(pincode<0){
			try {
				throw new Exception("Pincode should be a positive number"); 
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}else{
			this.pincode = pincode;
		}
		
	}
	
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long getPincode() {
		return pincode;
	}
	public void setPincode(long pincode) throws Exception {
		if(pincode<0){
			throw new Exception("Pincode should be a positive number"); 
		}else{
			this.pincode = pincode;
		}
	}
	
	
}
