package com.revature.util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Car;
import com.revature.beans.Offer;
import com.revature.beans.User;
import com.revature.dao.DBReader;

public class Dealer {
	public static DBReader dao = new DBReader();
	public static List<User> userList;
	public static List<Car> carList;
	public static List<Offer> offerList;
	
	public Dealer() throws SQLException {
		updateLists();
	}
	public void updateLists() throws SQLException {
		userList = dao.getUsers();
		carList = dao.getCars();
		offerList = dao.getOffers();
	}
	
	//ID LOOKUP METHODS
	
	public User searchUser(int id) {
		for(User user : userList)
			if(user.getId() == id)
				return user;
		
		return null;
	}
	public Car searchCar(int id) {
		for(Car car : carList)
			if(car.getId() == id)
				return car;
		
		return null;
	}
	public Offer searchOffer(int id) {
		for(Offer offer : offerList)
			if(offer.getOfferId() == id)
				return offer;
		
		return null;
	}
	
	//VALIDATION METHODS
	
	public User login(String username, String password) {
		for(User user : userList)
			if(user.getUsername().equalsIgnoreCase(username)
			&& user.getPassword().equals(password))
				return user;
		return null;
	}
	public User register(String username, String password) throws SQLException {
		for(User user : userList)
			if(user.getUsername().equalsIgnoreCase(username))
				return null;
		
		dao.insertUser(username, password, 0);
		updateLists();
		return login(username, password);
	}
	
	//CUSTOMER METHODS
	
	public void makeOffer(int userId, int carId) throws SQLException {
		dao.insertOffer(userId, carId, 0);
		offerList = dao.getOffers();
	}
	public void viewCarsOwned(int userId) {
		List<Integer> carIdList = new ArrayList<Integer>();
		for(Offer offer : offerList)
			if(offer.getUserID() == userId)
				carIdList.add(offer.getCarId());
		
		for(int carId : carIdList)
			for(Car car : carList)
				if(car.getId() == carId)
					System.out.println(car);
	}
	public void viewPayments(int carId) {
		Car car = searchCar(carId);
		double payment = car.getPayment();
		int years = car.getYears();
		
		System.out.println("Your remaining payment for the car is: " +
							payment + " over " + years +
							" years, or about $" + payment / years / 12 +
							" a month.");
	}
	
	//EMPLOYEE METHODS
	public void addCar(String make, String model, double payment,
			int years, int accepted) throws SQLException {
		dao.insertCar(make, model, payment, years, accepted);
		userList = dao.getUsers();
	}
	public void removeCar(int carId) throws SQLException {
		carList.remove(searchCar(carId));
		dao.removeCar(carId);
	}
	public void evalOffer(int offerId, boolean eval) throws SQLException {
		Offer offer = searchOffer(offerId);
		if(offer != null)
			offer.setAccepted(eval);
		
		//car is now owned
		Car car = searchCar(offer.getCarId());
		if(car != null)
			car.setOwned(true);
		
		//remove rejected offer
		for(Offer o : offerList)
			if(o.getCarId() == offer.getCarId())
				dao.removeOffer(offerId);
		updateLists();
	}
	public void viewAllPayments() {
		for(Car car : carList)
			System.out.println("Payment on the " + car.getMake() + " " +
							car.getModel() + " is " + car.getPayment());
	}
	
}
