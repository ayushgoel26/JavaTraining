package com.training.domains;

import com.training.ifaces.Automobile;

public class QuoteManager {
	/**
	 * 
	 * @param key represents the key for each vehicle 
	 * 		  1-Car; 2-Bike;
	 * @return the sub type of Automobile = a class 
	 */
	public Automobile getModel(int key){	
		switch (key) {
		case 1:
			return new MarutiCar();
		case 2: 
			return new BajajBike(); 
		default:
			return null; 
		}
	}

	public void printQuote(Automobile polyAuto){
		if (polyAuto != null){
		System.out.println(polyAuto.getModel());
		System.out.println(polyAuto.getPrice());
		System.out.println(polyAuto.getColor());
		}
		else {
			System.out.println("Choice should be 1 or 2 or 3. ");
		}
	}
}
