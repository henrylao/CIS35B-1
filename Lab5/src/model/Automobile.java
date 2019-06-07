//============================================================================
// Project     : Lab5
// Name        : Automotive.java
// Author      : Tianqi Yang
// Time        : 5/9/2019
// IDE         : Eclipse
// Description : It contains the car's information
//============================================================================
package model;

import java.io.*;
import java.util.ArrayList;

import exception.AutoException;

public class Automobile implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7839683941996331129L;

	private String make;
	
	private String model;
		
	private String year;
	
	private float baseprice;
	
	private ArrayList<OptionSet> opset;
		
	private ArrayList<Option> choice;
	
	private float total;
	 
	//Constructor
	//public Automobile(){};
	
	public Automobile(String m, String n, String y, float p)
	{
		make = m;
		model = n;
		year = y;
		baseprice = p;
		opset = new ArrayList<OptionSet>();
		choice = new ArrayList<Option>();
		total = baseprice;
	}
	
	//Setter
	public void setMake(String m) { make = m; }
	
	public void setModel(String m) { model = m; }
		
	public void setYear(String y) { year = y; }
	
	public void setBasePrice(float i){ baseprice = i; }

	public void setValueOptionSet(String n){ 
		opset.add(new OptionSet(n)); 
		choice.add(new Option());
	} 
	
	public void setValuesOption(int i, String n, float p){ opset.get(i).setOption(n, p); }
	
	public void setOptionChoice(String setName, String optName) {
		int pos = findOptionSetByName(setName);
		if(pos != -1){
			opset.get(pos).setOptionChoice(optName);
			choice.set(pos, opset.get(pos).getOptionChoice());
		}else{
			try {
				throw new AutoException(101, "Cannot find the option set name");
			}
			catch(AutoException e) {
				e.fix();
			}
		}
	}

	//Getter
	public String getMake() { return make;}
	
	public String getModel() { return model;}

	public String getYear() { return year; }
	
	public float getbaseprice(){ return baseprice; }
	
	public OptionSet getOptionSet(int i){ 
		if(checkValidIndex(i))
			return opset.get(i);
		else
			return null;
	}
	
	public int getOptionSetSize() { return opset.size(); }
	
	public String getOptionChoice(String setName) {
		int pos = findOptionSetByName(setName);
		if(pos != -1) {
			return choice.get(pos).toString();
		}
		return null;
	}
	public float getOptionChoicePrice(String s) {
		int pos = findOptionSetByName(s);
		if(pos != -1) {
			return choice.get(pos).getOptionPrice();
		}
		return 0;
	}
	
	//get choice total
	public float caulateTotal() {
		total = baseprice;
		for(int i = 0; i< choice.size(); i++) {
			total += choice.get(i).getOptionPrice();
		}
		return total;
	}
	public float getTotalPrice() { 
		caulateTotal();
		return total;
	}
	
	//Find
	public int findOptionSetByName(String n){
		int pos = -1;
		for(int i=0; i<opset.size(); i++){
			if(opset.get(i).getOptionSetName().equals(n))
				pos = i;
		}
		return pos;
	}
	
	public int findOptionByName(int i, String n){
		if(checkValidIndex(i))
			return opset.get(i).findOption(n);
		return -1;
	}
	
	public int findOptionByName(String setName, String opName){
		int pos = findOptionSetByName( setName );
		if(pos != -1)
			return opset.get(pos).findOption(opName);
		return -1;
	}
	
	//Delete optionSet
	public boolean deleteOptionSet(int i){
		if(checkValidIndex(i)){
			opset.remove(i);
			return true;
		}
		else
			return false;
	}
	
	public boolean deleteOptionSet(String name){
		int pos = findOptionSetByName(name);
		if(pos != -1){
			opset.remove(pos);
			return true;
		}
		else
			return false;
	}
	
	//delete option
	public boolean deleteOption(String setName, String opName){
		int pos = findOptionSetByName(setName);
		if(pos != -1){
			return opset.get(pos).findAndDeleteOption(opName);
		}
		return false;
	}
	
	public boolean deleteOption(int i, int pos){
		if(checkValidIndex(i)){
			return opset.get(i).findAndDeleteOption(pos);
		}
		return false;
	}
	
	//Update optionSet
	public boolean updateOptionSetName(String oldName, String newName) {
		int pos = findOptionSetByName(oldName);
		if( pos != -1){
			opset.get(pos).setOptionSetName(newName);
			return true;
		}
		return false; 
	}
	
	public boolean updateOptionSet(String oldName, String newName){
		int pos = findOptionSetByName(oldName);
		if( pos != -1){
			opset.set(pos, new OptionSet(newName));
			return true;
		}
		return false;
	}
	
	//update option
	public boolean updateOptionValue(String optionSetName, String optionOldName, String newName, float newPrice){
		int pos = findOptionSetByName(optionSetName);
		if( pos != -1){
			return opset.get(pos).updateOption(optionOldName, newName, newPrice);
		}
		return false;
	}
	
	public boolean updateOptionValue(int i, String oldName, String newName, float newPrice){
		int pos = findOptionByName(i, oldName);
		if( pos != -1){
			opset.get(pos).updateOption(pos, newName, newPrice);
			return true;
		}
		return false;
	}
	
	public boolean updateOptionValue(int i, int pos, String newName, float newPrice) {
		if(checkValidIndex(i)) {
			if(opset.get(i).checkValidIndex(pos)) {
				opset.get(i).getOption(pos).setOptionValue(newName, newPrice);
				return true;
			}
		}
		return false;
	}
	
	public boolean updateOptionName(int i, int pos, String newName) {
		if(checkValidIndex(i)) {
			if(opset.get(i).checkValidIndex(pos)) {
				opset.get(i).getOption(pos).setOptionName(newName);
				return true;
			}	
		}
		return false;
	}
	
	public boolean updateOptionName(String optionName, String option, String newName) {
		int pos = findOptionSetByName(optionName);
		if(pos != -1) {
			int index = opset.get(pos).findOption(option);
			if (index != -1) {
				opset.get(pos).updateOptionName(index, newName);
				return true;
			}
		}
		return false;
	}
	
	public boolean updateOptionPrice(int i, int pos, float newPrice) {
		if(checkValidIndex(i)) {
			if(opset.get(i).checkValidIndex(pos)) {
				opset.get(i).getOption(pos).setOptionPrice(newPrice);
				return true;
			}	
		}
		return false;
	}
	
	public boolean updateOptionPrice(String optionName, String option, float newPrice) {
		int pos = findOptionSetByName(optionName);
		if(pos != -1) {
			int index = opset.get(pos).findOption(option);
			if (index != -1) {
				opset.get(pos).updateOptionPrice(index, newPrice);
				return true;
			}
		}
		return false;
	}
	
	//Check valid index
	public boolean checkValidIndex(int i){
		return i >= 0 && i < opset.size();
	}
	
	//Print
	public void printChoices() {
		System.out.println("Choices");
		System.out.println("----------------------------------------------");
		for( int i = 0; i< choice.size(); i++ ) {
			System.out.println(String.format( "Optionset:%36s" ,opset.get(i).getOptionSetName()));
			System.out.println(choice.get(i));
			System.out.println("----------------------------------------------");
		}
	}
	
	@Override
	public String toString(){
		StringBuffer s = new StringBuffer(String.format("Model Make:%35s\nModel Name:%35s\nYear:%41s\nBase Price:%35.2f\n\n", getMake(), getModel(), getYear(), getbaseprice()));
		for ( OptionSet item : opset) {
			s.append(item.toString()).append('\n');
		}
		return s.toString();
	}
}