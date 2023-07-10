import java.text.DecimalFormat;

public class Graduate extends Student {

	private double gradFee;
	
	// Overloaded Constructor
	public Graduate(String fName, String lName, String id, int credits, double rate, double gradFee) {
		super(fName, lName, id, credits, rate);
		this.gradFee = gradFee;
	}
	
	// Tuition computation
	public void computeTuition() {
		tuition = (rate * numCredit + gradFee);
	}
	
	// To String for Graduate
	public String toString() {
		DecimalFormat cash = new DecimalFormat("$##,##0.00");
		return "\nGraduate Student:" + "\nFirst name:\t\t" + firstName + "\nLast name:\t\t" + lastName + "\nStudent ID:\t\t" + studentID + "\nCredits:\t\t" + numCredit + "\nRate:\t\t\t" + cash.format(rate) + "\nTuition:\t\t" + cash.format(tuition) + "\nGrad Fee:\t\t" + cash.format(gradFee) + '\n';
	}
  
}
