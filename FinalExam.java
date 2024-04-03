/*
 * Drason Truong ITSS 3311.0W1
 * Final Exam - 5/03/21
 * 
 * User will input integer array length and enter elements into array
 * Create a method largestGap() that finds the length of largest gap in input array
 * Create a method range() that will find the difference between smallest and largest value of the input array
 * Create a method numberOfDistinctElements() that will return the number of distinct elements in input array
 * Create a method distinctElements() that will return an array with the distinct elements
 * 
 * Note: Used online resource for printing array using array to string
 */
import java.util.Scanner;
import java.util.Arrays;
public class FinalExam {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		// creating the length of array
		System.out.println("Enter the length of the array:");
		int arrayLength = input.nextInt(); // == valArray.length
		int[] mainArray = new int[arrayLength]; 
		
		// inputting array values
		System.out.println("Enter the elements of the array:");
		int index = 0;
		while (index < arrayLength) {
			mainArray[index] = input.nextInt();
			index++;
		}
		
		// print results
		System.out.println("The largest gap in the array is " + largestGap(mainArray) + ".");
		System.out.println("The range of the array is " + range(mainArray) + ".");
		System.out.println("The number of distinct elements is " + numberOfDistinctElements(mainArray) + ".");
		System.out.println("The array of distinct elements is " + Arrays.toString(distinctElements(mainArray)));
		
	} // end of main method
	
	
	// method largestGap() 
	// reads in int array returns int
	// tells largest difference between two consecutive numbers
	public static int largestGap(int[] valArray) {
		int index = 1;
		int difference = 0;
		int gap = 0;
		
		while (index < valArray.length) { // loop to check every value of array
			difference = valArray[index] - valArray[index - 1]; // takes difference between two consecutive values
			if (valArray[index] < valArray[index - 1]) {
				difference = valArray[index -1] - valArray[index];
			}
			if (difference > gap) { // finds largest value of difference in array
				gap = difference;
			}
			index++;
		}
		return gap;
	}
	
	
	// method range() 
	// reads in int array returns int
	// tells difference between largest and smallest number
	public static int range(int[] valArray) {
		int max = valArray[0];
		int min = valArray[0];
		int index = 0;
		
		while(index < valArray.length) { // loop to iterate all values of array
			if(valArray[index] > max) {
				max = valArray[index]; // holds max value
			} else if (valArray[index] < min) {
				min = valArray[index]; // holds min value
			}
			index++;
		}
		int range = max - min; // finds range between min and max value
		return range;
	}
	
	
	// method numberOfDistinctElements()
	// reads in int array and returns int
	// counts number of distinct numbers in user submitted array
	public static int numberOfDistinctElements(int[] valArray) {
		int counter = 1;
		
		for (int index = 1; index < valArray.length; index++) { 
			int testPoint = 0;  
			for (testPoint = 0; testPoint < index; testPoint++) { // tests for duplicate values by checking if value has appeared before
				if(valArray[index] == valArray[testPoint]) { // if duplicate value exists, don't count
					break;
				}
			}
			if(index == testPoint) { // if given value is unique, counter will go up
				counter += 1; 
			}
		}
		return counter;
	}
	
	
	// method distinctElements
	// reads in int array and returns int array
	// creates an array of unique values from already declared array
	public static int[] distinctElements(int[] valArray) {
		int[] distinctArray = new int[numberOfDistinctElements(valArray)];
		int arrayRefVar = 0;
		
		for (int index = 0; index < valArray.length; index++) { // compares values
			boolean equal = false; 
			for (int j = 0; j < index; j++) {
				if(valArray[index] == valArray[j]) { // if duplicate values will not add to array
					equal = true;
					break; 	
				}
			}
			if (equal == false) { // if unique values, will be added to array
				distinctArray[arrayRefVar] = valArray[index]; 
				arrayRefVar++;
			}
		}
		return distinctArray;
	}
	

}
