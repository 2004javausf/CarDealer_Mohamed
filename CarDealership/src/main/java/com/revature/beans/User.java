package com.revature.beans;

public class User {
	String username, password;
	boolean isAdmin;
	int id;

	public User(int id, String username, String password, int isAdmin) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.isAdmin = (isAdmin == 1);	//1 in DB if user is an admin
	}
	
	public User() {}

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
	
	public boolean isAdmin() {
		return isAdmin;	//true if admin
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", isAdmin=" + isAdmin + ", id=" + id + "]";
	}
	
}
