//============================================================================
// Project     : Lab5
// Name        : UpdateAuto.java
// Author      : Tianqi Yang
// Time        : 5/29/2019
// IDE         : Eclipse
// Description : it updates the information of auto
//============================================================================
package adapter;

public interface UpdateAuto {
	public void updateOptionSetName(String modelName, String OptionSetname, String newName);
	public void updateOptionPrice(String modelName, String optionName, String option, float newPrice);
	public void deleteAuto(String modelName);
}