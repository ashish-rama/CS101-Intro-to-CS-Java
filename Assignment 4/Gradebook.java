package edu.nyu.cs101.assignment4;

import java.util.Scanner;

/**
 * Gradebook program (Assignment 4 Part 2)
 * @author Ashish Ramachandran (ar3986)
 */
public class Gradebook {

	public static int[] GRADES = {};
	public static final int ADD_GRADE = 1, DELETE_GRADE = 2, UPDATE_GRADE = 3, 
				PRINT_GRADES = 4, PRINT_STATS = 5, QUIT = 6;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		displayMessage();
		int input = scan.nextInt();
		
		while(input != QUIT) {
			//Checks if input is within the options
			if(input < QUIT && input >= ADD_GRADE) {
				//Adds a grade
				if(input == ADD_GRADE) {
					System.out.print("Enter a grade to add: ");
					GRADES = Arrayders.insert(GRADES, scan.nextInt());
				}
				//Checks if grades have been inputed
				if(GRADES.length > 0) {
					//Deletes a grade
					if(input == DELETE_GRADE) { 
						System.out.print("Which grade to delete (0-" + (GRADES.length - 1) + "): ");
						int index = scan.nextInt();
						if(index < GRADES.length) {
							GRADES = Arrayders.delete(GRADES, index);
						} else {
							System.out.println("The inputted value is out of bounds!");
						}
					} 
					//Updates a grade
					else if(input == UPDATE_GRADE) { 
						System.out.print("Which grade to update (0-" + (GRADES.length - 1) + "): ");
						int index = scan.nextInt();
						if(index < GRADES.length) {
							System.out.print("Enter the new grade: ");
							GRADES[index] = scan.nextInt();
						} else {
							System.out.println("The inputted value is out of bounds!");
						}
					} 
					//Prints the grades
					else if(input == PRINT_GRADES) { 
						System.out.println("Num\t|\tGrade");
						System.out.println("----------------------");
						for(int i = 0; i < GRADES.length; i++) {
							System.out.println("[" + i + "]\t|\t" + GRADES[i]);
						}
						System.out.println("----------------------");
					} 
					//Prints the statistics
					else if(input == PRINT_STATS) {
						System.out.println("Average: " + Arrayders.average(GRADES));
						System.out.println("Median: " + Arrayders.median(GRADES));
						System.out.println("Mode: " + Arrayders.mode(GRADES));
						System.out.println("Highest: " + Arrayders.max(GRADES));
						System.out.println("Lowest: " + Arrayders.min(GRADES));
						System.out.println("Range: " + Arrayders.range(GRADES));
					}
				} else {
					System.out.println("Please first input a grade!");
				}
			} else {
				System.out.println("Please choose an option between 1 and 6!");
			}
			//Precursor for the next iteration
			displayMessage();
			input = scan.nextInt();
		}
		System.out.println("Thanks for using Gradebook!");
		scan.close();
	}

	/**
	 * Displays the recurring message of the grade book options 
	 */
	private static void displayMessage() {
		System.out.println("Welcome to Gradebook!");
		System.out.println("---------------------");
		System.out.print("1) Add a grade\n" +
				"2) Delete a grade\n" +
				"3) Update a grade\n" +
				"4) Print grades\n" +
				"5) Print statistics\n" +
				"6) Quit\n" +
				"Choose an option (1-6): ");
	}

}
