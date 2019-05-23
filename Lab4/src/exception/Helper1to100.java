//============================================================================
// Project     : Lab4
// Name        : Helper1to100.java
// Author      : Tianqi Yang
// Time        : 5/6/2019
// IDE         : Eclipse
// Description : it is helper functions that fix error number from 1 to 100 
// that occurs in util package
//============================================================================
package exception;

import java.util.Scanner;

public class Helper1to100 {

	private Scanner reader;


	public String fix1() {//cannot open file
		reader = new Scanner(System.in);
		System.out.print("Enter the correct file name: ");
		return reader.nextLine();
	}
	public String fix2() {//fix first line
		reader = new Scanner(System.in);
		System.out.print("Enter the modelmake, modelName, modelYear, baseprice: ");
		return reader.nextLine();
	}

	public String fix3() {//fix optionSet
		reader = new Scanner(System.in);
		System.out.print("Enter the optionSet name: ");
		return reader.nextLine();
	}

	public String fix4() {//fix option
		reader = new Scanner(System.in);
		System.out.print("Enter the option, option price: ");
		return reader.nextLine();
	}

}