//============================================================================
//Project     : Lab5
//Name        : EditInterface.java
//Author      : Tianqi Yang
//Time        : 5/29/2019
//IDE         : Eclipse
//Description : it is the interface of EditOption 
//============================================================================
package scale;

public interface EditInterface{
	public void editOptionSetName(int x, String model, String name, String newName);
	public void editOptionName(int x,  String model, String optionSetName, String optionName, String newOptionName);
	public void editOptionPrice(int x,  String model, String optionSetName, String optionName, float newValue);
}