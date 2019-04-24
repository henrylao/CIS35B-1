//============================================================================
// Project     : Lab2
// Name        : ProxyAutomobile.java
// Author      : Tianqi Yang
// Time        : 4/18/2019
// IDE         : Eclipse
// Description : it is the parent class of buildAuto and contains the code of
// the methods
//============================================================================
package adapter;
import java.io.*;
import exception.*;
import model.*;
import util.*;
public abstract class ProxyAutomobile {//acting as a delegate
	private static Automotive a1;
	public void BuildAuto(String filename) {
		FileIO file = new FileIO();		
		a1 = file.readFile(filename);
	}
	public void printAuto() {
		System.out.println(a1.toString());
	}
	public void updateOptionSetName(String Modelname, String optionSetname, String newName) {
		a1.updateOptionSetName(optionSetname, newName);
	}
	public void updateOptionPrice(String ModelName, String optionName, String Option, float newPrice) {
		a1.updateOptionPrice(optionName, Option, newPrice);
	}
}