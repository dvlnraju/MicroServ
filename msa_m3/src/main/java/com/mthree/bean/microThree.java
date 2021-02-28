package com.mthree.bean;

public class microThree {

	private int maximum;
	
	private int minimum;
	
	private static final String proName = "microThree JPA";

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
	
	public microThree(int max,int min) {
		this.maximum=max;
		this.minimum=min;
	}
	
}
