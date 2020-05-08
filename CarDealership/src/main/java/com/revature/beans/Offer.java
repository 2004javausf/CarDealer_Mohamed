package com.revature.beans;

public class Offer {
	private int userID, carId, offerId;

	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public int getOfferId() {
		return offerId;
	}
	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}
	public Offer(int offerId) {
		super();
		this.offerId = offerId;
	}
	
	@Override
	public String toString() {
		return "Offer [userID=" + userID + ", carId=" + carId + ", offerId=" + offerId + "]";
	}
}
