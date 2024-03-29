//============================================================================
// Project     : Lab3
// Name        : Choice.java
// Author      : Tianqi Yang
// Time        : 5/6/2019
// IDE         : Eclipse
// Description : the interface that user can make choice and get total price 
// of choices
//============================================================================
package adapter;

public interface Choice {
	public void setOptionChoice(String modelName, String optionSetName, String optionName);
	public void printChoices(String modelName);
	public float getTotal(String modelName);
}