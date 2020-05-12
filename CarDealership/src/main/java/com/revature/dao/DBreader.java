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

public class DBreader implements DAO {
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
			results.add(new User(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
		return results;
	}

	@Override
	public void insertCar(String make, String model, double payment, int years) throws SQLException {
		Connection conn = cf.getConnection();
		CallableStatement cs = conn.prepareCall("{MAKE_CAR(?,?,?,?)}");
		cs.setString(1, make);
		cs.setString(2, model);
		cs.setDouble(3, payment);
		cs.setInt(4, years);
		cs.execute();
	}

	@Override
	public List<Car> getCars() throws SQLException {
		Connection conn = cf.getConnection();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM CAR");
		
		return null;
	}

	@Override
	public void insertOffer(int user_id, int car_id) throws SQLException {
		Connection conn = cf.getConnection();
		CallableStatement cs = conn.prepareCall("{MAKE_USER(?,?,?)}");
		cs.setInt(1, user_id);
		cs.setInt(2, car_id);
		cs.execute();
	}

	@Override
	public List<Offer> getOffers() throws SQLException {
		List<Offer> results = new ArrayList<Offer>();
		Connection conn = cf.getConnection();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM OFFER");
		
		return null;
	}
  //ArrayList<User> userList = new ArrayList<User>();
  //ArrayList<Car> carList = new ArrayList<Car>();
  //ArrayList<Offer> offerList = new ArrayList<Offer>();
  
  
}
