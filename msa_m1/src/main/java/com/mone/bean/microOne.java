package com.mone.bean;

public class microOne {

	private int maximum;
	
	private int minimum;
	
	private static final String proName = "microOne";

	public int getMaximum() {
		return maximum;
	}

	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}

	public int getMinimum() {
		return minimum;
	}

	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
	
	public String getProName() {
		return proName;
	}
	
	public microOne(int max,int min) {
		this.maximum=max;
		this.minimum=min;
	}
	
}
