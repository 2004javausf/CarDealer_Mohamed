package com.revature.beans;

public class Offer {
	private int offerId, userId, carId;
	boolean accepted;

	public Offer(int offerId, int userID, int carId, int accepted) {
		this.offerId = offerId;
		this.userId = userID;
		this.carId = carId;
		this.accepted = (accepted == 1);
	}
	public boolean isAccepted() {
		return accepted;
	}
	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}
	public int getUserID() {
		return userId;
	}
	public void setUserID(int userID) {
		this.userId = userID;
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
	@Override
	public String toString() {
		return "Offer [offerId=" + offerId + ", userId=" + userId + ", carId=" + carId + ", accepted=" + accepted + "]";
	}
	
	
}
