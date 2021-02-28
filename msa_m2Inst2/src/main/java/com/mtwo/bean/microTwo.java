package com.mtwo.bean;

public class microTwo {

	private int maximum;
	
	private int minimum;
	
	private static final String proName = "microTwo";

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
	
	public microTwo(int max,int min) {
		this.maximum=max;
		this.minimum=min;
	}
	
}
