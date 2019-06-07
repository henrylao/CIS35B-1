//============================================================================
// Project     : Lab5
// Name        : Helper301to400.java
// Author      : Tianqi Yang
// Time        : 5/29/2019
// IDE         : Eclipse
//Description : it is helper functions that fix error number from 301 to 400 
// that occurs in adapter package
//============================================================================
package exception;

import java.util.Scanner;

public class Helper301to400 {
	private Scanner reader;

	public String fix301() {//the object is empty
		System.exit(1);
		return null;
	}

	public String fix302() {//fail updateOptionSetName
		reader = new Scanner(System.in);
		System.out.print("Enter the correct optionSetname, newName: ");
		return reader.nextLine();
	}

	public String fix303() {//fail updateOptionPrice
		reader = new Scanner(System.in);
		System.out.print("Enter the optionName, Option, newPrice: ");
		return reader.nextLine();
	}
	
	public String fix304() {//cannot find the object
		return null;
	}
}
