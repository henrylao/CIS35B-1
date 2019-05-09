//============================================================================
// Project     : Lab3
// Name        : Option.java
// Author      : Tianqi Yang
// Time        : 5/6/2019
// IDE         : Eclipse
// Description : It contains the car's Option class.
//============================================================================
package model;

import java.io.Serializable;

public class Option implements Serializable{
	
	private String name;
	
	private float price; 
	
	//Constructor
	protected Option(){}
	
	protected Option(String n, float p){ name = n; price = p; }
	
	//Getter
	protected String getOptionName(){ return name;}
	
	protected float getOptionPrice(){ return price;}
	
	//Setter
	protected void setOptionValue(String n, float p ){ name = n; price = p; }
	
	protected void setOptionName(String n){ name = n;}
	
	protected void setOptionPrice(float p){ price = p;}
}
