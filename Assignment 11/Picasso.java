package edu.nyu.cs101.assignment11;

import peasy.PeasyCam;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * Picasso Program for graphical representation of recursion (Assignment 11 Part 2)
 * @author Ashish Ramachandran (ar3986)
 * Sources: (Image) http://magmax.deviantart.com/art/Space-Stars-4530213,
 * 			(Menger Sponge) http://en.wikipedia.org/wiki/Menger_sponge, Processing API website, (Sierpinski's triangle)
 * 			http://en.wikipedia.org/wiki/Sierpinski_triangle, inspiration https://www.youtube.com/watch?v=lkPUiJTPiTo, 
 * 			
 */
@SuppressWarnings("serial")
public class Picasso extends PApplet {

	private static final int NAME_TEXT_SIZE = 28, INFO_TEXT_SIZE = 16;
	private static final double[] CAMERA_ROTATIONS = { -0.5854199, 0.5717343, 0.002163941 };
	private static final double[] CAMERA_POSITIONS = { 200, 200, 200, 1000 };
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private static final int TEXT_X = 40, TEXT_Y = 40;
	private static final float START_X = 0, START_Y = 0, START_Z = 0, START_CUBE_LENGTH = 400;
	private static final int START_COUNTER = 0;
	public final float[] fill = { random(50), random(255), random(255), 100 };
	public static final int SIERPINSKI = 2, MENGER = 3;

	//create camera
	PeasyCam cam;

	//number of times of recursion (same thing as how many layers of the sponge or triangle needed)
	int depth = 3;

	//type of figure to create; 2 = Sierpinski's triangle mode, 3 = Menger sponge mode
	int shapeType = MENGER;

	PImage background = loadImage("space.jpg");

	//providing a main allows the project to be exported as an application
	public static void main(String[] args) {
		PApplet.main("Picasso");
	}


	public void setup() {
		size(WIDTH, HEIGHT, P3D);
		cam = new PeasyCam(this, CAMERA_POSITIONS[0], CAMERA_POSITIONS[1], CAMERA_POSITIONS[2], CAMERA_POSITIONS[3]);
		cam.setRotations(CAMERA_ROTATIONS[0], CAMERA_ROTATIONS[1], CAMERA_ROTATIONS[2]);
	}

	public void draw() {
		lights();
		background(background);
		fill(255);
		textSize(NAME_TEXT_SIZE);
		textAlign(CENTER);
		text("By: Ashish Ramachandran", width - 250, height - 150);
		cam.beginHUD();
		showStats();
		cam.endHUD();
		createRecursiveShape(START_X, START_Y, START_Z, START_CUBE_LENGTH, START_COUNTER, depth, shapeType);
	}

	/**
	 * Shows the FPS for debugging and the depth of the created shape
	 */
	public void showStats() {		
		textSize(INFO_TEXT_SIZE);
		textAlign(LEFT);
		fill(255);
		text("FPS: " + frameRate, TEXT_X, TEXT_Y); 
		text("DEPTH [UP/DOWN]: " + depth, TEXT_X, TEXT_Y + 15); 
	}

	/**
	 * Creates a recursive shape such as Sierpinski's triangle (numCubesPerAxis = 2) or a Menger sponge (numCubesPerAxis = 3)
	 * @param xPos starting x-position
	 * @param yPos starting y-position
	 * @param zPos starting z-position
	 * @param cubeSideLength starting cube side length
	 * @param recursionCount number of times recursed
	 * @param depthOfRecursion number of times needed to recurse to create object
	 * @param numCubesPerAxis number of cubes per x, y, or z axis
	 */
	public void createRecursiveShape(float xPos, float yPos, float zPos, float cubeSideLength, 
			int recursionCount, int depthOfRecursion, int numCubesPerAxis) {
		//increment the number of times of recursion (same thing as how many layers of the sponge or triangle needed)
		recursionCount++;

		//if reached the number of layers needed, then create a cube at that position and stop recursion
		if(recursionCount >= depthOfRecursion) {
			createCube(xPos, yPos, zPos, cubeSideLength);
		} 

		//if haven't reached desired number of layers, create new layer by:
		else {
			//divide face into three for a Menger Sponge so each face of each individual cube becomes a 3x3 square with 
			//		the middle removed recreated in 3D (numCubesPerAxis = 3)
			//divide face into two for Sierpinski's triangle so each "triangle" (created with 4 cubes; 3 cubes surrounding 
			//		a center one each sharing a side with 3 of 4 sides of the center cube) segment's length is halved
			//			(numCubesPerAxis = 2)

			cubeSideLength /= (float) numCubesPerAxis;

			//for each axis (for the way I am iterating, the shape is built out from the z-axis (coming toward the screen),
			//		then the y-axis (towards the right side of the applet), then the x-axis (towards the bottom of the applet))
			for(int x = 0; x < numCubesPerAxis; x++) {
				for(int y = 0; y < numCubesPerAxis; y++) {
					for(int z = 0; z < numCubesPerAxis; z++) {

						//if one of the following conditions, don't create cube at location and continue (ensures holes)
						if((x == 1 && y == 1) ||  (x == 1 && z == 1) || (y == 1 && z == 1)) 
							continue;

						//if needs another layer, call method again to break down further
						createRecursiveShape(xPos + cubeSideLength * x, yPos + cubeSideLength * y, zPos + cubeSideLength * z, 
								cubeSideLength, recursionCount, depthOfRecursion, numCubesPerAxis);
					}
				}
			}
		}
	}

	/**
	 * Creates a cube at a given location with given side length
	 * @param xPos x-position of cube
	 * @param yPos y-position of cube
	 * @param zPos z-position of cube
	 * @param cubeSideLength side length of cube
	 */
	public void createCube(float xPos, float yPos, float zPos, float cubeSideLength) {
		pushMatrix();
		translate(xPos, yPos, zPos);
		fill(150
				/*random(50), random(255), random(255), 100*/ //Hard to see the figure but if uncommented it looks cool
				/*fill[0], fill[1], fill[2], fill[3]*/ //This one looks cool too and less crazy than the one above
				); 
		stroke(random(50), random(255), random(255), 100);
		box(cubeSideLength);
		popMatrix();
	}

	public void keyReleased() {
		if(key == '1') 
			shapeType = SIERPINSKI; // Sierpinski's triangle mode
		if(key == '2') 
			shapeType = MENGER; // Menger sponge mode

		if(key == CODED) {
			if(keyCode == UP)
				depth++;
			if(keyCode == DOWN)
				depth--;
		}

		// Check depth is not lower than 1 and set depths limits
		if(depth < 1)
			depth = 1;

		if(shapeType == SIERPINSKI && depth > 7)
			depth = 7;
		if(shapeType == MENGER && depth > 4)
			depth = 4;
	}

}
