package com.revature.beans;

public class Car {
	String make, model;
	double payment;
	int years, id;	//years = number of years in car's payment plan
	
	public int getYears() {
		return years;
	}
	public void setYears(int years) {
		this.years = years;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Car [make=" + make + ", model=" + model + ", id=" + id + "]";
	}
}
