//============================================================================
// Project     : Lab2
// Name        : Driver.java
// Author      : Tianqi Yang
// Time        : 4/18/2019
// IDE         : Eclipse
// Description : The program reads the data from a file and creates a 
// Automotive object. After that, it writes the object into a file. Finally, 
// it reads the object from the file.
//============================================================================
package driver;
import java.io.IOException;
import adapter.*;
import model.*;
import util.*;
public class Driver {
	public static void main(String[] args) throws IOException {
		CreateAuto a1 = new BuildAuto();
		a1.BuildAuto("fordwagonztw.txt");
		a1.printAuto();
		/*
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
		*/
	}
}