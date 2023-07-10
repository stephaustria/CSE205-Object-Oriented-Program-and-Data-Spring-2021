
//  Assignment: ASU CSE205 Spring 2021 #9
//  Name: Stephen Austria
//  StudentID: 1220159551
//  Lecture: T Th 1:30-2:45
//  Description: The Assignment 9 class reads a sequence of integers from input,
//  and compute the maximum, counts numbers divisible by 3, sum of numbers larger than the last, and
//  compute the largest even integer in the sequence using recursion.

import java.io.*;

public class Assignment9 {
	public static void main(String[] args) {

		// Declare integers and int array to store information
		int num, even, max, count, sum, i = 0;
		int[] numbers = new int[100];
		
		
		// Try-Catch block for input stream and buffered reader io exceptions
		try {

			// Create an input stream reader and buffered reader object
			BufferedReader bR = new BufferedReader(new InputStreamReader(System.in));
			
			// while or do-While loop to store all integers in the array until 0
   			// read in the number as a string and parse to an integer and assign it to array element
		       // Continue iterating until 0 is entered
            int integers = 1;
			while(integers != 0) {
				String read = bR.readLine();
				integers = Integer.parseInt(read);
				numbers[i] = integers;
				if(numbers[i] != 0) {
					i++;
				}
				
			}
			

		} //end of try block

		// Catch an IO Exception and print out it occured
		catch(IOException ex) {
			System.out.println("IO Exception");
		}
         
		// Call recursive functions to calculate min, countOdd, largeEven, and sum
		max = findMax(numbers, 0, i);
		even = largestEven(numbers, 0, i);
		count = countDivisibleBy3(numbers, 0, i);
		sum = sumLargerThanLast(numbers, 0, i, numbers[i - 1]);
		
		// Print out results in required format
		
		System.out.println("The maximum number is " + max);
		System.out.println("The largest even integer in the sequence is " + even);
		System.out.println("The count of numbers divisible by 3 is " + count);
		System.out.println("The sum of numbers larger than the last is " + sum);
		



	}	// End main method

	// Recursive static method to find maximum array value
	public static int findMax(int[] nums, int startIndex, int endIndex) {
		
		if (startIndex == endIndex - 1) {
			return nums[startIndex];
		} else {
			
			//calling recursive method
			int numMax = findMax(nums, startIndex + 1, endIndex);
			
			//finds the highest number in the array
			if (numMax > nums[startIndex]) {
				return numMax;
			} else {
				return nums[startIndex];
			}
		}
		

	}	// End findMax method

	
	// Recursive static method to find the largest even number in the array
        public static int largestEven(int[] nums, int startIndex, int endIndex) {
        	
        	int maxEven = -1000000000;
        	if(startIndex == endIndex) {
        		return nums[startIndex];
        	}
        		// calling recursive method
        		int largeEven = largestEven(nums, startIndex + 1, endIndex);
        		
        		//checks which numbers are even
        		if(nums[startIndex] % 2 == 0) {
        			maxEven = nums[startIndex];
        		}
        		
        		//finds highest even number
        		if(maxEven < largeEven && largeEven % 2 == 0 && largeEven!= 0) {
        				maxEven = largeEven;
        			}
            			
        		return maxEven;
        			

	}	// End computeLargestEven method


	public static int countDivisibleBy3(int[] nums, int startIndex, int endIndex)
	{
		if (startIndex == endIndex) {
			
			//checks if number is divisible by 3
			if (nums[endIndex] % 3 == 0) {
				int countBy3 = 0;
				return countBy3;
			} else {
				int countBy3 = -1;
				return countBy3;
			}
		} else {
			
			// calling recursive method
			int countBy3 = countDivisibleBy3(nums, startIndex, endIndex - 1);
			
			//adds to counter if it is divisible by 3
			if (nums[endIndex] % 3 == 0) {
				return countBy3 + 1;
			} else {
				return countBy3;
			}
				
		}

		
	} //end countDivisibleBy3
	  
	// Recursive static method to find the sum of all numbers larger than the last number in the array
	public static int sumLargerThanLast(int[] nums, int startIndex, int endIndex, int lastNumber) {
		
		// nitialize the lastNumber
		lastNumber = nums[endIndex - 1];
		if(startIndex == endIndex - 1) {
			return 0;
		} else {
			
			//calling recursive method
			int sumOfNum = sumLargerThanLast(nums, startIndex + 1, endIndex, lastNumber);
			if(lastNumber < nums[startIndex]) {
				
				//adds to sum if a number is larger than the last element in the array
				return sumOfNum += nums[startIndex];
			}
			
			return sumOfNum;
		}
	

	}	// End sumOfNumbersLargerThanFirst method
}//end Assignment9 class