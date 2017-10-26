package edu.nyu.cs101.assignment6;


import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * Brick Break Game (Assignment 6 Part 1)
 * @author Ashish Ramachandran (ar3986)
 *
 */
@SuppressWarnings("serial")
public class Basics extends PApplet {
	//instance variables
	private static final int WINDOW_WIDTH = 800;
	private static final int WINDOW_HEIGHT = 600;
	private static final int NUM_BRICKS = 14;
	private static final int BRICK_WIDTH = 80;
	private static final int BRICK_HEIGHT = 30;
	private static final int BRICK_RADIUS = 4;
	private static final int PADDLE_WIDTH = 150;
	private static final int PADDLE_HEIGHT = 30;
	private static final int PADDLE_RADIUS = 10;
	private static final int BALL_RADIUS = 8;
	public static final int BALL_SPEED = 5;
	PImage background = loadImage("blueBackground.jpg");
	PImage startImage = loadImage("StartImage.png");
	PImage congrats = loadImage("congrats.png");
	Ball ball;
	Brick[] bricks = new Brick[NUM_BRICKS];
	int paddleCenterYLocation;
	int paddleTopCenterLocation;
	int hitBricks;

	boolean startScreen = true;
	boolean firstToss = true;
	
	// create audio player using minim library
	Minim minim;
	AudioPlayer player;

	@Override
	public void setup() {
		size(WINDOW_WIDTH, WINDOW_HEIGHT);
		image(background, 0, 0);
		rectMode(CORNER);
		fill(255, 140, 0);
		populate(bricks);
		hitBricks = 0;
		paddleCenterYLocation = height - 80;
		paddleTopCenterLocation = paddleCenterYLocation - PADDLE_HEIGHT / 2;
		showStartScreen();
		
		//play music
		minim = new Minim(this);
		player = minim.loadFile("brickSong.mp3", 1024);
		player.play();
	}

	@Override
	public void draw() {
		//if not on start screen, draw
		if(!startScreen) {
			image(background, 0, 0);
			rectMode(CORNER);
			
			//add all the bricks
			for(int i = 0; i < bricks.length; i++) {
				if(bricks[i] != null) {
					rect(bricks[i].x, bricks[i].y, bricks[i].width, bricks[i].height, BRICK_RADIUS);
					if(bricks[i].containsBall(ball)) {
						bricks[i] = null;
						System.out.println("turned null, " + i);
						ball.reverseY();
						hitBricks++;
					}
				}
			}
			
			//create the paddle
			rectMode(CENTER);
			rect(mouseX, paddleCenterYLocation, PADDLE_WIDTH, PADDLE_HEIGHT, PADDLE_RADIUS);
			
			//create the ball
			ellipse(ball.x, ball.y, 2 * ball.radius, 2 * ball.radius);
			
			//set the boundaries
			if ((ball.ballLeft() < 0) || (ball.ballRight() > width))
				ball.reverseX();
			if ((ball.ballTop() < 0))
				ball.reverseY();
			if((ball.ballBottom() == paddleTopCenterLocation) //within y bounds
					&& (ball.ballLeft() >= mouseX - PADDLE_WIDTH/2 
					&& ball.ballRight() <= mouseX + PADDLE_WIDTH/2)) { //within x bounds
				ball.reverseY();
			}
			if(ball.ballBottom() > paddleTopCenterLocation) {
				startScreen = true;
				showStartScreen();
			}
			
			//if you win!
			if(hitBricks == NUM_BRICKS) {
				image(congrats, width/ 2 - congrats.width / 2, height / 2 - congrats.height / 2);
				player.pause();
				player = minim.loadFile("congrats.mp3", 1024);
				player.play();
				noLoop();
			}
			
			ball.move();
		}
	}
	
	public void mouseClicked() {
		if(startScreen) {
			startScreen = !startScreen;
			if(ball.dY > 0)
				ball.reverseY();
			ball.reverseX();
		}
	}
	
	public void populate(Brick[] bricks) {
		//first row (x values increase by 160 (2*BRICK_WIDTH))
		bricks[0] = new Brick(40, 100, BRICK_WIDTH, BRICK_HEIGHT);
		bricks[1] = new Brick(200, 100, BRICK_WIDTH, BRICK_HEIGHT);
		bricks[2] = new Brick(360, 100, BRICK_WIDTH, BRICK_HEIGHT);
		bricks[3] = new Brick(520, 100, BRICK_WIDTH, BRICK_HEIGHT);
		bricks[4] = new Brick(680, 100, BRICK_WIDTH, BRICK_HEIGHT);
		
		//second row
		bricks[5] = new Brick(120, 200, BRICK_WIDTH, BRICK_HEIGHT);
		bricks[6] = new Brick(280, 200, BRICK_WIDTH, BRICK_HEIGHT);
		bricks[7] = new Brick(440, 200, BRICK_WIDTH, BRICK_HEIGHT);
		bricks[8] = new Brick(600, 200, BRICK_WIDTH, BRICK_HEIGHT);
		
		//third row
		bricks[9] = new Brick(40, 300, BRICK_WIDTH, BRICK_HEIGHT);
		bricks[10] = new Brick(200, 300, BRICK_WIDTH, BRICK_HEIGHT);
		bricks[11] = new Brick(360, 300, BRICK_WIDTH, BRICK_HEIGHT);
		bricks[12] = new Brick(520, 300, BRICK_WIDTH, BRICK_HEIGHT);
		bricks[13] = new Brick(680, 300, BRICK_WIDTH, BRICK_HEIGHT);
	}
	
	public void showStartScreen() {
		//background
		image(background, 0, 0);
		rectMode(CORNER);
		
		//make the bricks
		for(int i = 0; i < bricks.length; i++) {
			if(bricks[i] != null) {
				rect(bricks[i].x, bricks[i].y, bricks[i].width, bricks[i].height, BRICK_RADIUS);
			}
		}
		
		//make the paddle
		rectMode(CENTER);
		rect(mouseX, paddleCenterYLocation, PADDLE_WIDTH, PADDLE_HEIGHT, PADDLE_RADIUS);
		
		//if it isn't the first toss, the balls x position is based on the mouse
		if(firstToss) {
			ball = new Ball(30, paddleTopCenterLocation - BALL_RADIUS, BALL_RADIUS);
			firstToss = false;
		} else
			ball = new Ball(mouseX, paddleTopCenterLocation - BALL_RADIUS, BALL_RADIUS);
		
		//draw ball and information image
		ellipse(ball.x, ball.y, 2 * ball.radius, 2 * ball.radius);
		image(startImage, width / 2 - startImage.width / 2, height / 2 - startImage.height / 2);
	}
}
