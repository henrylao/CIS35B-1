//============================================================================
// Project     : Lab2
// Name        : OptionSet.java
// Author      : Tianqi Yang
// Time        : 4/18/2019
// IDE         : Eclipse
// Description : It has the OptionSet class and Option inner class. OptionSet
// saves an array of Options and Options object contain the value of the 
// option.
//============================================================================
package model;

import java.io.Serializable;

public class OptionSet implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5702014549117009505L;

	private Option opt [];
	
	private String name;
	
	//Constructor
	protected OptionSet(){}
	
	protected OptionSet(String n, int size) {
		name = n; 
		opt = new Option[size];
		for(int i = 0; i< size; i++){
			opt[i] = null;
		}
	}
	
	//Getter
	protected String getOptionSetName(){ return name; }
	
	protected Option[] getOption(){ return opt; }
	
	//Find
	protected int findOption(String n){
		int pos = -1;
		for(int j = 0; j< opt.length; j++){
			if(checkValidIndex(j) && opt[j].getOptionName().equals(n)) {
					pos = j;
			}			
		}
		return pos;
	}
	
	//Setter
	protected void setOptionSetName(String n){ name = n;}
	
	protected void setOption(int i, String n, float p ){
		if(opt[i] == null)
			opt[i] = new Option(n,p);
		else
			opt[i].setOptionValue(n,p);
	}
	
	protected boolean setOption(String oldName, String newName, float newPrice ){
		int pos = findOption(oldName);
		if(pos != -1) {
			opt[pos].setOptionValue(newName,newPrice);
			return true;
		}
		return false;
		
	}
	
	//Delete
	protected boolean findAndDeleteOption(int pos){
		if(checkValidIndex(pos)){
			opt[pos] = null;
			return true;
		}
		else
			return false;
	}
	
	protected boolean findAndDeleteOption(String name){
		int pos = findOption(name);
		if(pos != -1){
			opt[pos] = null;
			return true;
		}
		else
			return false;
	}
	
	//Check valid index
	protected boolean checkValidIndex(int i){
		return i >= 0 && i < opt.length && opt[i] != null;
	}
	
	//Inner class
	protected class Option implements Serializable {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -4627553903186048433L;

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
	
	//Print
	@Override
	public String toString(){
		StringBuffer s = new StringBuffer();
		s.append(String.format(" %s\n ---------------------------------------------", getOptionSetName())).append(String.format("\n %-35s%10s\n", "Name", "Fee"));
		for(int i=0; i< opt.length; i++){
			if(opt[i] != null)
				s.append(String.format("%2s.%-35s%8.2f\n",i+1,opt[i].getOptionName(),opt[i].getOptionPrice()));
		}
		return s.toString();
	}
}