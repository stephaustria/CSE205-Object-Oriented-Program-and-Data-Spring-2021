//Assignment: ASU CSE205 Spring 2021 #8
//Name: Stephen Austria
//StudentID: 1220159551
//Lecture: T Th 1:30-2:45
//Description: This class is where all the methods are to manage the Department objects.

import java.io.*;
import java.util.*;
//import all other necessary classes

public class DeptManagement implements Serializable //implements interface
{
	ArrayList<Department> deptList;
	private static final long serialVersionUID = 1L; //initializes serialVersionUID

	//Constructor
	public DeptManagement() {
		deptList = new ArrayList<Department>();
	}
	//Checks if a Department Exists
	public int deptExists(String deptName, String universityName) {
		int num = -1;
		int a = 1;
		while(a <= deptList.size()) {
			if(deptList.get(a - 1).getUniversity().equals(universityName) && deptName.equals(deptList.get(a-1).getDeptName())) {
				num = a - 1;
			}
			a++;
		}
		
		return num;
	}
	//Checks if Faculty Member exists
	public int facultyExists(String firstName, String lastName, String academicLevel) {
		int numOfFac = -1;
		String faculty = firstName + " " + lastName + ", " + academicLevel;
		
		int a = 1;
		while(a <= deptList.size()) {
			if(faculty.equals(deptList.get(a - 1).getFaculty().toString())) {
				numOfFac = a -1;
			}
			a++;
		}
		
		return numOfFac;
	}
	//Method adds a department
	public boolean addDepartment(String deptName, String university, int numOfMembers, String firstName, String lastName, String academicLevel) {
		
		boolean k = true;
		int a = 0;
		while(a < deptList.size()) {
			if(deptList.get(a).getDeptName().equals(deptName) && deptList.get(a).getUniversity().equals(university)) {
				
				k = false;
			}
			a++;
		}
		if(k == true) {
			Department depart = new Department(deptName, university, numOfMembers, firstName, lastName, academicLevel);
			deptList.add(depart);
		}
		return k;
		
	}

	//Will Remove Departments
	public boolean removeDepartment(String deptName, String universityName) {
		
		boolean r = false;
		int a = 0;
		while(a < deptList.size()) {
			if(deptList.get(a).getDeptName().equals(deptName) && deptList.get(a).getUniversity().equals(universityName)) {
				r = true;
				deptList.remove(a);
			}
			a++;
		}
		return r;
		
	}
	//The methods sort the Department Name, Faculty Numbers, Department Faculty
	public void sortByDepartmentName() {
		Collections.sort(deptList, new DeptNameComparator());
	}

	public void sortByFacultyNumbers() {
		Collections.sort(deptList, new FacultyNumberComparator());
	}

	public void sortByDeptFaculty() {
		Collections.sort(deptList, new DeptFacultyComparator());
	}
	//Lists the Departments
	public String listDepartments() {
		String departmentList = "\n";
		
	    if (deptList.isEmpty()) {
	    	
            return "\nNo Department\n\n";
            
	    } else {
	    	int a = 1;
	    	while(a <= deptList.size()) {
	    		departmentList = departmentList + deptList.get(a - 1).toString().replace("[", "").replace("]", "");
	    		a++;
	    	}
          departmentList = departmentList + "\n";
          return departmentList;
	    }
	}
	    

	public void closeDeptManagement() {
		deptList.clear();
	}
}