package com.training.domains;
import java.util.*;

public class BoundedCollection {
	
	public static void display(List<? extends Insurance> insurance){
		System.out.println(insurance.get(0).calculatePremium());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LifeInsurance rakesh = new LifeInsurance(451581,"Rakesh",14);
		
		List<LifeInsurance> life = new ArrayList<>();
		life.add(rakesh);
		display(life);
		
		VehicleInsurance marutiCar = new VehicleInsurance(566454513, "Suresh", "car",2014);
		List<VehicleInsurance> car = new ArrayList<>();
		car.add(marutiCar);
		display(car);
		
	}

}
