package edu.nyu.cs101.assignment5;

import java.util.Arrays;

/**
 * A library to provide lots of extra array functionality.
 * Array Library Assignment (Assignment 4 Part 1, Assignment 5 Part 1 & 2)
 * @author Ashish Ramachandran (ar3986)
 * 
 *         TODO: Several of the functions in this library have been written for
 *         you, but there are many that still need to be implemented. Go through
 *         the following code and replace the TODO statements with your own
 *         implementations.
 *         
 * Sources: http://stackoverflow.com/questions/11281422/insertion-sort-algorithm-pseudocode
 * 			The above source was used to verify that Assignment 5 Part 1 was an example of insertion sort
 */
public class Arrayders {

    /**
     * Get the smallest value in <code>array</code>
     * 
     * @param array the array to analyze
     * @return the smallest value in <code>array</code>
     */
    public static int min(int[] array) {
        int min = array[0];
        for(int value : array)
        	if(value < min)
        		min = value;
        return min;
    }

    /**
     * Get the largest value in <code>array</code>
     * 
     * @param array the array to analyze
     * @return the largest value in <code>array</code>
     */
    public static int max(int[] array) {
    	int max = array[0];
		for(int value : array)
			if(value > max)
				max = value;
		return max;
    }

    /**
     * Computes the sum of all values in <code>array</code>
     * 
     * @param array
     *            array to sum the values of
     * @return the sum of all values in <code>array</code>
     */
    public static int sum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    /**
     * Computes the average of all values in <code>array</code>
     * 
     * @param array
     *            array to average the values of
     * @return the average of all values in <code>array</code>
     */
    public static double average(int[] array) {
    	return sum(array) / (1.0 * array.length); //needs to multiply by 1.0 to solve a roundoff error
    }

    /**
     * Given an array (of possibly unsorted values), it will return the median
     * of the numbers (as if they were sorted) in the array. If the median is
     * two different numbers, it will return the average of those two numbers
     * rounded down. The original array is not modified.
     * 
     * A median is defined as given as given a list of sorted numbers, the
     * number that is the absolute middle position. If there is an even number
     * of numbers the median is averaged between the two.
     * 
     * @param array
     *            the array to analyze
     * @return the median of <code>array</code>
     */
    public static int median(int[] array) {
    	//Create new array and sort it in increasing order
    	int[] newArray = Arrays.copyOf(array, array.length);
    	Arrays.sort(newArray);
    	
    	//if an even number of elements, then average the middle terms
    	if(array.length % 2 == 0)
    		return (newArray[newArray.length / 2] + newArray[(newArray.length - 1) / 2]) / 2;
    	
    	//return the middle value
        return newArray[newArray.length / 2];
    }

    /**
     * Count the number of occurrences of a value in an array
     * 
     * @param array
     *            the array to analyze
     * @param valueToFind
     *            the value to search for
     * @return the number of occurrences of <code>valueToFind</code> in
     *         <code>array</code>
     */
    public static int count(int[] array, int valueToFind) {
        int count = 0;
        for (int item : array) {
            if (item == valueToFind) {
                count++;
            }
        }
        return count;
    }

    /**
     * Gets the number that occurs most frequently.
     * 
     * @param array
     *            the array to analyze
     * @return the mode of <code>array</code>
     */
    public static int mode(int[] array) {
    	int occurence = 0;
    	int currentMode = array[0];
    	//for each value
    	for(int value : array)
    		
    		//if the occurrence of the value is greater than the previous
    		if(count(array, value) > occurence) {
    			
    			//set a new (current/temporary) mode
    			occurence = count(array, value);
    			currentMode = value;
    		}
        return currentMode;
    }

    /**
     * Gets an array of two values representing the lowest and highest values in
     * the array passed in.
     * 
     * @param array
     *            the array to analyze
     * @return an array of two elements where index 0 is the lowest value in
     *         <code>array</code> and index 1 is the highest value in
     *         <code>array</code>.
     */
    public static int[] highLow(int[] array) {
        // Stores the highest and lowest values:
        // highLow[0] -> lowest value, highLow[1] -> highest value
        int[] highLow = new int[2];
        highLow[0] = min(array);
        highLow[1] = max(array);
        return highLow;
    }

    /**
     * Gets the difference between the highest and lowest values.
     * 
     * @param array
     *            the array to analyze
     * @return the difference between the highest and lowest values in an array
     */
    public static int range(int[] array) {
        return highLow(array)[1] - highLow(array)[0];
    }

    /**
     * Creates a duplicate array that is identical to the original array, except
     * the element at the given index has been removed. All subsequent elements
     * are moved closer to the front of the array (i.e. each subsequent
     * element's index is reduced by 1). The original array is not modified. The
     * new array will have a length of 1 less than the original array.
     * 
     * @param array
     *            the array to remove a copy of
     * @param index
     *            the index of the element to remove
     * @return a new array with the element removed
     */
    public static int[] delete(int[] array, int index) {
    	//Create new array
    	int[] newArray = new int[array.length - 1];
    	
    	//Add all elements from the original array up to the index given
    	for(int i = 0; i < index; i++)
    		newArray[i] = array[i];
    	
    	//Adds all the elements from the original array one past the given index
    	for(int i = index + 1; i < array.length; i++)
    		newArray[i - 1] = array[i];
    	
        return newArray;
    }

    /**
     * Creates a duplicate array that is identical to the original array, except
     * that a new element has been added to the end of the array. The original
     * array is not modified. The new array will have a length of 1 more than
     * the original array.
     * 
     * @param array
     *            the array to remove a copy of
     * @param value
     *            the value of the element to insert
     * @return a new array with the element removed
     */
    public static int[] insert(int[] array, int value) {
    	//Create new array
        int[] newArray = Arrays.copyOf(array, array.length + 1);
        
        //Assign final value
        newArray[newArray.length - 1] = value;
        
        return newArray;
    }

    /**
     * Creates a duplicate array that is identical to the original array, except
     * that a new element has been appended to beginning of the array. All other
     * elements are moved up one index (value at index 0 moved to index 1). The
     * original array is not modified. The new array will have a length of 1
     * more than the original array.
     * 
     * @param array
     *            the original array
     * @param value
     *            the value of the element to add
     * @return a new array with an added element at the start of the array
     */
    public static int[] push(int[] array, int value) {
        // Create new array
        int[] newArray = new int[array.length + 1];

        // Assign new starting value
        newArray[0] = value;

        // Copy all remaining values
        for (int i = 1; i < newArray.length; i++) {
            newArray[i] = array[i - 1];
        }
        return newArray;
    }

    /**
     * Creates a duplicate array that is identical to the original array,
     * except that the first element from the array has been removed. All other
     * elements are moved down one index. The original array is not modified.
     * The new array will have a length of 1 less than the original array.
     * 
     * @param array
     *            the original array
     * @return a new array with first element removed.
     */
    public static int[] pop(int[] array) {
        // Create new array
        int[] newArray = new int[array.length - 1];

        // Copy all but the first element
        for (int i = 1; i < array.length; i++) {
            newArray[i - 1] = array[i];
        }
        return newArray;

    }
    
    //Assignment 5 Part 1
    
    /**
     * Sorts the passed array using insertion sort
     * 
     * @param array the array being sorted
     */
    public static void sort(int[] array) {
    	//start timer and sort
    	long startTime = System.nanoTime();
    	for(int i = 1; i < array.length; i++) {
    		int j = i;
    		while(j > 0 && array[j - 1] > array[j]) {
    			int temp = array[j];
    			array[j] = array[j - 1];
    			array[j - 1] = temp;
    			j--;
    		}
    	}
    	
    	//end timer and print results
    	long endTime = System.nanoTime();
    	System.out.println("Processing time Arrayders.sort(): " 
    			+ ((endTime - startTime)/(Math.pow(10, 6))) + " millisec");
    }
    
    //Assignment 5 Part 2
    
    /**
     * Finds the index of a passed value in a passed array using the binary search algorithm
     * 
     * @param array the array to look through
     * @param value the value being searched for
     * @return the index of <code>value</code> in <code>array</code> or -1 if not found 
     */
    public static int binarySearch(int[] array, int value) {
    	//based on value, the indices to search through will change; start with all the indices of the array
    	int first = 0;
    	int last = array.length - 1;
    	
    	//it has to iterate until it has found value or can't split anymore so construct while loop
    	while(first <= last) {
    		
    		//calculate the middle index
    		int middleIndex = (first + last) / 2;
    		
    		//if the element of the middle index is smaller, need to look through
    		//"second" array so reassign the value of first (first index of "second" array)
    		if(array[middleIndex] < value)
    			first = middleIndex + 1;
    		
    		//if the element of the middle index is greater, need to look through
    		//"first" array so reassign the value of last (last index of "second" array)
    		else if(array[middleIndex] > value)
    			last = middleIndex - 1;
    		
    		//if the value is neither less than nor greater than the element of 
    		//the middle index, the middle index contains value therefore return middleIndex
    		else
    			return middleIndex;
    	}
    	return -1;
    }
    
    /**
     * Populates <code>array</code> with random values.
     * 
     * @param array to populate with values from min to max inclusively.
     * @param min the smallest random value to use
     * @param max the largest random value to use
     */
    static void populate(int[] array, int min, int max) {
        // compute the magnitude of range of random values
        int rangeSize = max - min;

        // For every array element
        for (int i = 0; i < array.length; i++) {
            // Get random value (+1 to make it inclusive)
            int randomValue = (int) (Math.random() * (rangeSize + 1));

            // Make the start value start at the minimum value
            randomValue += min;

            // Set array element to this random value
            array[i] = randomValue;
        }
    }
    
    /**
     * Sorts the passed array using bubble sort
     * 
     * @param array the array being sorted
     */
    public static void bubbleSort(int[] array) {
    	//Start timer and sort
    	long startTime = System.nanoTime();
    	
        // Bubble n-1 times so that all highest values have migrated to their position
        for (int sortedCount = 0; sortedCount < array.length-1; sortedCount++) {
            // Compare current element to every other element
            for (int index = 0; index < array.length-1; index++) {
                // Swap if necessary            
                if (array[index+1] < array[index]) {
                    // Swap (maybe this would be good in it's own function!)
                    int temp = array[index+1];
                    array[index+1] = array[index];
                    array[index] = temp;

                    // Error: Erases the data before copy!
                    // array[index+1] = array[index];
                    // array[index] = array[index+1];

                }
            }
        }
        
        //End timer and print results
        long endTime = System.nanoTime();
        System.out.println("Processing time bubblesort: " + ((endTime - startTime)/(Math.pow(10, 6))) + " millisec");
    }
    
    /**
     * Sorts the passed array using java.util.Arrays.sort()
     * 
     * @param array the array being sorted
     */
    public static void javaUtilArraysSort(int[] array) {
    	//start timer and sort
    	long startTime = System.nanoTime();
        Arrays.sort(array);
        
        //end timer and print results
        long endTime = System.nanoTime();
        System.out.println("Processing time java.util.Arrays.sort(): " 
        		+ ((endTime - startTime)/(Math.pow(10, 6))) + " millisec");
    }
    
    /**
     * Use a basic linear search to try and find <code>key</code> in
     * <code>array</code>
     * 
     * @param array
     *            the array to search
     * @param key
     *            the item to search for
     * @return returns -1 if the value isn't found, otherwise the index of
     *         <code>key</code>
     */
    public static int linearSearch(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                return i;
            }
        }
        // You are not the keymaster!
        return -1;
    }
    
}
