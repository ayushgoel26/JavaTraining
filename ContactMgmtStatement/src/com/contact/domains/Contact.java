package com.contact.domains;

import java.util.ArrayList;
import java.util.List;

public class Contact {
	private String contactName;
	private String contactCategory;
	private String contactEmail;
	private List<ContactNumber> contactNumbers;
	private int ContactID;
	
	
	public Contact(String contactName, String contactCategory, List<ContactNumber> contactNumbers) {
		this(contactName,contactCategory,"NA",contactNumbers);
	}

	public int getContactID() {
		return ContactID;
	}

	public void setContactID(int contactID) {
		ContactID = contactID;
	}

	public Contact(String contactName, String contactCategory, String contactEmail, List<ContactNumber> contactNumbers) {
		super();
		this.contactName = contactName;
		this.contactCategory = contactCategory;
		this.contactEmail = contactEmail;
		this.contactNumbers = contactNumbers;
		this.contactNumbers = new ArrayList<>();
	}



	@Override
	public String toString() {
		return "\nContact: Name - " + contactName + ", Category -" + contactCategory + ", Email -"
				+ contactEmail + ", Contact Numbers - \n" + contactNumbers ;
	}

	public Contact(String contactName, String contactCategory, String contactEmail) {
		super();
		this.contactName = contactName;
		this.contactCategory = contactCategory;
		this.contactEmail = contactEmail;
		this.contactNumbers = new ArrayList<>();

	}

	public Contact(String contactName, String contactCategory, String contactEmail, ContactNumber contactNumber) {
		super();
		this.contactName = contactName;
		this.contactCategory = contactCategory;
		this.contactEmail = contactEmail;
		this.contactNumbers = new ArrayList<>();
		contactNumbers.add(contactNumber);
	}
	
	public String getContactName() {
		return contactName;
	}
	
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	
	public String getContactCategory() {
		return contactCategory;
	}
	
	public void setContactCategory(String contactCategory) {
		this.contactCategory = contactCategory;
	}
	
	public String getContactEmail() {
		return contactEmail;
	}
	
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	
	public List<ContactNumber> getContactNumbers() {
		return contactNumbers;
	}
	
	public void setContactNumbers(List<ContactNumber> contactNumbers) {
		this.contactNumbers = contactNumbers;
	}
	
	public void addContactToList(ContactNumber contactNo){
		this.contactNumbers.add(contactNo); 
	}
	
	
}
