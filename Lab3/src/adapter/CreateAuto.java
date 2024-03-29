//============================================================================
// Project     : Lab3
// Name        : CreateAuto.java
// Author      : Tianqi Yang
// Time        : 5/6/2019
// IDE         : Eclipse
// Description : CreateAuto is a interface which contain the method to create 
// and print auto object
//============================================================================
package adapter;

public interface CreateAuto {
	public void BuildAuto(String filename);
	public void printAuto(String modelname);
}