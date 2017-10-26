package edu.nyu.cs101.assignment11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * NYCData class that mines for data (Assignment 11 Part 1)
 * Mines the data from: https://data.cityofnewyork.us/Education/NYS-Math-Test-Results-By-Grade-2006-2011-School-Le/jufi-gzgp
 * 		Format of the CSV File: DBN,Grade,Year,Category,Number Tested,Mean Scale Score,Level 1 #,Level 1 %,Level 2 #,Level 2 %,Level 3 #,Level 3 %,Level 4 #,Level 4 %,Level 3+4 #,Level 3+4 %
 * @author Ashish Ramachandran (ar3986)
 */
public class NYCData {

	public static File csvFile;
	public static Scanner csvFileScanner;
	public static Scanner userScanner;
	public static final int GRADE_SEARCH = 1, YEAR_SEARCH = 2, QUIT = 3;
	public static final int DBN_INDEX = 0, GRADE_INDEX = 1, YEAR_INDEX = 2, NUM_TESTED_INDEX = 4, MEAN_SCALE_SCORE_INDEX = 5;
	public static final int NUMBER_ITEMS_TO_SHOW = 10;
	public static ArrayList<String> dbn;
	public static ArrayList<Integer> grades;
	public static ArrayList<Integer> years;
	public static ArrayList<Integer> numberTested;
	public static ArrayList<Integer> scores;

	public static void main(String[] args) {
		//initialize file and scanner
		try {
			csvFile = new File("NYS_Math_Test_Results_By_Grade_2006-2011_-_School_Level_-_All_Students.csv");
			csvFileScanner = new Scanner(csvFile);
		} catch (FileNotFoundException e) {
			System.out.println("The file you are looking for does not exist!");
		}
		//initialize ArrayLists for storing the necessary information
		dbn = new ArrayList<String>();
		grades = new ArrayList<Integer>();
		years = new ArrayList<Integer>();
		numberTested = new ArrayList<Integer>();
		scores = new ArrayList<Integer>();

		//populate the ArrayLists with the information
		int count = 0;
		while(csvFileScanner.hasNext()) {
			count++;
			String line = csvFileScanner.nextLine();
			String[] splittedLine = line.split(",");

			//if its not the first line, and has a integer value add to respective ArrayList
			if(count > 1 && !splittedLine[GRADE_INDEX].equals("All Grades") && !splittedLine[MEAN_SCALE_SCORE_INDEX].equals("s")
					&& !splittedLine[MEAN_SCALE_SCORE_INDEX].equals(" ")) {
				dbn.add(splittedLine[DBN_INDEX]);
				grades.add(Integer.parseInt(splittedLine[GRADE_INDEX]));
				years.add(Integer.parseInt(splittedLine[YEAR_INDEX]));
				numberTested.add(Integer.parseInt(splittedLine[NUM_TESTED_INDEX]));
				scores.add(Integer.parseInt(splittedLine[MEAN_SCALE_SCORE_INDEX]));
			}
		}

		//initialize user input scanner
		userScanner = new Scanner(System.in);

		System.out.println("Welcome to the Data Miner App for NYS Math Test Results by Grade (2006-2011) All Students!");
		System.out.println("This app mines data from https://data.cityofnewyork.us/Education/NYS-Math-Test-Results-By-Grade-2006-2011-School-Le/jufi-gzgp");
		System.out.println("We show you the scores of NYS Math Test takers from grades 3-8 from 2006-2011.");
		System.out.println("------------------------------------------------------------------------------------------");
		printOptions();
		int input = userScanner.nextInt();

		while(input != QUIT) {
			if(input == GRADE_SEARCH) {
				System.out.print("Which grade? (3 - 8): ");
				int option = userScanner.nextInt();
				if(option > 2 && option < 9) {
					printByGrade(option);
				} else {
					System.out.println("Please enter a valid grade!");
				}
			} else if(input == YEAR_SEARCH) {
				System.out.print("Which year? (2006 - 2011): ");
				int option = userScanner.nextInt();
				if(option > 2005 && option < 2012) {
					printByYear(option);
				} else {
					System.out.println("Please enter a valid grade!");
				}
			} else {
				System.out.println("Choose a valid option!");
				System.out.println("----------------------");
			}
			printOptions();
			input = userScanner.nextInt();
		}
		System.out.println("Thanks for using the program and data mining with us!");
		userScanner.close();
	}

	/**
	 * Prints options for the menu
	 */
	public static void printOptions() {
		System.out.println("Choose an option:");
		System.out.println("1) Lookup by grade");
		System.out.println("2) Lookup by year");
		System.out.println("3) Quit");
	}

	/**
	 * Prints information from the data set based on the grade the user inputed
	 * @param grade the inputed grade to sort the results by
	 */
	public static void printByGrade(int grade) {
		System.out.println("You have selected grade: " + grade);
		System.out.println("Found " + getCount(grades, grade) + " data sets for that grade. Showing results:");
		int iterator = 0;
		int counter = 0;
		int itemsShowing = 0;
		String inputString = userScanner.nextLine();
		
		//displays the first 10 items and if user presses space, shows the next 10. Checks for out of bounds exception as well
		while(inputString.equals("")) {
			while (counter < itemsShowing + NUMBER_ITEMS_TO_SHOW  && (iterator < grades.size())) {
				if(grades.get(iterator) == grade) {
					counter++;
					System.out.println(counter + ") Grade: " + grade + ", DBN: " + dbn.get(iterator) + ", Year: " + years.get(iterator)
							+ ", Number Tested: " + numberTested.get(iterator) + ", Mean Scale Score: " + scores.get(iterator));
				}
				iterator++;
			}
			
			//used to keep track of how many more items to show
			itemsShowing = counter;
			System.out.println("Press space to see the next " + NUMBER_ITEMS_TO_SHOW + " items... (anything else to quit)");
			inputString = userScanner.nextLine();
		}
	}

	/**
	 * Prints information from the data set based on the year the user inputed
	 * @param year the inputed year to sort the results by
	 */
	public static void printByYear(int year) {
		System.out.println("You have selected grade: " + year);
		System.out.println("Found " + getCount(years, year) + " data sets for that grade. Showing results:");
		int iterator = 0;
		int counter = 0;
		int itemsShowing = 0;
		String inputString = userScanner.nextLine();
		
		while(inputString.equals("")) {
			while (counter < itemsShowing + NUMBER_ITEMS_TO_SHOW && (iterator < years.size())) {
				if(years.get(iterator) == year) {
					counter++;
					System.out.println(counter + ") Year: " + year + ", DBN: " + dbn.get(iterator) + ", Grade: " + grades.get(iterator)
							+ ", Number Tested: " + numberTested.get(iterator) + ", Mean Scale Score: " + scores.get(iterator));
				}
				iterator++;
			}
			itemsShowing = counter;
			System.out.println("Press space to see the next " + NUMBER_ITEMS_TO_SHOW + " items... (anything else to quit)");
			inputString = userScanner.nextLine();
		}
	}

	/**
	 * Gets the number of data sets in an array that contains an inputed value
	 * @param array the array to look through for matching value
	 * @param value the value to look for in the array
	 * @return count the number of data sets found in the array with the inputed value
	 */
	public static int getCount(ArrayList<Integer> array, int value) {
		int count = 0;
		for(int number : array) {
			if(number == value)
				count++;
		}
		return count;
	}

}
