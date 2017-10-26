package edu.nyu.cs101.assignment2;

import java.util.Scanner;

/**
 * Exercise03_18 Program and calculates the cost of shipping (Assignment 2 Part 1)
 * @author: Ashish Ramachandran (ar3986)
 */

public class Exercise03_18 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("What is the weight of the package?:");
		int weight = scan.nextInt();
		double cost = 0;
		if(weight > 0 && weight <= 1) cost = 3.5;
		else if(weight > 1 && weight <= 3) cost = 5.5;
		else if(weight > 3 && weight <= 10) cost = 8.5;
		else if(weight > 10 && weight <= 20) cost = 10.5;
		
		if(weight <= 50)
			System.out.println("The cost of shipping is $" + cost);
		else
			System.out.println("The package cannot be shipped.");
		scan.close();
	}

}
