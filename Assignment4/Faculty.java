
public class Faculty {

	private String firstName;
	private String lastName;
	private String academicLevel;
	
	public Faculty() {
		firstName = "?";
		lastName = "?";
		academicLevel = "?";
	}
	
	public String getFirstname() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getAcademicLevel() {
		return academicLevel;
	}
	
	public void setFirstName(String someFirstName) {
		this.firstName = someFirstName;
	}
	
	public void setLastName(String someLastName) {
		this.lastName = someLastName;	
	}
	
	public void setAcademicLevel(String someLevel) {
		this.academicLevel = someLevel;
	}
	
	public String toString() {
		return String.format("%s,%s(%s)", lastName, firstName, academicLevel);
			
	}
}
