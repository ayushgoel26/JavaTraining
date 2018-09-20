package com.hospital;

public class Doctor {
	private String doctorName; 
	private String doctorGender; 
	private String doctorQualification; 
	private String doctorID; 
	private String doctorSpecialisation; 
	private int doctorAge;
	private String department;
	private long phoneNumber;
	private String location; 
	
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDoctorGender() {
		return doctorGender;
	}

	public void setDoctorGender(String doctorGender) {
		this.doctorGender = doctorGender;
	}

	public String getDoctorQualification() {
		return doctorQualification;
	}

	public void setDoctorQualification(String doctorQualification) {
		this.doctorQualification = doctorQualification;
	}

	public String getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(String doctorID) {
		this.doctorID = doctorID;
	}

	public String getDoctorSpecialisation() {
		return doctorSpecialisation;
	}

	public void setDoctorSpecialisation(String doctorSpecialisation) {
		this.doctorSpecialisation = doctorSpecialisation;
	}

	public int getDoctorAge() {
		return doctorAge;
	}

	public void setDoctorAge(int doctorAge) {
		this.doctorAge = doctorAge;
	} 
	
	public String prescribeMed(){
		return this.doctorName + " has prescribed medicines";
	}
	
	public String prescribeTest(){
		return this.doctorName + " has prescribed tests.";
	}
	
	public String analyseReport(){
		return this.doctorName + " has analysed reports";
	}
	
	public String checkPatient(){
		return this.doctorName + " has checked the patient";
	}
	
}
