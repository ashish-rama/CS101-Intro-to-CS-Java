package edu.nyu.cs101.assignment5;

import java.util.Arrays;
import java.util.Random;

/**
 * This class calculates processing times of methods from the Arrayders.java class
 * Assignment 5 Part 3
 * @author Ashish Ramachandran (ar3986)
 * Sources used: LinearSearch.java and ArrayLib.java from lecture 10 on October 6, 2014
 * 
 * Findings: For the sorting methods, the bubble sort was the slowest (as it loops through
 * the entire array searching for its values), my own (insertion) Arrayders.sort() method was faster
 * than bubble sort but slower than Arrays.sort(), and Arrays.sort() was the fastest. This could be 
 * because the java library uses more optimizations of time whereas my own insertion sort method was fairly simple. 
 * 
 * For the searching methods, the linear search method was the slowest (given that the array
 * was sorted already) and my own binary search method (Arrayders.binarySearch()) was faster than 
 * linear search and on the same magnitude as the Arrays.binarySearch(). Although there was a small
 * discrepancy between my and the Arrays class's binary search times, it could again because of the 
 * different optimizations in the java language.
 * 
 */

public class ArraydersTester {
	
	public static final int[] ARRAY_SIZES = { 10, 100, 1000, 10000, 100000 };
	
	public static final int NUM_SEARCHES = 100000;
	
	public static final int MIN_VALUE = Integer.MIN_VALUE;
    public static final int MAX_VALUE = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		// Get a random item to search for
        Random random = new Random();
        int item = random.nextInt(MAX_VALUE);

        for (int size : ARRAY_SIZES) {
            int[] randomNumbers = new int[size];
            Arrayders.populate(randomNumbers, MIN_VALUE, MAX_VALUE);
            
            System.out.println("Array size: " + size);
            int[] array1 = Arrays.copyOf(randomNumbers, randomNumbers.length);
            int[] array2 = Arrays.copyOf(randomNumbers, randomNumbers.length);
            int[] array3 = Arrays.copyOf(randomNumbers, randomNumbers.length);
            
            System.out.println("-------------------");
            System.out.println("Running benchmarks:");
            System.out.println("-------------------");
            
            Arrayders.bubbleSort(array1);
            Arrayders.sort(array2);
            Arrayders.javaUtilArraysSort(array3);
            
            System.out.println();
            
            benchmarkLinearSearch(array1, item);
            benchmarkArraydersBinarySearch(array1, item);
            benchmarkJavaUtilArraysBinarySearch(array1, item);
            
            System.out.println("---------------------------------------------------------------");
            System.out.println("\n");
        }
	}
	
	/**
     * Runs a linear search on <code>numbers</code> to try and locate the element <code>item</code>.
     * 
     * @param numbers the array to search
     * @param item the item to search for
     * @return the index of <code>item</code> in <code>numbers</code> or a negative value if it doesn't exist.
     */
    public static int benchmarkLinearSearch(int[] numbers, int item) {
        // Default to a negative number to indicate that 'item' isn't in our array
        int location = -1;

        // Start timer
        long startTime = System.nanoTime();
        for (int i = 0; i < NUM_SEARCHES; i++) {
            location = Arrayders.linearSearch(numbers, item);
        }
        long endTime = System.nanoTime();

        // End timer and print results
        System.out.println("Processing time linearSearch: " + ((endTime - startTime)/(Math.pow(10, 6))) + " millisec");
        return location;
    }
    
    /**
     * Runs a Arrayders.binarySearch() on <code>numbers</code> to try and locate the element <code>item</code>.
     * 
     * @param numbers the array to search
     * @param item the item to search for
     * @return the index of <code>item</code> in <code>numbers</code> or a negative value if it doesn't exist.
     */
    public static int benchmarkArraydersBinarySearch(int[] numbers, int item) {
        // Default to a negative number to indicate that 'item' isn't in our array
        int location = -1;

        // Start timer
        long startTime = System.nanoTime();
        for (int i = 0; i < NUM_SEARCHES; i++) {
            location = Arrayders.binarySearch(numbers, item);
        }
        long endTime = System.nanoTime();

        // End timer and print results
        System.out.println("Processing time Arrayders.binarySearch(): " 
        		+ ((endTime - startTime)/(Math.pow(10, 6))) + " millisec");
        return location;
    }
    
    /**
     * Runs a java.util.Arrays.binarySearch() on <code>numbers</code> to try and locate the element <code>item</code>.
     * 
     * @param numbers the array to search
     * @param item the item to search for
     * @return the index of <code>item</code> in <code>numbers</code> or a negative value if it doesn't exist.
     */
    public static int benchmarkJavaUtilArraysBinarySearch(int[] numbers, int item) {
        // Default to a negative number to indicate that 'item' isn't in our array
        int location = -1;

        // Start timer
        long startTime = System.nanoTime();
        for (int i = 0; i < NUM_SEARCHES; i++) {
            location = Arrays.binarySearch(numbers, item);
        }
        long endTime = System.nanoTime();

        // End timer and print results
        System.out.println("Processing time java.util.Arrays.binarySearch(): " 
        		+ ((endTime - startTime)/(Math.pow(10, 6))) + " millisec");
        return location;
    }

}
