package com.training.domains;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		Hospital sakra = new Hospital("Sakra");

		Doctor steve = new Doctor("Steve", "ENT", 45);
		sakra.addDoctor(steve);
		
		Doctor roger = new Doctor("Roger", "Cardiology", 54);
		sakra.addDoctor(roger);
		
		Doctor stephen = new Doctor("Stephen","ENT", 56);
		sakra.addDoctor(roger);
		
		Patient ayush = new Patient("Ayush",23);
		System.out.println(sakra.fixAppt(roger, ayush, "12:00"));
		
		String docName;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the DoctorName: \n");
		docName = sc.nextLine();
		
		if(sakra.ApptMap.containsKey(docName)){
			System.out.println(sakra.ApptMap.get(docName));
		}else{
			System.out.println("No Appointments");
		}
		sc.close();
	}

}
