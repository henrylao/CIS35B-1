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
import adapter.Choice;
import adapter.UpdateAuto;

public class Driver3 {
	public static void main(String[] args) {	
		CreateAuto a1 = new BuildAuto();
		a1.BuildAuto("Car1.txt");
		a1.printAuto("ZTW"); 
		UpdateAuto b1 = new BuildAuto();
		b1.updateOptionSetName("ZTW", "Color", "Deceptive Appearance");
		b1.updateOptionPrice("ZTW", "Transmission", "Automatic", 999);
		a1.printAuto("ZTW"); 
		CreateAuto a2 = new BuildAuto();
		a2.BuildAuto("Car2.txt");
		a2.printAuto("Model 3"); 
		//testing make choice
		Choice c1 = new BuildAuto();
		c1.setOptionChoice("ZTW", "Color", "Fort Knox Gold Clearcoat Metallic");
		c1.setOptionChoice("ZTW","Transmission","Automatic");
		c1.setOptionChoice("ZTW", "Brakes/Traction Control", "ABS with Advance Trac");
		c1.setOptionChoice("ZTW", "Side Impact Air Bags", "Present");
		c1.setOptionChoice("ZTW", "Power Moonroof", "Present");
		c1.printChoices("ZTW");
		//testing get total price
		System.out.print("Total price: ");
		System.out.println(c1.getTotal("ZTW"));
	}
}