package com.contact.application;

import java.sql.SQLException;

import com.contact.domains.Contact;
import com.contact.domains.ContactNumber;
import com.contact.entity.contactDAO;
import com.contact.entity.contactDaoImpl;
import com.contact.util.DbConnection;

public class Application {
	public static void main(String[] args) {
		
		System.out.println("Connecting to Database");
		System.out.println(DbConnection.getOracleConnection());
		
		contactDAO contactManager = new contactDaoImpl();
		
		int key =3;
		
		/*
		 * 1 - Add New Contact 
		 * 2 - find by category 
		 * 3 - find all 
		 * 4 - find by id 
		 * 5 - delete 
		 * 6 - edit  
		 * 7 - add to existing 
		 * 8 - find by name 
		 */
		
		
		try {
			switch(key){
				case 1:
					Contact contact1 = new Contact("Hamaad", "Friend", "tanu@gmail.com");
					System.out.println(contactManager.createNewContact(contact1, new ContactNumber("Home", "546546546")));
					break;
				case 2: 
					System.out.println(contactManager.findContactByCategory("Relative"));
					break;
				case 3:
					System.out.println(contactManager.findAllContacts());
					break;
				case 4: 
					System.out.println(contactManager.findContactById(5));
					break;
				case 5:
					System.out.println(contactManager.deleteContact(4));
					break;
				case 6: 
					System.out.println(contactManager.editContact(2, "contactCategory", "Relative"));
					break;
				case 7:
					System.out.println(contactManager.addToExistingContact(5, new ContactNumber("7687576576")));
					break;
				case 8: 
					System.out.println(contactManager.findContactByName("Ayush"));
					break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
