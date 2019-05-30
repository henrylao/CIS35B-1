//============================================================================
//Project     : Lab5
//Name        : HelperEdit.java
//Author      : Tianqi Yang
//Time        : 5/29/2019
//IDE         : Eclipse
//Description : it has methods that helper to edit auto
//============================================================================
package scale;

import model.AutoLHM;
import model.Automobile;

public class HelperEdit {

	public synchronized void helpEditOptionSetName(AutoLHM<Automobile> auto, String model, String optionSetName, String newOptionSetName) {
		auto.returnObject(model).updateOptionSetName(optionSetName, newOptionSetName);
		System.out.println(auto.returnObject(model).toString());
	}

	public synchronized void helpEditOptionName(AutoLHM<Automobile> auto, String model, String optionSetName, String optionName, String newOptionName) {
		auto.returnObject(model).updateOptionName(optionSetName, optionName, newOptionName);
		System.out.println(auto.returnObject(model).toString());
	}

	public synchronized void helpEditOptionPrice(AutoLHM<Automobile> auto, String model, String optionSetName, String optionName, float newPrice) {
		auto.returnObject(model).updateOptionPrice(optionSetName, optionName, newPrice);
		System.out.println(auto.returnObject(model).toString());
	}

	public void nosyn_helpEditOptionName(AutoLHM<Automobile> auto, String model, String optionSetName, String optionName, String newOptionName) {
		auto.returnObject(model).updateOptionName(optionSetName, optionName, newOptionName);
		System.out.println(auto.returnObject(model).toString());
	}

	public void nosyn_helpEditOptionPrice(AutoLHM<Automobile> auto, String model, String optionSetName, String optionName, float newPrice) {
		auto.returnObject(model).updateOptionPrice(optionSetName, optionName, newPrice);
		System.out.println(auto.returnObject(model).toString());
	}
}
