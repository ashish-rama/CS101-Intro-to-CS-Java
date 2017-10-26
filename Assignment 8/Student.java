package edu.nyu.cs101.assignment8;

import java.util.ArrayList;

/**
 * Student Class to create new Student objects (Assignment 8 Part 3)
 * @author Ashish Ramachandran (ar3986)
 */
public class Student {

	private String name;
	private long studentID;
	public ArrayList<Course> courses;
	
	/**
	 * Constructs new Student object
	 * @param name name of student
	 * @param studentID student's id number
	 * @param courses ArrayList of courses the student is taking
	 */
	public Student(String name, long studentID, ArrayList<Course> courses) {
		this.name = name;
		this.studentID = studentID;
		this.courses = courses;
	}
	
	 /**
	  * Adds a course to the student's schedule
	  * @param course the course to add
	  */
	public void addCourse(Course course) {
		courses.add(course);
	}
	
	/**
	 * Deletes a course from the student's schedule
	 * @param course the course to delete
	 */
	public void delCourse(Course course) {
		for(int i = 0; i < courses.size(); i++) {
			if(courses.get(i).equals(course)) {
				courses.remove(i);
			}
		}
	}
	
	/**
	 * Calculates student's cumulative GPA
	 * @return student's cumulative GPA
	 */
	public float getGPA() {
		float totalGrade = 0;
		int totalCredits = 0;
		for(Course course : courses) {
			totalGrade += course.getCredits() * course.getGrade();
			totalCredits += course.getCredits();
		}
		return totalGrade / totalCredits;
	}
	
	/**
	 * @return String representation of Student including name, ID, courses, and cumulative GPA
	 */
	public String toString() {
		String allDetails = "Student name: " + name + " | studentID: " + studentID + " | Courses: ";
		for(int i = 0; i < courses.size(); i++) {
			allDetails += courses.get(i).getName() + (i != courses.size() - 1 ? ", " : "");
		}
		allDetails += " | Cummulative GPA: " + getGPA();
		return allDetails;
	}
}
