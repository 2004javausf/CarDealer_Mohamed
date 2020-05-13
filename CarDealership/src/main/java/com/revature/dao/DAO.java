package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Car;
import com.revature.beans.Offer;
import com.revature.beans.User;

public interface DAO {
	public void insertUser(String username, String password, int isAdmin) throws SQLException;
	public List<User> getUsers() throws SQLException;
	public void insertCar(String make, String model, double payment,
			int years, int isOwned) throws SQLException;
	public void removeCar(int id) throws SQLException;
	public List<Car> getCars() throws SQLException;
	public void insertOffer(int userId, int carId, int accepted) throws SQLException;
	public void removeOffer(int id) throws SQLException;
	public List<Offer> getOffers() throws SQLException;
}
