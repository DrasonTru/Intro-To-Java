import java.util.Scanner;
import java.util.Random;

/*
 * Drason Truong ITSS 3311.0W1
 * Project 2
 * 3/24/2021
 * 
 * Description: Program will accept variable name and tell user if name follows standard naming conventions
 * Suggest a new variable name if name is more than one word, first character is invalid, contains invalid characters
 * Rule 1: Variable name must be one word
 * Rule 2: Starting character must be a letter, $ or _
 * Rule 3: Only valid characters are allowed in variable name (letters, numbers, $ or _)
 * if no valid characters, suggest a random letter name
 * 
 * Notes: used online resource for random letter generator
 * Unresolved bug: if user inputs ONE invalid character
 */


public class Project2 {

	public static void main(String[] args) {
		 
		Scanner input = new Scanner(System.in);
		
		// Declare and initialize string variable, read in user input
		System.out.println("This program will validate a variable name you can use in Java code.");
		System.out.println("Enter a variable name:");
		String name = input.nextLine();
		
		String nameRecommend = name; // name recommendation
		
		
		// Rule 1: Variable name must be one word
		String[] nameArray = nameRecommend.split(" ");
		nameRecommend = nameArray[0]; // name recommendation is one word
		
		
		// Rule 2: Starting character must be a letter, $ or _
		char first;
		int index = 0;
		first = nameRecommend.charAt(index);
		
		int initialCharAmount = nameRecommend.length(); // checks if string was shortened ie. first characters deleted
		boolean firstRemoved = false; // check if first letter was removed
		boolean needsAlter = false;
		
		int characterCheck = nameRecommend.length();
		
		while (index < nameRecommend.length()) { 
			
			if (Character.isLetter(first) || first == '$' || first == '_') { // if first char is valid, breaks out of loop
				index = nameRecommend.length(); 
			} else if (characterCheck > 1){ // if first letter is invalid
				nameRecommend = nameRecommend.substring(1); 
				first = nameRecommend.charAt(0);
				firstRemoved = true;
				characterCheck = nameRecommend.length();
			} 	
			if (characterCheck <= 1)
				index = nameRecommend.length();
				needsAlter = true;
		}
		
		
		// Rule 3: All characters in string must be valid
		for (index = 0; index < nameRecommend.length(); index++) {
			first = nameRecommend.charAt(index);
			
			if (Character.isLetter(first) || Character.isDigit(first) || first == '_') {
				continue;
			} else if (characterCheck > 1){ // if character at i is invalid create substring [0,i] and concatenate with rest of string [i+1]
				String nameHalf1, nameHalf2;
				nameHalf1 = nameRecommend.substring(0,index);
				nameHalf2 = nameRecommend.substring(index+1);
				nameRecommend = nameHalf1.concat(nameHalf2);
				index--; 
				characterCheck = nameRecommend.length();
			
			}
			if (characterCheck <= 1)
				index = nameRecommend.length();
				needsAlter = true;
		}
		
		
		// Suggest new name if no valid characters
		Random r = new Random();
		char letterRandom = (char)('a' + r.nextInt(26)); 
		
		// Error Messages
		if (firstRemoved == true) // Rule 1 
			System.out.println("The variable name should begin with an alphabetical character, underscore, or a dollar sign.");
		
		if (firstRemoved == false && initialCharAmount != nameRecommend.length()) // Rule 2 and Rule 3
			System.out.println("The variable name should have all alphabetical, numerical, or underscore characters after the first letter in the name.");
		
		if (name != nameArray[0] || initialCharAmount != nameRecommend.length() && characterCheck > 1) 
			System.out.println("The name you entered does not follow the naming convention rules. We suggest you use the following variable name \"" + nameRecommend + "\"");
		
		if (needsAlter == true && characterCheck <=1) // suggest new name if no valid characters
			System.out.println("The name you entered does not follow the naming convention rules. We suggest you use the following variable name \"" + letterRandom + "\"");
		
		if (name == nameRecommend) // nothing in string was changed
			System.out.println("The variable name \"" + name + "\" follows all the naming rules");
		
	}

}
