package com.rentals.domains;

public class Fan extends Items{
	private String fanModel;
	private String fanMake;
	private String fanColor;

	public Fan(String itemName, double itemPrice, String fanModel, String fanMake, String fanColor) {
		super(itemName, itemPrice);
		this.fanModel = fanModel;
		this.fanMake = fanMake;
		this.fanColor = fanColor;
	}

	public String getFanModel() {
		return fanModel;
	}

	public void setFanModel(String fanModel) {
		this.fanModel = fanModel;
	}

	public String getFanMake() {
		return fanMake;
	}

	public void setFanMake(String fanMake) {
		this.fanMake = fanMake;
	}

	public String getFanColor() {
		return fanColor;
	}

	public void setFanColor(String fanColor) {
		this.fanColor = fanColor;
	}

	
	@Override
	public String toString() {
		return "Fan [fanModel=" + fanModel + ", fanMake=" + fanMake + ", fanColor=" + fanColor + "]";
	}
	
	
}
