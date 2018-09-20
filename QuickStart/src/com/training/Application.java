package com.training;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BloodDonor guest = new BloodDonor(); 
		guest.setDonorName("Ayush Goel");
		guest.setDonorAge(22);
		guest.setDonorGender("Male");
		guest.setBloodGroup("B(+ve)");
		System.out.println(guest.getDonorAge());
		System.out.println(guest.getDonorName());		
		System.out.println(guest.getDonorGender());
		System.out.println(guest.getBloodGroup());
		
		BloodDonor guest1 = new BloodDonor("Ayush","AB(+ve)",23,"Male"); 
		System.out.println(guest1.getDonorAge());
		System.out.println(guest1.getDonorName());
		System.out.println(guest.getDonorGender());
		System.out.println(guest.getBloodGroup());
		
		
		System.out.println(guest.getDonorName() + " has " + guest.collectCertificate());
		System.out.println(guest1.getDonorName() + " has " + guest1.collectCertificate());

	}

}
