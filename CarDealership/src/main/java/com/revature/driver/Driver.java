package com.revature.driver;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.beans.User;
import com.revature.util.Dealer;

public class Driver {
	static Menu main, login = new Menu("Login");
	static Scanner scan = new Scanner(System.in);
	static User user;
	static Dealer dealership;
	static String username, password;
	static {
		try {
			dealership = new Dealer();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	static void mainChoice(int choice) throws SQLException {

		System.out.println("\n\n");
		switch(choice) {
		case 1:
			loginChoice();
			break;
		case 2:
			registerChoice();
			break;
		case 3:
			System.exit(0);
			break;
		default:
			System.out.println("incorrect option");
			main.display();
			choice = Integer.parseInt(scan.nextLine());
			mainChoice(choice);
		}
	}
	
	static void loginChoice() {
		do {
			login.display();
			System.out.println("Enter username: ");
			username = scan.nextLine();
			System.out.println("Enter password: ");
			password = scan.nextLine();
			
			user = dealership.login(username, password);
			if(user == null)
				System.out.println("user not found");
		}while(user == null);
	}
	static void registerChoice() throws SQLException {
		do {
			login.display();
			System.out.println("Enter a new username");
			username = scan.nextLine();
			System.out.println("Enter a new password");
			password = scan.nextLine();
			
			user = dealership.register(username, password);
			if(user == null)
				System.out.println("user already exists");
		}while(user == null);
	}
	public static void main(String[] args) {
		main = new Menu("Welcome to the Dealership",
				"Login", "Register", "Close");
		main.display();
		int choice = Integer.parseInt(scan.nextLine());
		
	}	
}
