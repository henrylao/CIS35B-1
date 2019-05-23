//============================================================================
// Project     : Lab4
// Name        : Option.java
// Author      : Tianqi Yang
// Time        : 5/6/2019
// IDE         : Eclipse
// Description : It contains the car's Option class.
//============================================================================
package model;

import java.io.Serializable;

public class Option implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2260484367976294032L;

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
	
	protected void setOptionName(String n){ name = n; }
	
	protected void setOptionPrice(float p){ price = p; }
	
	@Override
	public String toString(){
		StringBuffer s = new StringBuffer();
		if(name != null) {
			s.append(String.format("%-38s%8.2f", getOptionName(),getOptionPrice()));
		}
		else {
			s.append("Have not chosen yet");
		}
		return s.toString();
	}
}
