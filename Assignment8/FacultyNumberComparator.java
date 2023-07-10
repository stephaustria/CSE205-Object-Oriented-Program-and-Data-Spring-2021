//Assignment: ASU CSE205 Spring 2021 #8
//Name: Stephen Austria
//StudentID: 1220159551
//Lecture: T Th 1:30-2:45
//Description: The number faculties are listed smallest to largest.

import java.util.*;

public class FacultyNumberComparator implements Comparator<Department> {
	//Overrides abstract method
	public int compare(Department first, Department second) {
		//Variables instantiated
		int search = 0;
		int numberOfFacFirst = first.getNumOfMembers();
		int numberOfFacSecond = second.getNumOfMembers();
		
		// more faculty in the second department
		if (numberOfFacSecond > numberOfFacFirst) {
			search = -1;
		// more faculty in the first department	
		} else if (numberOfFacSecond < numberOfFacFirst) {
			search = 1;
		// same amount of faculty in both departments	
		} else if (numberOfFacSecond == numberOfFacFirst) {
			search = 0;
		}
		return search;
	}
}
