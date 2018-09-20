package com.training;

public class BloodDonor {
	
	
	// Instance Variable are defined below 
	/**
	 * Instance Variable have default value 
	 * 0 for integer
	 * null for string 
	 * false for boolean 
	 */
	private String donorName; 
	private String bloodGroup; 
	private int donorAge; 
	private String donorGender;
	
	public BloodDonor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BloodDonor(String donorName, String bloodGroup, int donorAge, String donorGender) {
		super();
		this.donorName = donorName;
		this.bloodGroup = bloodGroup;
		this.donorAge = donorAge;
		this.donorGender = donorGender;
	}
	
	public String getDonorName() {
		return donorName;
	}
	
	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}
	
	public String getBloodGroup() {
		return bloodGroup;
	}
	
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	
	public int getDonorAge() {
		return donorAge;
	}
	
	public void setDonorAge(int donorAge) {
		this.donorAge = donorAge;
	}
	
	public String getDonorGender() {
		return donorGender;
	}
	
	public void setDonorGender(String donorGender) {
		this.donorGender = donorGender;
	} 
	
	public String collectCertificate(){
		return "Donated Blood"; 
	}
	
	public String collectReport(){
		return "Report follows"; 
	}
	
}
