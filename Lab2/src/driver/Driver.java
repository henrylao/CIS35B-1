//============================================================================
// Name        : Driver.java
// Author      : Tianqi Yang
// Time        : 4/10/2019
// IDE         : Eclipse
// Description : The program reads the data from a file and creates a 
// Automotive object. After that, it writes the object into a file. Finally, 
// it reads the object from the file.
//============================================================================
package driver;
import java.io.IOException;

import model.*;
import util.*;
public class Driver {
	public static void main(String[] args) throws IOException {
		String fileName = "FordZTW.txt";
		FileIO f = new FileIO();		
		//Build Automobile Object from a file.
		Automotive p = f.readFile(fileName);
		//Print attributes before serialization
		System.out.println(p.toString());
		//Serialize the object
		String objectFileName = "auto.dat";
		f.serializeAuto(p, objectFileName);
		System.out.println("Serialized the object...\n");
		//Deserialize the object and read it into memory.
		Automotive newFordZTW = f.deserializeAuto(objectFileName); 
		System.out.println("Deserialized the object...\n");
		//Print new attributes.
		System.out.println(newFordZTW.toString());
		/*
		//Testing
		//success sets
		//get functions
		System.out.println("----------------------------------------------");
		System.out.println("Get car name: ");
		System.out.println(p.getName());
		System.out.println("----------------------------------------------");
		System.out.println("get baseprice: ");
		System.out.println(p.getbaseprice());
		System.out.println("----------------------------------------------");
		System.out.println("get second optionSet:");
		System.out.println(p.getOptionSet(1));
		//find functions
		System.out.println("----------------------------------------------");
		System.out.println("find the index of set Color");
		System.out.println(p.findOptionSetByName("Color"));
		System.out.println("----------------------------------------------");
		System.out.println("find the index of Manual in the Transmission set:");
		System.out.println(p.findOptionByName("Transmission", "Manual"));
		System.out.println("----------------------------------------------");
		System.out.println("find the index of Manual in the second option set");
		System.out.println(p.findOptionByName(1, "Manual"));
		//delete option
		System.out.println("----------------------------------------------");
		System.out.println("delete second option in second option set:");
		System.out.println(p.deleteOption(1, 1));//delete optino by index
		System.out.println(p.getOptionSet(1));
		System.out.println("----------------------------------------------");
		System.out.println("delete Pitch Black Clearcoat option in Color option set:");
		System.out.println(p.deleteOption("Color", "Pitch Black Clearcoat"));
		System.out.println(p.getOptionSet(0));
		//update option functions
		System.out.println("----------------------------------------------");
		System.out.println("update the name of first option in the second option set:");
		System.out.println(p.updateOptionName(1, 0, "Manual"));
		System.out.println(p.getOptionSet(1));
		System.out.println("----------------------------------------------");
		System.out.println("update the price of first option in the second option set:");
		System.out.println(p.updateOptionPrice(1, 0, 810));
		System.out.println(p.getOptionSet(1));
		System.out.println("----------------------------------------------");
		System.out.println("update the name and price of first option in the second option set:");
		System.out.println(p.updateOptionValue(1, 0, "Automatic", 1));
		System.out.println(p.getOptionSet(1));
		System.out.println("----------------------------------------------");
		System.out.println("update the name and price of Automatic option in the Transmission option set:");
		System.out.println(p.updateOptionValue("Transmission", "Automatic", "Manual", 100));
		System.out.println(p.getOptionSet(1));
		System.out.println("----------------------------------------------");
		System.out.println("update the name and price of Fort Knox Gold Clearcoat Metallic option in the first option set:");
		System.out.println(p.updateOptionValue(0, "Fort Knox Gold Clearcoat Metallic", "Gold", 100));
		System.out.println(p.getOptionSet(0));
		//update optionSet functions
		System.out.println("----------------------------------------------");
		System.out.println("update the name of option set:");
		System.out.println(p.updateOptionSetName("Color", "Pigment"));
		System.out.println(p.getOptionSet(0));
		System.out.println("----------------------------------------------");
		System.out.println("update the name and size of option set:");
		System.out.println(p.updateOptionSet("Transmission", "Gears", 2));
		System.out.println(p.getOptionSet(1));
		//delete optionSet
		System.out.println("----------------------------------------------");
		System.out.println("delete the second option set");
		System.out.println(p.deleteOptionSet(1));//delete Transmission
		System.out.println(p.toString());
		System.out.println("----------------------------------------------");
		System.out.println("delete the Power Moonroof option set");
		System.out.println(p.deleteOptionSet("Power Moonroof"));//delete Power Moonroof
		System.out.println(p.toString());
		//fail sets
		//find functions
		System.out.println("----------------------------------------------");
		System.out.println("failed to find the option or option set by wrong name and index");
		System.out.println(p.findOptionByName(-1, "Wrong"));
		System.out.println(p.findOptionByName("Color", "Wrong"));
		System.out.println(p.findOptionSetByName("Wrong"));
		//delete functions
		System.out.println("----------------------------------------------");
		System.out.println("failed to delete the option or option set by wrong name and index");
		System.out.println(p.deleteOption(-1, -1));
		System.out.println(p.deleteOption("Color", "Wrong"));
		System.out.println(p.deleteOptionSet(10));
		System.out.println(p.deleteOptionSet("Wrong"));
		//update functions
		System.out.println("----------------------------------------------");
		System.out.println("failed to update the option or option set by wrong name and index");
		System.out.println(p.updateOptionName(1, 10, "Wrong"));
		System.out.println(p.updateOptionPrice(2, 9, 12));
		System.out.println(p.updateOptionSet("Wrong", "Side Impact Air Bags", 4));
		System.out.println(p.updateOptionSetName("Wrong", "color"));
		System.out.println(p.updateOptionValue(2, 8, "old", 123));
		System.out.println(p.updateOptionValue(8, "Old", "newName", 1000));
		System.out.println(p.updateOptionValue("Brakes/Traction Control", "Wrong", "newName", 999));
		*/
	}
}