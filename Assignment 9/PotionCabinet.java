package edu.nyu.cs101.assignment9;

import java.util.ArrayList;

/**
 * PotionCabinet class to store different Potions (Assignment 9 Part 2)
 * @author Ashish Ramachandran (ar3986)
 */
public class PotionCabinet {
	
	private ArrayList<Potion> potions;
	
	/**
	 * Creates a new PotionCabinet and initializes a list of Potions
	 */
	public PotionCabinet() {
		potions = new ArrayList<Potion>();
	}

	/**
	 * Adds a Potion to the current PotionCabinet's list of potions
	 * @param p the Potion to add
	 */
	public void addPotion(Potion p) {
		potions.add(p);
	}
	
	/**
	 * Removes a Potion from the current PotionCabinet's list of potions given its index
	 * @param index the index of the Potion to remove
	 * @return the Potion removed from the list at <code>index</code>
	 */
	public Potion removePotion(int index) {
		return potions.remove(index);
	}
	
	/**
	 * Prints all the Potions in the PotionCabinet
	 */
	public void listPotions() {
		for(int i = 0; i < potions.size(); i++) {
			System.out.println("index: " + i + ") " + potions.get(i));
		}
	}
	
	/**
	 * Gets the list of potions in the cabinet
	 * @return potions the potions in the cabinet
	 */
	public ArrayList<Potion> getPotions() {
		return potions;
	}
	
	/**
	 * Sets the list of potions in the cabinet
	 * @param potions the new list of potions for the cabinet
	 */
	public void setPotions(ArrayList<Potion> potions) {
		this.potions = potions;
	}
}
