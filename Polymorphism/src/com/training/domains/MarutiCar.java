package com.training.domains;

import com.training.ifaces.Automobile;

public class MarutiCar implements Automobile {

	@Override
	public String getModel() {
		return "Swift-Dzire";
	}

	@Override
	public String getColor() {
		return "Silky Silver";
	}

	@Override
	public double getPrice() {
		return 700000.00;
	}

}
