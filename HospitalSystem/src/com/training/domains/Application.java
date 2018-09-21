package com.training.domains;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		Hospital sakra = new Hospital("Sakra");

		Doctor steve = new Doctor("Steve", "ENT", 45);
		Doctor roger = new Doctor("Roger", "Cardiology", 54);
		Doctor stephen = new Doctor("Stephen", "ENT", 56);
		sakra.addDoctor(steve);
		sakra.addDoctor(roger);
		sakra.addDoctor(stephen);

		Patient ayush = new Patient("Ayush", 23);
		Patient rahul = new Patient("Rahul", 19);
		Patient rohan = new Patient("Rohan", 13);
		Patient ankit = new Patient("Ankit", 29);
		sakra.addPatient(ayush);
		sakra.addPatient(rahul);
		sakra.addPatient(rohan);
		sakra.addPatient(ankit);

		System.out.println(sakra.fixAppt(roger, ayush, "Monday", "12:00"));
		System.out.println(sakra.fixAppt(stephen, rahul, "Wednesday", "12:00"));
		System.out.println(sakra.fixAppt(stephen, rohan, "Thursday", "12:00"));
		System.out.println(sakra.fixAppt(steve, ankit, "Thursday", "12:00"));

		String selection;
		Scanner sc = new Scanner(System.in);
		String sel = "n";
		do {
			System.out.print(
					"Enter 1 to search for Doctor by specialisation \nEnter 2 to check doctor's appointment \nEnter 3 to cancel an appointment\n");
			selection = sc.nextLine();
			String docName;
			switch (selection) {

			case "1":
				System.out.print("Enter the Specialisation: \n");
				String spec = sc.nextLine();
				if (sakra.specMap.containsKey(spec)) {
					System.out.println(sakra.specMap.get(spec));
				} else {
					System.out.println("No Doctors!");
				}
				break;
			case "2":
				System.out.print("Enter the DoctorName: \n");
				docName = sc.nextLine();
				Doctor doct = null;
				for (Doctor obj : sakra.doctorSet) {
					if (obj.getDocName().equals(docName))
						doct = obj;
				}
				if (sakra.apptMap.containsKey(doct)) {
					System.out.println(sakra.apptMap.get(doct));
				} else {
					System.out.println("No Appointments");
				}
				break;
			case "3":
				System.out.println("Enter Patient Name");
				String patName = sc.nextLine();
				System.out.println("Enter Doctor Name");
				String doctName = sc.nextLine();
				Doctor doct2 = null;
				Patient pat2 = null;
				for (Doctor obj : sakra.doctorSet) {
					if (obj.getDocName().equals(doctName))
						doct2 = obj;
				}
				for (Patient obj : sakra.patientSet) {
					if (obj.getPatientName().equals(patName))
						pat2 = obj;
				}

				System.out.println(sakra.cancelAppt(doct2, pat2));
				break;
			default:
				System.out.println("Invalid Entry!");
				break;
			}
			System.out.println("Do you wish to continue? (Y/N)");
			sel = sc.nextLine();
		} while (sel.equals("Y"));
		System.out.println("Thank You!");
		sc.close();
	}

}
