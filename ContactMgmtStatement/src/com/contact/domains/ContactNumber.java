package com.contact.domains;

public class ContactNumber {
	private String contactNumberType;
	private String contactNo;
	
	public ContactNumber(String contactNumberType, String contactNo) {
		super();
		this.contactNumberType = contactNumberType;
		this.contactNo = contactNo;
	}

	public ContactNumber(String contactNo) {
		this("NA",contactNo);

	}

	public String getContactNumberType() {
		return contactNumberType;
	}

	@Override
	public String toString() {
		return contactNumberType + " - " + contactNo ;
	}

	public void setContactNumberType(String contactNumberType) {
		this.contactNumberType = contactNumberType;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	
	
	
	
}
