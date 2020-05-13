package com.revature.driver;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	private String title;
	private List<String> items = new ArrayList<String>();
	private static final String blueString = "\u001B[36m";
	private static final String resetString = "\u001B[0m";
	
	public Menu(String title) {
		this.title = title;
	}
	public Menu(String title, String...menuItems) {
		this.title = title;
		
		//cycle through the user inputs to add the list
		for (String item : menuItems)
			this.items.add(item);
	}
	
	public void addItem(String item) {
		items.add(item);
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public void display() {
		System.out.println("=============================");
		System.out.println(blueString + "\t" + title + resetString);
		System.out.println("=============================");
		
		int counter = 1;
		for (String item : items)
			System.out.println(blueString + counter++ + ") " + item + resetString);
	}
}
