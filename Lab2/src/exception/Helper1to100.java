//============================================================================
// Project     : Lab2
// Name        : Helper1to100.java
// Author      : Tianqi Yang
// Time        : 4/18/2019
// IDE         : Eclipse
// Description : the helper that fix the exception code from 1 to 100
//============================================================================
package exception;
import java.util.Scanner;
public class Helper1to100 {
	public String fix1() {
		Scanner reader = new Scanner(System.in);
		System.out.print("Enter the file name: ");
		String filename = reader.nextLine();
		return filename;
	}
}