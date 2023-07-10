//Assignment: ASU CSE205 Spring 2021 #8
//Name: Stephen Austria
//StudentID: 1220159551
//Lecture: T Th 1:30-2:45
//Description: The Department's currentFaculty is listed in alphabetical order of their names

import java.util.Comparator;

public class DeptFacultyComparator implements Comparator<Department>
{	//Overrides abstract method
	public int compare(Department first, Department second)
	{	//Variables instantiated
		int search = 0;
		String facultyFirstName1 = first.getFaculty().getFirstName();
		String facultyFirstName2 = second.getFaculty().getFirstName();
		String facultyLastName1 = first.getFaculty().getLastName();
		String facultyLastName2 = second.getFaculty().getLastName();
		// first argument < second argument
		if (facultyLastName1.compareTo(facultyLastName2) < 0) {
			search = -1;
		} // first argument > second argument
		if (facultyLastName1.compareTo(facultyLastName2) > 0) {
			search = 1;
		} // compares first names if last names are the same
		if (facultyLastName1.compareTo(facultyLastName2) == 0) {
			if (facultyFirstName1.compareTo(facultyFirstName2) < 0) {
				search = -1;
			}
			if (facultyFirstName1.compareTo(facultyFirstName2) > 0) {
				search = 1;
			} // if they have the same name
			if (facultyFirstName1.compareTo(facultyFirstName2) == 0) {
				search = 0;
			}
		}
		return search;
	}
}
