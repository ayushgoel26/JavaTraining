package com.training.domains;

import com.training.ifaces.Automobile;

public class BajajBike implements Automobile {

	@Override
	public String getModel() {
		return "Pulsar";
	}

	@Override
	public String getColor() {
		return "Blue";
	}

	@Override
	public double getPrice() {
		return 112500.00;
	}

}
