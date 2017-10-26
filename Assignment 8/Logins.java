package edu.nyu.cs101.assignment8;

import java.util.Scanner;

/**
 * Login Program (Assignment 8 Part 1)
 * @author Ashish Ramachandran (ar3986)
 */
public class Logins {

	//define global variables
	private static boolean NOT_CORRECT_USERNAME = true, 
			NOT_CORRECT_PASSWORD = true;
	private static final int USERNAME_MAX_LENGTH = 16, USERNAME_MIN_LENGTH = 4,
			PASSWORD_MIN_LENGTH = 8;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String username = "", password = "";
		
		//while username input is incorrect
		while(NOT_CORRECT_USERNAME) {
			System.out.print("Username: ");
			username = scan.nextLine().trim();
			System.out.println("\"" + username + "\"");
			//check if starts with letter and is within the length limits
			if(Character.isDigit(username.charAt(0))) {
				System.out.println("Error: username must not start with a number");
			} else if(username.length() >= USERNAME_MAX_LENGTH) {
				System.out.println("Error: username must be less than " + USERNAME_MAX_LENGTH + " characters long");
			} else if(username.length() < USERNAME_MIN_LENGTH) {
				System.out.println("Error: username must be at least " + USERNAME_MIN_LENGTH + " characters long");
			} else {
				NOT_CORRECT_USERNAME = false;
			}
		}
		
		//while password input is incorrect
		while(NOT_CORRECT_PASSWORD) {
			System.out.print("Password: ");
			password = scan.nextLine().trim();
			
			//check if password contains username, within the length limits, contains an uppercase
			//char, contains a lowercase char, and contains a numeric character
			if (password.contains(username)) {
				System.out.println("Error: password cannot contain the username");
			} else if(password.length() < PASSWORD_MIN_LENGTH) {
				System.out.println("Error: password must be at least " + PASSWORD_MIN_LENGTH + " characters long");
			} else if(!containsUpperCaseChar(password)) {
				System.out.println("Error: password must have at least one upper case letter.");
			} else if(!containsLowerCaseChar(password)) {
				System.out.println("Error: password must have at least one lower case letter.");
			} else if(!containsNumericChar(password)) {
				System.out.println("Error: password must have at least one numeric character.");
			} else {
				NOT_CORRECT_PASSWORD = false;
			}
		}
		System.out.println("Valid username/password");
		scan.close();
	}
	
	/**
	 * Checks if a passed string contains at least one uppercase character
	 * @param str the string to check
	 * @return true if <code>str</code> contains at least one uppercase character
	 */
	private static boolean containsUpperCaseChar(String str) {
		for(int i = 0; i < str.length(); i++) {
			if(Character.isUpperCase(str.charAt(i)))
				return true;
		}
		return false;
	}
	
	/**
	 * Checks if a passed string contains at least one lowercase character
	 * @param str the string to check
	 * @return true if <code>str</code> contains at least one lowercase character
	 */
	private static boolean containsLowerCaseChar(String str) {
		for(int i = 0; i < str.length(); i++) {
			if(Character.isLowerCase(str.charAt(i)))
				return true;
		}
		return false;
	}
	
	/**
	 * Checks if a passed string contains at least one numeric character
	 * @param str the string to check
	 * @return true if <code>str</code> contains at least one numeric character
	 */
	private static boolean containsNumericChar(String str) {
		for(int i = 0; i < str.length(); i++) {
			if(Character.isDigit(str.charAt(i)))
				return true;
		}
		return false;
	}
}
