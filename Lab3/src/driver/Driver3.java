//============================================================================
// Project     : Lab3
// Name        : Driver3.java
// Author      : Tianqi Yang
// Time        : 5/9/2019
// IDE         : Eclipse
// Description : It is the thrid driver of the project
//============================================================================
package driver;

import adapter.BuildAuto;
import adapter.CreateAuto;
import adapter.UpdateAuto;

public class Driver3 {
	public static void main(String[] args) {	
		CreateAuto a1 = new BuildAuto();
		a1.BuildAuto("Car1.txt");
		a1.printAuto("FordZTW"); 
//		UpdateAuto b1 = new BuildAuto();
//		b1.updateOptionSetName("FordZTW", "Color", "Deceptive Appearance");
//		b1.updateOptionPrice("FordZTW", "Transmission", "Automatic", 999);
//		a1.printAuto("FordZTW"); 
//		CreateAuto a2 = new BuildAuto();
//		a2.BuildAuto("Car2.txt");
//		a2.printAuto("Tesla Model 3"); 
		a1.setOptionChoice("Ford","transmission",​ ​"standard");
	}
}