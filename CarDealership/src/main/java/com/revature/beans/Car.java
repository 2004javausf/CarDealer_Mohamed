package com.revature.beans;

public class Car {
	String make, model;
	double payment;
	boolean isOwned;
	int years, id;	//years = number of years in car's payment plan
	
	public Car(int id, String make, String model, double payment, int years, int isOwned) {
		this.id = id;
		this.make = make;
		this.model = model;
		this.payment = payment;
		this.years = years;
		this.isOwned = (isOwned == 1);
	}
	public double getPayment() {
		return payment;
	}
	public void setPayment(double payment) {
		this.payment = payment;
	}
	public boolean isOwned() {
		return isOwned;
	}
	public void setOwned(boolean isOwned) {
		this.isOwned = isOwned;
	}
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
		return "Car [make=" + make + ", model=" + model + ", payment=" + payment + ", isOwned=" + isOwned + ", years="
				+ years + ", id=" + id + "]";
	}
}
