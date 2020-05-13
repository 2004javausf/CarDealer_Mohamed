package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Car;
import com.revature.beans.Offer;
import com.revature.beans.User;

public class DBReader implements DAO {
	public static ConnFactory cf = ConnFactory.getInstance();
	
	@Override
	public void insertUser(String username, String password, int isAdmin) throws SQLException {
		Connection conn = cf.getConnection();
		CallableStatement cs = conn.prepareCall("{MAKE_USER(?,?,?)}");
		cs.setString(1, username);
		cs.setString(2, password);
		cs.setInt(3, isAdmin);
		cs.execute();	
	}

	@Override
	public List<User> getUsers() throws SQLException {
		List<User> results = new ArrayList<User>();
		Connection conn = cf.getConnection();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM USR");
		
		while(rs.next())
			results.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
		return results;
	}

	@Override
	public void insertCar(String make, String model, double payment,
			int years, int isOwned) throws SQLException {
		Connection conn = cf.getConnection();
		CallableStatement cs = conn.prepareCall("{MAKE_CAR(?,?,?,?,?)}");
		cs.setString(1, make);
		cs.setString(2, model);
		cs.setDouble(3, payment);
		cs.setInt(4, years);
		cs.setInt(4, isOwned);
		cs.execute();
	}

	@Override
	public List<Car> getCars() throws SQLException {
		List<Car> results = new ArrayList<Car>();
		Connection conn = cf.getConnection();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM CAR");
		
		while(rs.next())
			results.add(
					new Car(rs.getInt(1), rs.getString(2), rs.getString(3),
							rs.getDouble(4), rs.getInt(5), rs.getInt(6))
					);
		return results;
	}

	@Override
	public void insertOffer(int userId, int carId, int accepted) throws SQLException {
		Connection conn = cf.getConnection();
		CallableStatement cs = conn.prepareCall("{MAKE_OFFER(?,?,?)}");
		cs.setInt(1, userId);
		cs.setInt(2, carId);
		cs.setInt(3, accepted);
		cs.execute();
	}

	@Override
	public List<Offer> getOffers() throws SQLException {
		List<Offer> results = new ArrayList<Offer>();
		Connection conn = cf.getConnection();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM OFFER");
		
		while(rs.next())
			results.add(
					new Offer(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4))
					);
		return results;
	}

	@Override
	public void removeCar(int id) throws SQLException {
		Connection conn = cf.getConnection();
		CallableStatement cs =
				conn.prepareCall("{DELETE FROM CAR WHERE car_id = ?}");
		cs.setInt(1, id);
		cs.execute();
	}

	@Override
	public void removeOffer(int id) throws SQLException {
		Connection conn = cf.getConnection();
		CallableStatement cs =
				conn.prepareCall("{DELETE FROM OFFER WHERE offer_id = ?}");
		cs.setInt(1, id);
		cs.execute();
	}
}
