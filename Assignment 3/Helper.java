package edu.nyu.cs101.assignment3;

/**
 * A helper class that provides some extra functions that we'll use in
 * CSCI-UA101. This helper file can be included with other projects and then
 * called by using the syntax Helper.FUNCTION(...). e.g. "Helper.fibonaci(10);"
 * 
 * There is a corresponding Tester.java file that utilizes and tests these
 * functions.
 * 
 * TODO: Complete the javadocs by removing the TODO statments and adding: 1) a
 * description of each function 2) document param values using @param 3)
 * document return values using @return
 * 
 * TODO: Some code may be missing as well, complete the missing code blocks
 * TODO: Add your own @author information in the author tag below and update the
 * version number:
 * 
 * @author Harry Halfway <harry.halfway@null.edu>
 * @author Ashish Ramachandran <ar3986@nyu.edy>
 * @version 3.0
 * Assignment 3 Part 1 (Javadocs) 
 */
public class Helper {

    /**
     * Fibonacci series is the series starting with 0, 1 followed by the
     * addition of the previous two numbers. This function calculates the n'th
     * number where <code>n</code> starts with the 0th number which is 0.
     * 
     * @param n which fibonacci number to compute (0 indexed)
     * @return the <code>n</code>'th number in the fibonacci series, if the
     *         value of <code>n</code> is negative, it returns 0 by default.
     */
    public static int fibonacci(int n) {
        // fibonacci series is 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, ...
        int baseCase1 = 0;
        int baseCase2 = 1;
        int currentNumber = baseCase2;

        // First two number in fibonnaci are defined manually
        if (n <= 0)
            return baseCase1;
        if (n == 1)
            return baseCase2;

        // All other numbers are calculated
        for (int i = 2; i <= n; i++) {
            currentNumber = baseCase1 + baseCase2;
            baseCase1 = baseCase2;
            baseCase2 = currentNumber;
        }
        return currentNumber;
    }

    /**
     * Adds the first <code>n</code> items from the fibonacci series.
     * 
     * @param n number of items to sum
     * @return the sum of the first <code>n</code> items from the fibonacci series.
     */
    public static int fibonacciSum(int n) {
    	int total = 0;
    	for(int i = 0; i <= n; i++)
    		total += fibonacci(i);
        return total;
    }

    /**
     * Determines whether a passed integer is even or not
     * @param number
     * 				the number being evaluated
     * @return
     * 				returns <code>true</code> if passed value is even
     */
    public static boolean isEven(int number) {
        int remainder = number % 2;
        if (remainder == 0) {
            return true;
        }
        return false;
    }

    /**
     * Determines whether a passed integer is odd or not
     * @param number
     * 				the number being evaluated
     * @return
     * 				returns <code>true</code> if passed value is odd
     */
    public static boolean isOdd(int number) {
        return !isEven(number);
    }

    /**
     * Gets a standard roll of the die
     * 
     * @param sides
     *            is the number of sides on the die
     * @return the roll of that die (a random value from <code>1</code> to
     *         <codes>sides</code> inclusively)
     */
    public static int roll(int sides) {
        return (int) (Math.random() * sides) + 1;
    }

    /**
     * Simulates a weighted die (a die that will have one value rolled more than
     * the others). So a die that is weightedPercent is .05% means that the
     * chance of rolling the weightedSide starts at 5%, the other 95% of the
     * time it should be roughly equal for all the sides being rolled. So a 6
     * sided die would usually have an 16.666% chance of any side being rolled.
     * A weighted die with a 5% weight on the 6 side would have the following
     * distribution: side 1: 95% / 6 side 2: 95% / 6 side 3: 95% / 6 side 4: 95%
     * / 6 side 5: 95% / 6 side 6: 95% / 6 + 5%
     * 
     * @param sides
     *            is the number of sides on the die
     * @param weightSide
     *            the side which will be rolled most often
     * @param weightPercent
     *            the percentage of the time that the weightedSide should be
     *            rolled in addition to normal (value between 0.0 and 1.0)
     * @return the roll of that die (a random value from <code>1</code> to
     *         <codes>sides</code> inclusively)
     */
    public static int weightedRoll(int sides, int weightedSide, double weightedPercent) {
    	double random = Math.random(); //generates a random double (probability) between 0 and 1
    	for (int i = 0; i <= sides; i++) //goes through all sides (in order to check probabilities)
    		if (random < ((1 - weightedPercent) / sides) * i) //checks if random number is between interval
    			return i;										//then is side
    		else if (random > 1 - weightedPercent)				//if interval of 1 - weightedPercent
    			return weightedSide;							//return weightedSide
    	return 1;
    }

    /**
     * Prints a character <code>c</code> for <code>num</code> times
     * @param c the character wanted to be printed
     * @param num the number of times <code>c</code> should be printed
     */
    public static void printChars(char c, int num) {
        for (int i = 0; i < num; i++) {
            System.out.print(c);
        }
    }

    /**
     * Creates a progress bar by building a string that displays progress of <code>percentComplete</code>
     * and of size <code>size</code>
     * @param size the size of the progress bar
     * @param percentComplete the percent complete of the progress bar
     * @return the built progress bar as a string of size <code>size</code> and progress <code>percentComplete</code>
     */
    public static String getProgressBar(int size, double percentComplete) {
        // Implementation Note: A StringBuilder is probably a better way to go,
        // but those will be discussed later.

        // Print starting point
        String progressBar = "|";
        // Show current percentage
        for (int i = 0; i < size - 2; i++) { // -2 for starting and ending characters
            if (percentComplete > (float)i / (float)(size-2)) {
                // completed portion
                progressBar += "=";
            } else {
                // uncompleted portion
                progressBar += " ";
            }
        }
        // Print ending point
        progressBar += "|";
        return progressBar;
    }

    /**
     * Displays a progress bar to the user using <code>System.out</code>
     * 
     * @param size
     *            the width of the progress bar to print
     * @param percentComplete
     *            the percentage [0.0-1.0] of the bar that should be displayed
     *            as complete
     */
    public static void displayProgressBar(int size, double percentComplete) {
    	System.out.println(getProgressBar(size, percentComplete));
    }
}
