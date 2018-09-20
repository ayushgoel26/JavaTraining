package com.training.domains;

public class InsuranceAgent {
	
	public static void findPremium(Insurance insurance){
		System.out.println(insurance.calculatePremium());
	}
	
	// 
	public static void main(String[] args) {
		VehicleInsurance pulsarBike = new VehicleInsurance(393939, "Ramesh", "bike", 2014); 
		// passing vehicleInsurance instead of insurance because it is a subclass and it is valid 
		findPremium(pulsarBike);
		// super class type = sub class type at assignment
		Insurance marutiCar = new VehicleInsurance(494929, "Suresh", "car", 2015);
		findPremium(marutiCar);
		
		Insurance SureshBoy = new LifeInsurance(485751, "suresh", 48);
		findPremium(SureshBoy);
		
		
		Insurance RameshBoy = new LifeInsurance(4857451, "suresh", 14);
		findPremium(RameshBoy);
	}

}
