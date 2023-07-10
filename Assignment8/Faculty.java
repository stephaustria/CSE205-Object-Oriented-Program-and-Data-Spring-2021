//Assignment: ASU CSE205 Spring 2021 #8
//Name: Stephen Austria 
//StudentID: 1220159551
//Lecture: T Th 1:30-2:45
//Description: This class implements the Serialization interface, and it created the Faculty Object.

import java.io.*;

public class Faculty implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private instance variables
	private String firstName, lastName, academicLevel;

	//constructor
	public Faculty(String firstName, String lastName, String academicLevel)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.academicLevel = academicLevel;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAcademicLevel() {
		return academicLevel;
	}

	//sets firstName to the specified string
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	//sets lastName to the specified string
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	//sets academicLevel to the specified string
	public void setAcademicLevel(String level) {
		academicLevel = level;
	}

	//return a string in the specified format
	public String toString() {
		return firstName + " " + lastName + ", " + academicLevel;
	}
}
