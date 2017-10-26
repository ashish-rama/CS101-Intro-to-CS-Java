package edu.nyu.cs101.assignment2;

import java.util.Scanner;

/**
 * Betting Program; Gambling game (Assignment 2 Part 3)
 * @author: Ashish Ramachandran (ar3986)
 */

public class Betting {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int cash = 10;
		System.out.println("Welcome to the betting game!");
		while(cash > 0) {
			System.out.println("----------");
			System.out.println("You currently have $" + cash
					+ ".\nHow much do you want to bet? ($0 to quit):");
			int bet = scan.nextInt();
			if(bet > cash)
				System.out.println("You can't bet more money than you have!");
			else if (bet == 0) {
				System.out.println("You ended with $" + cash + ". Goodbye!");
				return;
			} else {
				System.out.println("Heads or tails? (0 for heads, 1 for tails):");
				int guess = scan.nextInt();
				int coinToss = (int) (Math.random() * 2);
				System.out.print("The flip was " + (coinToss == 0 ? "heads! " : "tails! "));
				if (guess == coinToss) {
					System.out.println("You win $" + bet + "!");
					cash += bet;
				} else {
					System.out.println("You lose $" + bet + "!");
					cash -= bet;
					if(cash == 0)
						System.out.println("Thanks for playing!");
				}
			}
		}
	}
}
