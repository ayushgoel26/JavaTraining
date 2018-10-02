package com.contact.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.contact.domains.Contact;
import com.contact.domains.ContactNumber;
import com.contact.util.DbConnection;

public class contactDaoImpl implements contactDAO {

	private Connection con;
	
	public contactDaoImpl() {
		super();
		con = DbConnection.getOracleConnection();
	}

	@Override
	public int createNewContact(Contact contact, ContactNumber contactNo) throws SQLException {
		
		String sql = "Insert into contactDetails_ag values(contact_ag_seq.nextval,?,?,?)";
		
		PreparedStatement pstmt = null;
				
		int rowAdded = 0;
				
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, contact.getContactName());
		pstmt.setString(2, contact.getContactCategory());
		pstmt.setString(3, contact.getContactEmail());

		rowAdded = pstmt.executeUpdate();
		
		pstmt.close();
		
		boolean added = addContactToTable(contact, contactNo);
		
		if (!added && rowAdded>0){
			rowAdded = -1;
		}
		
		return rowAdded;
	}

	private boolean addContactToTable(Contact contact, ContactNumber contactNo) throws SQLException{
		
		String sql1 = "Insert into contactNumbers_ag values(contact_ag_seq.currval,?,?)";
		
		PreparedStatement pstmt1 = null;
				
		boolean contactAdded = false;
	
		pstmt1 = con.prepareStatement(sql1);
		pstmt1.setString(1, contactNo.getContactNo());
		pstmt1.setString(2, contactNo.getContactNumberType());

		int contacts = pstmt1.executeUpdate();
		
		pstmt1.close();
		
		if(contacts>0){
			contactAdded = true;
		}
		
		return contactAdded;
	
	}
	
	@Override
	public int addToExistingContact(int contactId, ContactNumber contactNo) throws SQLException{
		
		
		String sql1 = "Insert into contactNumbers_ag values(?,?,?)";
		
		PreparedStatement pstmt = null;
				
		int rowAdded = 0;
	
		pstmt = con.prepareStatement(sql1);
		pstmt.setInt(1, contactId);
		pstmt.setString(2, contactNo.getContactNo());
		pstmt.setString(3, contactNo.getContactNumberType());

		rowAdded = pstmt.executeUpdate();
		
		pstmt.close();
		
		return rowAdded;
	}
	
	
	

	@Override
	public int deleteContact(int contactId) throws SQLException {
		String sql1 = "delete from contactNumbers_ag where contactId = ?";
		
		PreparedStatement pstmt = null;
				
		int rowAdded = 0;
	
		pstmt = con.prepareStatement(sql1);
		pstmt.setInt(1, contactId);

		rowAdded = pstmt.executeUpdate();
		
		pstmt.close();
		
		
	String sql2 = "delete from contactDetails_ag where contactId = ?";
		
		PreparedStatement pstmt1 = null;
				
		int rowsDeleted = 0;
	
		pstmt1 = con.prepareStatement(sql2);
		pstmt1.setInt(1, contactId);

		rowsDeleted = pstmt1.executeUpdate();
		
		pstmt1.close();
		
		
		return rowsDeleted;
	}

	@Override
	public int editContact(int contactId, String contactProperty, String newValue) throws SQLException {
		
		String sql = "update contactdetails_ag set " + contactProperty + "= ? where contactId = ? ";
		
		
		PreparedStatement pstmt = null;

		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,newValue);
		pstmt.setInt(2,contactId);
		int rowUpdated = pstmt.executeUpdate();
		
		pstmt.close();

		return rowUpdated;		
	}

	@Override
	public Contact findContactById(int contactId) throws SQLException {
				
		String sql = "select * from contactdetails_ag natural join contactnumbers_ag where contactId = ? order by contactName";
		PreparedStatement pstmt = null;

		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1,contactId);
		ResultSet rs = pstmt.executeQuery();
		Contact contact = executeQuery(rs);
		pstmt.close();

		return contact;
	}

	public Contact executeQuery(ResultSet rs) throws SQLException{
		List<Contact> contactList = new ArrayList<>();
		Contact contactFound = null;
		boolean exists = false;

		while (rs.next()) {

			String contactName = rs.getString("contactName");
			String contactCategory = rs.getString("contactCategory");
			String contactEmail = rs.getString("contactEmail");
			String contactNumber = rs.getString("contactNumber");
			String contactType = rs.getString("contactType");
			
			for(Contact contact : contactList){
				if (contact.getContactEmail().equals(contactEmail)){
					contact.addContactToList(new ContactNumber(contactNumber,contactType));
					exists = true;
				}
			}
			
			if(!exists){
				contactFound = new Contact(contactName, contactCategory, contactEmail);
				ContactNumber numberFound = new ContactNumber(contactNumber,contactType);
				contactFound.addContactToList(numberFound);
				contactList.add(contactFound);
			}
		}
		
		return contactFound;
	}
	
	@Override
	public List<Contact> findContactByCategory(String contactCategory) throws SQLException {
		
		
		String sql = "select * from contactdetails_ag natural join contactnumbers_ag where contactCategory = ? order by contactName";
		PreparedStatement pstmt = null;

		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,contactCategory);
		ResultSet rs = pstmt.executeQuery();
		List<Contact> contactList = new ArrayList<>();
		Contact contactFound = null;
		boolean exists = false;

		while (rs.next()) {

			String contactName = rs.getString("contactName");
			String contactEmail = rs.getString("contactEmail");
			String contactNumber = rs.getString("contactNumber");
			String contactType = rs.getString("contactType");
			
			for(Contact contact : contactList){
				if (contact.getContactEmail().equals(contactEmail)){
					contact.addContactToList(new ContactNumber(contactType,contactNumber));
					exists = true;
				}
			}
			
			if(!exists){
				contactFound = new Contact(contactName, contactCategory, contactEmail);
				ContactNumber numberFound = new ContactNumber(contactType,contactNumber);
				contactFound.addContactToList(numberFound);
				contactList.add(contactFound);
			}
		}
		pstmt.close();

		return contactList;
	}

	@Override
	public  List<Contact> findAllContacts() throws SQLException {
		
		String sql = "select * from contactdetails_ag natural join contactnumbers_ag order by contactName";
		PreparedStatement pstmt = null;

		pstmt = con.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		List<Contact> contactList = new ArrayList<>();
		Contact contactFound = null;
		boolean exists = false;

		while (rs.next()) {
			exists = false;
			String contactName = rs.getString("contactName");
			String contactEmail = rs.getString("contactEmail");
			String contactNumber = rs.getString("contactNumber");
			String contactType = rs.getString("contactType");
			String contactCategory = rs.getString("contactCategory");

			for(Contact contact : contactList){
				if (contact.getContactEmail().equals(contactEmail)){
					contact.addContactToList(new ContactNumber(contactType,contactNumber));
					exists = true;
				}
			}
			
			if(!exists){
				contactFound = new Contact(contactName, contactCategory, contactEmail);
				ContactNumber numberFound = new ContactNumber(contactType,contactNumber);
				contactFound.addContactToList(numberFound);
				contactList.add(contactFound);
			}
		}
		pstmt.close();

		return contactList;	
	}

	@Override
	public List<Contact> findContactByName(String contactName) throws SQLException {
		String sql = "select * from contactdetails_ag natural join contactnumbers_ag where contactName =  ? order by contactName";
		PreparedStatement pstmt = null;

		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, contactName);
		ResultSet rs = pstmt.executeQuery();
		List<Contact> contactList = new ArrayList<>();
		Contact contactFound = null;
		boolean exists = false;

		while (rs.next()) {
			exists = false;
			String contactEmail = rs.getString("contactEmail");
			String contactNumber = rs.getString("contactNumber");
			String contactType = rs.getString("contactType");
			String contactCategory = rs.getString("contactCategory");

			for(Contact contact : contactList){
				if (contact.getContactEmail().equals(contactEmail)){
					contact.addContactToList(new ContactNumber(contactType,contactNumber));
					exists = true;
				}
			}
			
			if(!exists){
				contactFound = new Contact(contactName, contactCategory, contactEmail);
				ContactNumber numberFound = new ContactNumber(contactType,contactNumber);
				contactFound.addContactToList(numberFound);
				contactList.add(contactFound);
			}
		}
		pstmt.close();

		return contactList;	
	}

}
