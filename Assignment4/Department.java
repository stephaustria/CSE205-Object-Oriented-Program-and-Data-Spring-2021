
public class Department {

	private String departName;
	private int numberOfMembers;
	private String university;
	private Faculty currentFaculty;
	
	public Department() {
		departName = "?";
		numberOfMembers = 0;
		university = "?";
		currentFaculty = new Faculty();
	}
	
	public String getDeptName() {
		return departName;
	}
	
	public int getNumberOfMembers() {
		return numberOfMembers;
	}
	
	public String getUniversity() {
		return university;
	}
	
	public Faculty getCurrentFaculty() {
		return currentFaculty;
	}
	
	public void setDeptName(String someName) {
		this.departName = someName;
	}
	
	public void setNumberOfMembers(int someNumber) {
		this.numberOfMembers = someNumber;
	}
	
	public void setUniversity(String someUniversity) {
		this.university = someUniversity;
	}
	
	public void setCurrentFaculty(String firstName, String lastName, String someLevel) {
		this.currentFaculty.setFirstName(firstName);
		this.currentFaculty.setLastName(lastName);
		this.currentFaculty.setAcademicLevel(someLevel);
		
	}
	
	public String toString() {
		return String.format("\nDepartment Name:\t\t%s\nNumber Of Members:\t%s\nUniversity:\t\t%s\nFaculty:\t\t%s\n\n", departName, numberOfMembers, university, currentFaculty);
	}
 }
