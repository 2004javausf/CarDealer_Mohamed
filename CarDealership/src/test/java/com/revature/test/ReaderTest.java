package com.revature.test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.revature.beans.Car;
import com.revature.beans.Offer;
import com.revature.beans.User;
import com.revature.dao.DBReader;

class ReaderTest {

	@Test
	void testgetUsers() {
		DBReader dao = new DBReader();
		try {
			List<User> users = dao.getUsers();
			System.out.println(users);
			assertTrue(users !=  null);
		}
		catch(Exception e) {
			fail("SQL Exception");
		}
	}
	@Test
	void testgetCars() {
		DBReader dao = new DBReader();
		try {
			List<Car> cars = dao.getCars();
			System.out.println(cars);
			assertTrue(cars !=  null);
		}
		catch(Exception e) {
			fail("SQL Exception");
		}
	}
	@Test
	void testgetOffers() {
		DBReader dao = new DBReader();
		try {
			List<Offer> offers = dao.getOffers();
			System.out.println(offers);
			assertTrue(offers !=  null);
		}
		catch(Exception e) {
			fail("SQL Exception");
		}
	}
}
