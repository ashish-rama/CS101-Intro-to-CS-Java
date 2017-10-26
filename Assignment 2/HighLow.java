package edu.nyu.cs101.assignment2;

import java.util.Scanner;

/**
 * HighLow Program; Guessing game to explain if higher or lower than random number (Assignment 2 Part 4)
 * @author: Ashish Ramachandran (ar3986)
 */

public class HighLow {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int guesses = 0;
		int randomNumber = (int) (Math.random() * 334);
		int currentGuess = -1;
		System.out.println("I am thinking of a number from 0 to 333:");
		while(currentGuess != randomNumber && guesses < 7) {
			System.out.println("Make a guess:");
			currentGuess = scan.nextInt();
			if(currentGuess == randomNumber)
				System.out.println("You guessed correctly!");
			else if(Math.max(currentGuess, randomNumber) == currentGuess)
				System.out.println("The number is lower.");
			else
				System.out.println("The number is higher.");
			guesses++;
		}
		System.out.println("You guessed " + (guesses - 1) + " times incorrectly. " +
				"The number was " + randomNumber + ".");
		scan.close();
	}
}
