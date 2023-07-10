import java.text.DecimalFormat;

public class UnderGrad extends Student{

	private boolean inState;
	private int creditUpperbound;
	private double programFee;
	
	// Overloaded Constructor 
	public UnderGrad(String fName, String lName, String id, int credits, double rate, boolean inState, double programFee) {
		super(fName, lName, id, credits,rate);
		this.inState = inState;
		this.programFee = programFee;
		if(inState)
			this.creditUpperbound = 7;
		else
			this.creditUpperbound = 12;
	}
	
	// Computation for Tuition
	public void computeTuition() {
	 	if(numCredit >= creditUpperbound)
			tuition = rate * creditUpperbound + programFee;
		else
			tuition = rate * numCredit + programFee;
	}
	
	// TO String for UnderGrad
	public String toString() {
		DecimalFormat cash = new DecimalFormat("$##,##0.00");
		String state;
		if (inState) 
			state = "\nIn-State";
		else
			state = "\nOut-Of-State";
		return "\nUnderGrad:" + state + "\nFirst name:\t\t" + firstName + "\nLast name:\t\t" + lastName + "\nStudent ID:\t\t" + studentID + "\nCredits:\t\t" + numCredit + "\nRate:\t\t\t" + cash.format(rate) + "\nTuition:\t\t" + cash.format(tuition) + "\nStudent Program Fee:\t" + cash.format(programFee) + '\n';
	}

}
