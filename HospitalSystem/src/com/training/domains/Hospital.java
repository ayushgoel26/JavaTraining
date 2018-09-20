package com.training.domains;

import java.util.*;

public class Hospital {
	private String hospName;
	
	HashSet<Doctor> doctorSet = new HashSet<>();
	HashSet<Patient> patientSet = new HashSet<>();

	HashMap<Doctor, HashSet<Patient>> ApptMap = new HashMap<>();
	HashMap<String, HashSet<Doctor>> SpecMap = new HashMap<>();
	
	public Hospital(String hospName) {
		this.hospName = hospName;
	}

	public Hospital(String hospName, HashSet<Doctor> doctorSet, HashSet<Patient> patientSet,
			HashMap<Doctor, HashSet<Patient>> apptMap, HashMap<String, HashSet<Doctor>> specMap) {
		this.hospName = hospName;
		this.doctorSet = doctorSet;
		this.patientSet = patientSet;
		ApptMap = apptMap;
		SpecMap = specMap;
	}

	public String getHospName() {
		return hospName;
	}

	public void setHospName(String hospName) {
		this.hospName = hospName;
	}

	public HashSet<Doctor> getDoctorSet() {
		return doctorSet;
	}

	public HashSet<Patient> getPatientSet() {
		return patientSet;
	}

	public HashMap<Doctor, HashSet<Patient>> getApptMap() {
		return ApptMap;
	}

	public HashMap<String, HashSet<Doctor>> getSpecMap() {
		return SpecMap;
	}

	public void setSpecMap(HashMap<String, HashSet<Doctor>> specMap) {
		SpecMap = specMap;
	}
	
	public void addDoctor(Doctor doctor){
		doctorSet.add(doctor);
		setSpecialisation(doctor,doctor.getDocSpec());
	}
	
	//public void addPatient(String patName, int patAge) {
	//	Patient a1 = new Patient(patName, patAge);
	//	patientSet.add(a1);
	//	System.out.println(patientSet.toString());
	//}
	
	public void addPatient(Patient patient) {
		patientSet.add(patient);
	}
	
	public void setSpecialisation(Doctor doctor, String specialisation){
		if(this.SpecMap.containsKey(specialisation)){
			HashSet<Doctor> doctors = this.SpecMap.get(specialisation);
			doctors.add(doctor);
			this.SpecMap.put(specialisation, doctors); 
		}
		else{
			HashSet<Doctor> doctors=new HashSet<>();
			doctors.add(doctor);
			this.SpecMap.put(specialisation, doctors); 
		}
	}
	
	public String fixAppt (Doctor doctor, Patient patient, String apptDay, String apptTime){
		patient.setApptTime(apptTime);
		patient.setApptDay(apptDay);
		if(this.doctorSet.contains(doctor)){
			if(this.ApptMap.containsKey(doctor)){
				HashSet<Patient> patients = this.ApptMap.get(doctor);
				boolean addPatient = patients.add(patient);
				Object obj = this.ApptMap.put(doctor, patients);
				if (addPatient && obj != null ){
					return "Appointment Added for " + doctor.getDocName();
				}
				else {
					return "Appointment could not be fixed.";
				}
			} else {
				HashSet<Patient> patients = new HashSet<>();
				boolean addPatient = patients.add(patient);
				Object obj = this.ApptMap.put(doctor, patients);
				if (addPatient && obj == null ){
					return "Appointment Added for " + doctor.getDocName();
				}
				else {
					return "Appointment could not be fixed.";
				}
			}
		}
		else{
			System.out.println("Doctor does not exist");
			return "Doctor does not exist";
		}
	}
	
	
	public String cancelAppt (Doctor doctor, Patient patient){
		if(this.doctorSet.contains(doctor)){
			if(this.ApptMap.containsKey(doctor)){
				HashSet<Patient> patients = this.ApptMap.get(doctor);
				boolean cancelled = patients.remove(patient);
				if (cancelled){
					return "Appointment cancelled for " + patient.getPatientName();
				}
				else {
					return "Appointment could not be cancelled. Try Again!";
				}
			} else {
				HashSet<Patient> patients = new HashSet<>();
				boolean cancelled = patients.remove(patient);
				if (cancelled){
					return "Appointment cancelled for " + patient.getPatientName();
				}
				else {
					return "Appointment could not be cancelled. Try Again!";
				}
			}
		}
		else{
			return "Doctor does not exist";
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
