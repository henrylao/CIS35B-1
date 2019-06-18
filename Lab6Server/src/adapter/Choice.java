//============================================================================
// Project     : Lab5
// Name        : Choice.java
// Author      : Tianqi Yang
// Time        : 5/29/2019
// IDE         : Eclipse
// Description : the interface that user can make choice and get total price 
// of choices
//============================================================================
package adapter;

public interface Choice {
	public void setOptionChoice(String modelName, String optionSetName, String optionName);
	public void printChoices(String modelName);
	public String getTotal(String modelName);
}