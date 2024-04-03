/*
 * Drason Truong ITSS 3311.0W1
 * Project 3
 * 4/14/2021
 * 
 * Create a program using multiple methods
 * 1. Boolean method "isPalindromic" will return True when the input integer is palindromic and False otherwise.
 * 2. a "display" method to print the elements of the palindrome array.
 * 3. a "sumOfSquares" method with two integer input arguments "i" and "j", and returns the square of both integers
 * Code should create and display all 11 palindromic numbers that can be written as the sum of consecutive squares. 
 * 
 * Array of numbers: 5 [1,2], 55 [1,5], 77 [4,6], 181 [9,10], 313 [12,13], 434 [11,13], 505 [2,11], 545 [16,17], 595 [6,12], 636 [4,12], 818 [2,13]
 */
public class Project3 {

	public static void main(String[] args) {
		
		// create an int[] array to hold 11 int values 
		int arrayList[] = new int [11]; // arrayList(new int []{x,y,z}); invoke the method
		
		int lower = 1; // upper and lower bounds can easily be changed
		int upper = 17; 
		int lowerBound = lower; // placeholder value to keep min and max the same
		int upperBound = upper;
		
		int number = 2;
		
		int index = 0;
		
		while (number < 1000) { // loop to iterate 2 to 1000
			
			if(isPalindromic(number)) { // if number is palindromic, will be checked for sum of consecutive squares
				
				while (lower <= upper) {
					
					int k = sumOfSquares(lower,upper); // now checking every combination of nums between 1-17
					upper -= 1; // move upper bound and keep lower the same
					
					if (lower == upper) { // if upper and lower bound are equal, upper is reset to max default value and lower bound is incremented by 1
						upper = upperBound;
						lower += 1;	
					}
					
					if (k == number) { // if number is a palindrome and sum of squares
						arrayList[index] = k;
						index++;
					}	
					
				}
				lower = lowerBound;
			}
			number++;
		}
		
		display(arrayList);
			
	} // end of main method


	// Boolean method "isPalindromic"
	// Input: int, Output: boolean
	public static boolean isPalindromic(int n) { // note: only works for 1-3 digit values
		String numberString = Integer.toString(n);
		boolean status = true;
		
		for (int i = 1; i < n; i++) {
			if (numberString.charAt(0) != numberString.charAt(numberString.length()-1)) {
				status = false;
				break;
			}
		}
		
		return status; // if palindromic return true, else return false
	}
		
	// "sumOfSquares" method with arguments "i" and "j" (min and max)
	// returns the sum of squares between [i,j]
	// Input: 2 int, Output: 1 int
	public static int sumOfSquares(int num1, int num2) { // num2 acts as upper bounds while num1 is changed
		int sum = 0;
		
		while (num1 <= num2) { // only works in (min,max) format
			int num1Squared;
			
			num1Squared = num1 * num1;
			sum += num1Squared;
			num1++;
		}
		return sum;
	}
		
		
	// "display" method to print array
	// Input: int [] array, Output: void
	public static void display(int[] valArray) {
		for (int index = 0; index < valArray.length; index++) {
			System.out.println(valArray[index]);
		}
	}
	
		
}