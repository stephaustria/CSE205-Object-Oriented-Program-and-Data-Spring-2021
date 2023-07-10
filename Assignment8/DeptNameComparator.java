//Assignment: ASU CSE205 Spring 2021 #8
//Name: Stephen Austria
//StudentID: 1220159551
//Lecture: T Th 1:30-2:45
//Description: The name of the Deprtment's are in listed in alphabetical order.

import java.util.*;

public class DeptNameComparator implements Comparator<Department> {
	//Overrides Abstract Method
	public int compare(Department first, Department second) {
		// Instantiated variables
		int search = 0;
		String firstDepartment = first.getDeptName();
		String secondDepartment = second.getDeptName();
		// second argument > first argument
		if (firstDepartment.compareTo(secondDepartment) < 0) {
				search = -1;
		// first argument> second argument	
		} else if (firstDepartment.compareTo(secondDepartment) > 0) {
			search = 1;
		// if the first and second argument are the same
		} else if (firstDepartment.compareTo(secondDepartment) == 0) {
			search = 0;
		}
		
		return search;
	}
}	
