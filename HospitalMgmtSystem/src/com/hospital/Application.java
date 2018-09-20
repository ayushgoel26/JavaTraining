package com.hospital;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Doctor doctor1 = new Doctor(); 
		
		doctor1.setDoctorName("Ayush");
		doctor1.setDoctorAge(26);
		doctor1.setDoctorGender("Male");
		doctor1.setDoctorQualification("M.D.");
		doctor1.setDoctorSpecialisation("Surgeon");
		doctor1.setDoctorID("DOC1");
		doctor1.setDepartment("Cardiology");
		doctor1.setLocation("Bangalore");
		doctor1.setPhoneNumber(12344);
		
		System.out.println("Doctor Name: " + doctor1.getDoctorName());
		System.out.println("ID: " + doctor1.getDoctorID());
		System.out.println("Age: " + doctor1.getDoctorAge()); 
		System.out.println("Gender: " + doctor1.getDoctorGender());
		System.out.println("Qualification: " + doctor1.getDoctorQualification());
		System.out.println("Department: " + doctor1.getDepartment());
		System.out.println("Specialisation: " + doctor1.getDoctorSpecialisation());
		System.out.println("Phone No: " + doctor1.getPhoneNumber());
		System.out.println("Location: " + doctor1.getLocation());
		
		System.out.println(doctor1.checkPatient());
		System.out.println(doctor1.prescribeTest());
		System.out.println(doctor1.analyseReport());
		System.out.println(doctor1.prescribeMed());
		
		
		Doctor doctor2 = new Doctor(); 
		doctor2.setDoctorName(args[0]+args[1]);
		String name=doctor2.getDoctorName();
		System.out.println(name.length());
		
	}
}
