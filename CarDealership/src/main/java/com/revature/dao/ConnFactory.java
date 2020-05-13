package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnFactory {
	private static ConnFactory cf =new ConnFactory();
	
	private ConnFactory() {}
	
	public static synchronized ConnFactory getInstance() {
		if(cf == null)
			cf = new ConnFactory();

		return cf;
	}

	public Connection getConnection() {
		
		String url = "jdbc:oracle:thin:@dealershipdb.cvlmjjkb5tsy.us-east-2.rds.amazonaws.com:1521:ORCL";
		String user = "msamatar";
		String password = "password";
		Connection conn = null;
		try {
			conn=DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
}