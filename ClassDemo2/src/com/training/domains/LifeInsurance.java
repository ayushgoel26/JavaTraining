package com.training.domains;

public class LifeInsurance extends Insurance {
	
	private int age; 
	
	public LifeInsurance(long policyNumber, String policyHolderName, int age) {
		super(policyNumber, policyHolderName);
		this.age = age;
	}

	
	@Override
	public double calculatePremium() {
		double premium = 0.0;
		
		if(this.age <= 20){ 
			premium = 200; 
		}
		else if(this.age<=40){
			premium = 350;
		}
		else if(this.age<=55){
			premium = 500; 
		}
		else{
			premium = 700; 
		}
		return premium; 
	}

}
