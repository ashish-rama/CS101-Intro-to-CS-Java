package edu.nyu.cs101.assignment1;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Excercise 2.23; Due 9/10 (Assignment 1)
 * @author: Ashish Ramachandran (ar3986)
 */

public class Exercise02_23 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the driving distance:");
		double distance = scan.nextDouble();
		System.out.println("Enter miles per gallon:");
		double mpg = scan.nextDouble();
		System.out.println("Enter price per gallon:");
		double pricePerGallon = scan.nextDouble();
		System.out.println("The cost of driving is " 
				+ DecimalFormat.getCurrencyInstance().format((distance/mpg) * pricePerGallon));
		scan.close();
	}

}
