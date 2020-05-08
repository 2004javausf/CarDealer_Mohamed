package com.revature.beans;

import java.io.Serializable;

//Employee and Customer will both extend this class
public abstract class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7729831625169647910L;
	String username, password;
	int id;
	
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
	
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", id=" + id + "]";
	}
	
}
