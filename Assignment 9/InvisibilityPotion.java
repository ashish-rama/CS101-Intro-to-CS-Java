package edu.nyu.cs101.assignment9;

/**
 * Invisibility Potion class that extends Potion (Assignment 9 Part 1)
 * @author Ashish Ramachandran (ar3986)
 */
public class InvisibilityPotion extends Potion {
	
	private static final char[] VALID_INGREDIENTS = {'b', 'w', 'a'};
	private static final char FIRST_AND_LAST_INGREDIENT = 'b';
	
	/**
	 * Default constructor that creates the InvisibilityPotion with default size
	 */
	public InvisibilityPotion() {
		super();
	}
	
	/**
     * Creates a new InvisibilityPotion with a specific maximum size
     * @param maxIngred maximum size of this InvisibilityPotion
     */
	public InvisibilityPotion(int maxSize) {
		super(maxSize);
	}
	
	/**
	 * Checks if the ingredients of the InvisibilityPotion is a palindrome (a prerequisite for success)
	 * @return true if the InvisibilityPotion's ingredients are a palindrome
	 */
	public boolean isPalindrome() {
		//gets the middle index whether it is odd or even amount of letters
		int middleIndex = ingredients.length() / 2;
		
		//checks if has odd or even amount of letters
		boolean hasEvenLetters = ingredients.length() % 2 == 0;
		
		//checks if the first half of the ingredients is equal to the reverse of the second half of the ingredients
		if(ingredients.substring(0, middleIndex).equals(
				new StringBuilder(ingredients.substring(
						
						//if odd amount of letters in the ingredients, excludes the middle letter
						hasEvenLetters ? middleIndex : middleIndex + 1)).reverse().toString()))
			return true;
		return false;
	}
	
	/**
	 * Checks if the only type of ingredients in the InvisibilityPotion are 'b', 'w', and 'a'
	 * @return true if 'b', 'w', and 'a' are the only ingredients in the InvisibilityPotion
	 */
	public boolean checkAllTypesOfIngredients() {
		//for each ingredient, check if it is valid else return false
		for(int i = 0; i < ingredients.length(); i++) {
			if(!isValid(ingredients.charAt(i)))
				return false;
		}
		return true;
	}
	
	/**
	 * Checks that the InvisibilityPotion contains at least one 'b', 'w' and 'a'
	 * @return true if the InvisibilityPotion contains at least one 'b', 'w' and 'a'
	 */
	public boolean containSelectIngredients() {
		//create boolean array with size of the number of valid ingredients
		boolean[] validIngreds = new boolean[VALID_INGREDIENTS.length];
		
		//check each ingredient
		for(int i = 0; i < ingredients.length(); i++) {
			
			//for each ingredient needed
			for(int j = 0; j < VALID_INGREDIENTS.length; j++) {
				
				//if the ingredient is one of the ingredients needed, make it true that the potion contains the ingredient
				if(ingredients.charAt(i) == VALID_INGREDIENTS[j])
					validIngreds[j] = true;
			}
		}
		//if the contents of the potion contains all of the ingredients needed return true
		for(boolean value : validIngreds) {
			if(!value)
				return false;
		}
		return true;
	}
	
	/**
	 * Checks if the first (and last) ingredient are 'b'
	 * @return true if the first (and last) ingredient of InvisibilityPotion are 'b'
	 */
	public boolean checkFirstAndLastIngredient() {
		return ingredients.charAt(0) == FIRST_AND_LAST_INGREDIENT &&
				ingredients.charAt(ingredients.length() - 1) == FIRST_AND_LAST_INGREDIENT;
	}
	
	/**
	 * @return String representation of the InvisibilityPotion with ingredients, type, and if it was created successfully
	 */
	public String toString() {
		return super.toString() + ", Type of potion: Invisibility, Successful: " + isSuccessful();
	}
	
	/**
	 * Checks to see if InvisibilityPotion was created successfully
	 * @return true if all the requirements of the InvisibilityPotion were met
	 */
	public boolean isSuccessful() {
		return isPalindrome() && checkAllTypesOfIngredients() && containSelectIngredients() && checkFirstAndLastIngredient();
	}
	
	/**
     * Checks if an ingredient is a valid ingredient
     * 
     * @param ingredient to check
     * @return true if ingredient is valid; otherwise false
     */
    public boolean isValid(char ingredient) {
        for (char validChar : VALID_INGREDIENTS) {
            if (ingredient == validChar)
                return true;
        }
        return false;
    }

}
