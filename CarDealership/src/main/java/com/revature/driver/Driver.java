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
			break;
		}
	}

	static void adminChoice(int choice) throws SQLException {
		switch(choice) {
		case 1:
			System.out.println("Enter the car's make: ");
			String make = scan.nextLine();
			System.out.println("Enter the car's model: ");
			String model = scan.nextLine();
			System.out.println("How much should it cost? ");
			double payment = Double.parseDouble(scan.nextLine());
			System.out.println("Over how many years? ");
			int years = Integer.parseInt(scan.nextLine());
			dealership.addCar(make, model, payment, years, 0);
			break;
		case 2:
			System.out.println("Which car to remove? Enter the id: ");
			int carId = Integer.parseInt(scan.nextLine());
			dealership.removeCar(carId);
			break;
		case 3:
			System.out.println("Which offer to evaluate? Enter the id: ");
			int offerId = Integer.parseInt(scan.nextLine());
			dealership.evalOffer(offerId, true);
			break;
		case 4:
			System.out.println("Showing all payments:");
			dealership.viewAllPayments();
			break;
		default:
			System.out.println("incorrect option");
			main.display();
			choice = Integer.parseInt(scan.nextLine());
			adminChoice(choice);
			break;
		}
	}
	
	static void userChoice(int choice) throws SQLException {
		int carId;
		switch(choice) {
		case 1:
			System.out.println("Enter the id of the car you want");
			carId = Integer.parseInt(scan.nextLine());
			dealership.makeOffer(user.getId(), carId);
			break;
		case 2:
			System.out.println("Showing all cars owned:");
			dealership.viewCarsOwned(user.getId());
			break;
		case 3:
			System.out.println("Input car id to view payment");
			carId = Integer.parseInt(scan.nextLine());
			dealership.viewPayments(carId);
			break;
		default:
			System.out.println("incorrect option");
			main.display();
			choice = Integer.parseInt(scan.nextLine());
			userChoice(choice);
			break;
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
		try {
			mainChoice(choice);
			
			if(user.isAdmin()) {
				main = new Menu("Welcome, Employee",
						"Add", "Remove", "Approve", "View Payments");
				main.display();
				choice = Integer.parseInt(scan.nextLine());
				adminChoice(choice);
			}
			else {
				main = new Menu("Welcome, Customer",
						"Offer", "View Cars", "View Payments");
				main.display();
				choice = Integer.parseInt(scan.nextLine());
				userChoice(choice);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}	
}
