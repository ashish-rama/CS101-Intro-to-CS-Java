package edu.nyu.cs101.assignment9;

import java.util.Scanner;

/**
 * Mixology class to allow aspiring wizards to make potions (Assignment 9 Part 3)
 * @author Ashish Ramachandran (ar3986)
 */
public class Mixology {
	
	private static final int QUIT = 0;
	private static final int ADD_POTION = 1;
	private static final int REMOVE_POTION = 2;
	private static final int LIST_POTIONS = 3;
	private static final int REGULAR_POTION = 4;
	private static final int INVISIBILITY_POTION = 5;
	
	public static void main(String[] args) {
		//Set up scanners and cabinet objects
		Scanner intScanner = new Scanner(System.in);
		Scanner stringScanner = new Scanner(System.in);
		PotionCabinet cabinet = new PotionCabinet();
		
		//welcome the student and prompt options
		System.out.println("Welcome to Ashish's Potions class!");
		printOptions();
		int input = intScanner.nextInt();
		
		while(input != QUIT) {
			
			//Option 1: adding a potion
			if(input == ADD_POTION) {
				//prompt user what kind of potion to add
				System.out.println("---------What kind of potion?---------");
				System.out.println("4) Add a regular potion");
				System.out.println("5) Add an invisibility potion");
				input = intScanner.nextInt();
				
				if(input == REGULAR_POTION) {
					//prompt user for size of potion
					System.out.println("What is the maximum amount of ingredients? (0 for default size of " +
							Potion.DEFAULT_MAX_SIZE + ")");
					input = intScanner.nextInt();
					
					//if setting a certain size
					if(input > 0) {
						Potion potion = new Potion(input);
						cabinet.addPotion(potion);
						System.out.println("Please input ingredients:");
						String stringInput = stringScanner.nextLine();
						addIngredients(stringInput, potion);
					} 
					//if using default size
					else if (input == 0)  {
						Potion potion = new Potion();
						cabinet.addPotion(potion);
						System.out.println("Please input ingredients:");
						String stringInput = stringScanner.nextLine();
						addIngredients(stringInput, potion);
					} else {
						System.out.println("That is not a valid option!");
					}
				} 
				
				else if(input == INVISIBILITY_POTION) {
					System.out.println("What is the maximum amount of ingredients? (0 for default size of " +
							Potion.DEFAULT_MAX_SIZE + ")");
					input = intScanner.nextInt();
					
					//if setting a certain size
					if(input > 0) {
						InvisibilityPotion potion = new InvisibilityPotion(input);
						cabinet.addPotion(potion);
						System.out.println("Please input ingredients:");
						String stringInput = stringScanner.nextLine();
						addIngredients(stringInput, potion);
					} 
					//if using default size
					else if (input == 0)  {
						InvisibilityPotion potion = new InvisibilityPotion();
						cabinet.addPotion(potion);
						System.out.println("Please input ingredients:");
						String stringInput = stringScanner.nextLine();
						addIngredients(stringInput, potion);
					} else {
						System.out.println("That is not a valid option!");
					}
				} else {
					System.out.println("That is not a valid option!");
				}
			} 
			
			//Option 2: remove a potion
			else if(input == REMOVE_POTION) {
				if(cabinet.getPotions().size() > 0) {
					cabinet.listPotions();
					System.out.println("What is the index of the potion you want to remove?");
					input = intScanner.nextInt();
					
					//make sure input is within bounds of the array
					if(input >= 0 && input < cabinet.getPotions().size()) {
						cabinet.removePotion(input);
						System.out.println("Removed selected potion.");
					} else {
						System.out.println("That index does not exist!");
					}
				} else {
					System.out.println("There are no potions in the cabinet to remove!");
				}
			} 
			
			//Option 3: List the potions
			else if(input == LIST_POTIONS) {
				if(cabinet.getPotions().size() == 0)
					System.out.println("There are no potions in the cabinet.");
				else
					cabinet.listPotions();
			} else {
				System.out.println("Please input a valid option!");
			}
			
			//Reprint options and get the next option input
			printOptions();
			input = intScanner.nextInt();
		}
		
		//When inputted 0 (quit out of while loop) print "thanks" and close scanners
		System.out.println("Thanks for attending potions class!");
		intScanner.close();
		stringScanner.close();
	}
	
	/**
	 * Prints the options the user can select from of the Mixology class
	 */
	private static void printOptions() {
		System.out.println("---------Select an option---------");
		System.out.println("1) Add a Potion");
		System.out.println("2) Remove a Potion");
		System.out.println("3) List Potions");
	}
	
	/**
	 * Adds ingredients to a given potion
	 * @param ingredients ingredients to add
	 * @param potion the potion the ingredients are being added to
	 */
	private static void addIngredients(String ingredients, Potion potion) {
		for(char letter : ingredients.toCharArray())
			potion.addIngredient(letter);
	}

}
