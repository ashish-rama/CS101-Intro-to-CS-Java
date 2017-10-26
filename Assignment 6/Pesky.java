package edu.nyu.cs101.assignment6;

import java.util.Arrays;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Pesky Tourist Program using Median Filter Technique (Assignment 6 Part 2)
 * @author Ashish Ramachandran (ar3986)
 *
 */
@SuppressWarnings("serial")
public class Pesky extends PApplet {
	
	public static final int NUM_PICS = 9;
	public PImage[] images = new PImage[NUM_PICS];
	public PImage finalImage = loadImage("image1.png");
	
	public void setup() {
		//adds images we are working with to array
		populatePImageArray(images);
		
		//create array of NUM_PICS elements used to compare the same pixel across all PNGs
		int[] pixelsToCompare = new int[NUM_PICS];
		
		//for each pixel of the final image
		for(int pixel = 0; pixel < finalImage.pixels.length; pixel++) {
			
			//add same pixel from all images to elements of pixelsToCompare
			for(int i = 0; i < pixelsToCompare.length; i++)
				pixelsToCompare[i] = images[i].pixels[pixel];
			
			//find the median pixel in pixelsToCompare and assign to the pixel of final image
			finalImage.pixels[pixel] = median(pixelsToCompare);
		}
		
		//set the size of PApplet; update the pixels, display, and save final image
		size(finalImage.width, finalImage.height);
		finalImage.updatePixels();
		image(finalImage, 0, 0);
		save("result.png");
	}
	
	/**
	 * Populates an array of PImages given that there are PNGs with names "image" + (image number)
	 * @param array the array to be populated
	 */
	public void populatePImageArray(PImage[] array) {
		for(int i = 0; i < array.length; i++) {
			array[i] = loadImage("image" + (i+1) + ".png");
		}
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
     * @param array the array to analyze
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

}
