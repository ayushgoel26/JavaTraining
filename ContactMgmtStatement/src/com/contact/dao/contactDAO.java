package com.contact.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.contact.domains.*;

public interface contactDAO {

	public int createNewContact(Contact contact, ContactNumber contactNo) throws SQLException ;
	public int addToExistingContact(int contactId, ContactNumber contactNo) throws SQLException;

	public int deleteContact(int contactId) throws SQLException ;
	public int editContact(int contactId, String contactProperty, String newValue)throws SQLException;
	public Contact findContactById(int contactId) throws SQLException;
	public List<Contact> findContactByCategory(String contactCategory) throws SQLException;
	public List<Contact> findContactByName(String contactName) throws SQLException;
	public List<Contact> findAllContacts() throws SQLException;
	public Map<String, Integer> countContacts() throws SQLException;
	
}
