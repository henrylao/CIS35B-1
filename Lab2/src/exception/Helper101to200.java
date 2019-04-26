//============================================================================
//Project     : Lab2
//Name        : Helper101to200.java
//Author      : Tianqi Yang
//Time        : 4/18/2019
//IDE         : Eclipse
//Description : it is helper functions that fix error number from 101 to 200 
// that occurs in util package
//============================================================================
package exception;

import java.util.Scanner;

public class Helper101to200 {
	
	private Scanner reader;

	public String fix101() {//cannot open file
		reader = new Scanner(System.in);
		System.out.print("Enter the correct file name: ");
		return reader.nextLine();
	}
	public String fix102() {//Not enough optionSet
		
		return "";
	}
}
