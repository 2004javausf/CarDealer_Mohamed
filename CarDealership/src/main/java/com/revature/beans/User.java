package com.revature.beans;

import java.io.Serializable;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7729831625169647910L;
	String username, password;
	boolean isAdmin;
	int id;

	public User(String username, String password, int isAdmin, int id) {
		super();
		this.username = username;
		this.password = password;
		this.isAdmin = (isAdmin == 1);
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public boolean getStatus() {
		return isAdmin;	//true if admin
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", id=" + id + "]";
	}
	
}
