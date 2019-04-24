//============================================================================
// Project     : Lab2
// Name        : Helper1to100.java
// Author      : Tianqi Yang
// Time        : 4/18/2019
// IDE         : Eclipse
//Description : it is helper functions that fix error number from 1 to 100 
// that occurs in model package
//============================================================================
package exception;

import java.util.Scanner;

public class Helper1to100 {

	private Scanner reader;

	public String fix1() {//fix first line
		reader = new Scanner(System.in);
		System.out.print("Enter the modelName, baseprice, and optionSet size: ");
		return reader.nextLine();
	}

	public String fix2() {//fix optionSet
		reader = new Scanner(System.in);
		System.out.print("Enter the optionSet name, optionSet size: ");
		return reader.nextLine();
	}

	public String fix3() {//fix option
		reader = new Scanner(System.in);
		System.out.print("Enter the option: ");
		return reader.nextLine();
	}

}