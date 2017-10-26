package edu.nyu.cs101.assignment8;

/**
 * Course Class to create new Course objects (Assignment 8 Part 2)
 * @author Ashish Ramachandran (ar3986)
 */
public class Course {

	private String name;
	private int credits;
	private float grade;
	
	/**
	 * Creates a new Course object
	 * @param name the name of the course
	 * @param credits the amount of credits for the course
	 * @param grade the grade in the course
	 */
	public Course(String name, int credits, float grade) {
		this.name = name;
		this.credits = credits;
		this.grade = grade;
	}
	
	/**
	 * Gets the name of the course
	 * @return the name of the course
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the amount of credits of the course
	 * @return the number of credits of the course
	 */
	public int getCredits() {
		return credits;
	}
	
	/**
	 * Gets the grade in the course
	 * @return the grade in the course
	 */
	public float getGrade() {
		return grade;
	}
	
	/**
	 * Set the name of the course
	 * @param name the new name of the course
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Set the amount of credits of the course
	 * @param credits the new amount of credits of the course
	 */
	public void setCredits(int credits) {
		this.credits = credits;
	}
	
	/**
	 * Set the grade in the course
	 * @param grade the new grade of the course
	 */
	public void setGrade(float grade) {
		this.grade = grade;
	}
	
	/**
	 * @return String representation of the Course including name, number of credits, and grade in the course
	 */
	public String toString() {
		return "Course name: " + name + ", credits: " + credits + ", grade: " + grade;
	}
	
	/**
	 * Checks if two courses are equal to each other by comparing the properties of the course
	 * @param course the course being compared to the current course
	 * @return true if all of the attributes of the two courses are the same
	 */
	public boolean equals(Course course) {
		if(this.name.equals(course.name) && this.credits == course.credits && this.grade == course.grade)
			return true;
		return false;
	}
}
