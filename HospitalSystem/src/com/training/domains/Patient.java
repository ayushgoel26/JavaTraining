package com.training.domains;

public class Patient {
	private String patientName;
	private String apptDay;
	private String apptTime;
	private int patientAge;
	
	//private String Appt;  ApptTime+ApptDay

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Patient(String patientName, int patientAge) {
		this.patientName = patientName;
		this.patientAge = patientAge;
		this.apptTime = null;
		this.apptDay = null;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getApptDay() {
		return apptDay;
	}

	public void setApptDay(String apptDay) {
		this.apptDay = apptDay;
	}

	public String getApptTime() {
		return apptTime;
	}

	public void setApptTime(String apptTime) {
		this.apptTime = apptTime;
	}

	public int getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}
	
	
	
	
	
	
	
}
