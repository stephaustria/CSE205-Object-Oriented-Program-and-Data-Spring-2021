// Assignment #: 2
//         Name: Stephen Austria
//    StudentID: 1220159551
//      Lecture: Tuesday and Thursday 1:30-2:45pm
//  Description: This class reads random numbers of integers and performs calculations on the inputted numbers and outputs the calculations.
import java.util.Scanner;

public class Assignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean num = true;
		int number;
		int evenNumber = 0;
		int oddNumber = 0;
		int sumOfNegative = 0;
		int maxNumber = -999;
		
		//Scanner
		Scanner scan = new Scanner(System.in);
		
		while (num) {
			//How to find the maximum integer
			number = scan.nextInt();
			if(number > maxNumber) {
				maxNumber = number;
			}
			
			//How to find the count of even integers
			if (number % 2 == 0) {
				evenNumber++;
			}
			
			//How to find the smallest odd integer
			if (oddNumber == 0) {
				if (number % 2 != 0) {
					oddNumber = number;
				}
			} else if (number % 2 != 0 && number < oddNumber) {
				oddNumber = number;
			}
			
			//How to find the sum of negative integers
			if (number < 0) {
				sumOfNegative = sumOfNegative + number;
			}
			
			if (number == 0) {
				num = false;
			}
			
			
		}
		
		//Outputs
		System.out.println("The maximum integer is " + maxNumber);
		System.out.println("The count of even integers in the sequence is " + evenNumber);
		System.out.println("The smallest odd integer in the sequence is " + oddNumber);
		System.out.println("The sum of negative integers is " + sumOfNegative);
	}
}
