//============================================================================
 // Project     : Lab2
// Name        : Driver.java
// Author      : Tianqi Yang
// Time        : 4/18/2019
// IDE         : Eclipse
// Description : It is the driver of the project
//============================================================================
package driver;
import java.io.*;

import adapter.*;

public class Driver2 {
	public static void main(String[] args) {
		CreateAuto a1 = new BuildAuto();
		a1.BuildAuto("Car1.txt");
		a1.printAuto();
		UpdateAuto b1 = new BuildAuto();
		b1.updateOptionSetName("FordZTW", "Color", "Deceptive Appearance");
		b1.updateOptionPrice("FordZTW", "Transmission", "Automatic", 999);
		a1.printAuto();
	}
}