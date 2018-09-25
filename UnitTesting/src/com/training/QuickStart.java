package com.training;

public class QuickStart {
	
	public static String getMessage(){
		return "Hello".toUpperCase();
	}
	
	public double calculateDiscount(double amount) throws RuntimeException{
		double discount;
		if (amount > 0) {
		if(amount < 5000){
			discount = 0.10;
		}
		else {
			discount = 0.15;
		}}
		else{
			 RuntimeException rtEx= new RuntimeException();
			 throw rtEx; 
		}
		return discount;
	}
	
	


}



