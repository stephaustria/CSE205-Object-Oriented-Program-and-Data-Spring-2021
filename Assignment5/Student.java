import java.text.DecimalFormat;

public abstract class Student {
	
	protected String firstName;
	protected String lastName;
	protected String studentID;
	protected int numCredit;
	protected double rate;
	protected double tuition;
	
	// Overloaded Constructor
	public Student(String fName, String lName, String id, int credits, double rate) {
		this.firstName = fName;
		this.lastName = lName;
		this.studentID = id;
		this.numCredit = credits;
		this.rate = rate;
		this.tuition = 0.0;
	}
	
	// Get Number of Credit Method
	public int getNumCredit() {
		return numCredit;
	}
	
	// Abstract method
	public abstract void computeTuition();
	
	// To String for Student
	public String toString() {
		DecimalFormat cash = new DecimalFormat("$##,##0.00");
		return "\nFirst name:\t\t" + firstName + "\nLast name:\t\t" + lastName + "\nStudent ID:\t\t" + studentID + "\nCredits:\t\t" + numCredit + "\nRate:\t\t\t" + cash.format(rate) + "\nTuition:\t\t\t" + cash.format(tuition) + '\n';
	}
	
	}

