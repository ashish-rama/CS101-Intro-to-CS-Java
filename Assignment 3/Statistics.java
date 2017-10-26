package edu.nyu.cs101.assignment3;

import java.util.Scanner;

/**
 * Exercise03_18 Program and calculates the cost of shipping (Assignment 3 Part 2)
 * @author Ashish Ramachandran (ar3986)
 *
 */
public class Statistics {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int totalNumbers = 0, totalSum = 0, maxNum = 0, minNum = 0, positives = 0, negatives = 0;
		System.out.println("Enter a series of number ('0' when you're done):");
		int scanned = scan.nextInt();
		while(scanned != 0) {
			totalNumbers++;
			totalSum += scanned;
			if(scanned > maxNum)
				maxNum = scanned;
			if(scanned < minNum)
				minNum = scanned;
			if(scanned > 0)
				positives++;
			else
				negatives++;
			scanned = scan.nextInt();
		}
		System.out.println("Number of values: " + totalNumbers + "\n"
				+ "Total: " + totalSum + "\nAverage: " + ((double) totalSum / totalNumbers) + "\n"
				+ "Largest: " + maxNum + "\nSmallest: " + minNum + "\n" +
						"Size of Range: " + difference(maxNum, minNum) + "\n" +
						"Positives: " + positives + "\nNegatives: " + negatives);
		scan.close();
	}
	
	/**
	 * Returns the difference between two passed integers
	 * @param larger the larger integer
	 * @param smaller the smaller integer
	 * @return the difference between <code>larger</code> and <code>smaller</code>
	 */
	public static int difference(int larger, int smaller) {
		return larger - smaller;
	}

}
