/* 
 * Drason Truong ITSS 3311.0W1
* Project 1
* 2/14/2021
* 
* Description: 
* Program will declare and initialize a variable, take user input for name and value, check if value is positive or negative
* Program will display results, display "if" and "else" statements
* 
*/

import java.util.Scanner;

public class Project1 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		
		// Declare and initialize variables by prompting user to input name and value
		System.out.println("Enter the variable name:");
		String variable = input.next();
		
		// Clear the scanner buffer
		input.nextLine();
		
		System.out.println("Enter a number:");
		double value = input.nextDouble();
		
		
		// Check if number is double or integer and display results
		
		// Value is an integer
		if ((int)value==value) {
		// Displays Results	
		System.out.println("int " + variable + " = " + (int)value +";");
		System.out.println("if(" + variable + " > 0) {");
		System.out.println("\tSystem.out.println(\"Positive.\");");
		System.out.println("}else{");
		System.out.println("\tSystem.out.println(\"Negative or Zero.\");");
		System.out.println("}");
		
		}
	
		
		// Value is a double
		if ((int)value<value) {
		// Displays Results
		System.out.println("double " + variable + " = " + value + ";");
		System.out.println("if(" + variable + " > 0) {");
		System.out.println("\tSystem.out.println(\"Positive.\");");
		System.out.println("}else{");
		System.out.println("\tSystem.out.println(\"Negative or Zero.\");");
		System.out.println("}");
		
		}

	}

}
