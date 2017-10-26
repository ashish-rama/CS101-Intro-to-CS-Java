package edu.nyu.cs101.assignment2;

import java.util.Scanner;

/**
 * Best Guess Program; Compares two guesses against a random number (Assignment 2 Part 2)
 * @author: Ashish Ramachandran (ar3986)
 */

public class BestGuess {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int randomNumber = (int) (Math.random() * 101);
		System.out.println("First player, make a guess:");
		int firstInput = scan.nextInt();
		System.out.println("Second player, make a guess:");
		int secondInput = scan.nextInt();
		System.out.println("The number was: " + randomNumber);
		if(firstInput == secondInput)
			System.out.println("It is a tie!");
		else if (Math.abs(firstInput - randomNumber) > Math.abs(secondInput - randomNumber))
			System.out.println("Second player won!");
		else
			System.out.println("First player won!");
		scan.close();
	}
	
}
