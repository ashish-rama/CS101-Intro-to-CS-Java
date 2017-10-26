package edu.nyu.cs101.assignment3;

/**
 * ASCII Program; Prints table of ASCII, binary, and hex values (Assignment 3 Part 3abc)
 * @author Ashish Ramachandran (ar3986)
 *
 */
public class ASCII {

	public final static int START_VALUE = 33;
	public final static int FINAL_VALUE = 126;
	public final static int ASCII_0_VALUE = 48;

	public static void main(String[] args) {
		System.out.println("char\t|\tASCII\t|\tBinary\t|\tHexidecimal");
		System.out.println("--------------------------------------------------------------");
		for(int i = START_VALUE; i <= FINAL_VALUE; i++)
			System.out.println((char) i + "\t|\t" + i + "\t|\t" + toBinary(i) + "\t|\t" + toHex(i));
	}

	/**
	 * Converts a passed integer to binary
	 * @param number a passed integer to be converted to binary
	 * @return	<code>number</code> in binary
	 */
	public static String toBinary(int number) {
		String convertedNumber = "";
		while(number > 0) {
			int bit = number % 2;
			number /= 2;
			convertedNumber = bit + convertedNumber; //adds the bit to the beginning of the String
		}
		return convertedNumber;
	}

	/**
	 * Converts an integer into a string that is the hexidecimal representation
	 * for that number prefixed with the characters '0x' to indicate a hexidecimal
	 * value.
	 * @param number  the number to convert to hexidecimal
	 * @return the decimal integer converted to a hexidecimal string representation
	 */
	public static String toHex(int number) {
		String convertedNumber = "";
		while(number > 0) {
			int value = number % 16;
			char hexDigit = decToHex(value);
			number /= 16;
			convertedNumber = hexDigit + convertedNumber;
		}
		return "0x" + convertedNumber;
	}

	/**
	 * Converts a decimal value of the range 0-15 into a single hexidecimal
	 * character.
	 * @param number  the number to convert to hexidecimal
	 * @return a single character representing the hexidecimal equivalent of the
	 * decimal number passed in.
	 */
	public static char decToHex(int number) {
		if(number == 10) return 'A';
		else if(number == 11) return 'B';
		else if(number == 12) return 'C';
		else if(number == 13) return 'D';
		else if(number == 14) return 'E';
		else if(number == 15) return 'F';
		else return (char) (ASCII_0_VALUE + number);
	}

}
