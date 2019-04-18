//============================================================================
// Name        : Automotive.java
// Author      : Tianqi Yang
// Time        : 4/10/2019
// IDE         : Eclipse
// Description : It contains the car's information and an array of OptionSet.
//============================================================================
package model;
import java.io.*;

public class Automotive implements Serializable{
	private String name;
	private float baseprice;
	private OptionSet opset[];
	//Constructor
	//public Automotive(){}
	public Automotive(String n, float p, int s)
	{
		name = n;
		baseprice = p;
		opset = new OptionSet[s];
//		for(int i = 0; i < s; i++){
//			opset[i] = new OptionSet("", 0);
//		}
	} 
	//Getter
	public String getName(){ return name;}
	public float getbaseprice(){ return baseprice;}
	public OptionSet getOptionSet(int i){ 
		if(checkValidIndex(i))
			return opset[i];
		else
			return null;
	}	
	//Find
	public int findOptionSetByName(String n){
		int pos = -1;
		for(int i=0; i<opset.length; i++){
			if(checkValidIndex(i) && opset[i].getOptionSetName().equals(n))
				pos = i;
		}
		return pos;
	}
	public int findOptionByName(int i, String n){
		if(checkValidIndex(i))
			return opset[i].findOption(n);
		return -1;
	}
	public int findOptionByName(String setName, String opName){
		int pos = findOptionSetByName( setName );
		if(pos != -1)
			return opset[pos].findOption(opName);
		return -1;
	}
	//Setter
	public void setName(String n){ name = n;}
	public void setBasePrice(float i){ baseprice = i;}
	public void setValueOptionSet(int index, String n, int size){
		opset[index] = new OptionSet(n, size);
	}
	public void setValuesOption(int index, int pos, String n, float p){
		opset[index].getOption()[pos] = opset[index].new Option(n, p);
	}
	//Delete optionSet
	public boolean deleteOptionSet(int i){
		if(checkValidIndex(i)){
			opset[i] = null;
			return true;
		}
		else
			return false;
	}
	public boolean deleteOptionSet(String name){
		int pos = findOptionSetByName(name);
		if(pos != -1){
			opset[pos] = null;
			return true;
		}
		else
			return false;
	}
	//delete option
	public boolean deleteOption(String setName, String opName){
		int pos = findOptionSetByName(setName);
		if(pos != -1){
			return opset[pos].findAndDeleteOption(opName);
		}
		return false;
	}
	public boolean deleteOption(int i, int pos){
		if(checkValidIndex(i)){
			return opset[i].findAndDeleteOption(pos);
		}
		return false;
	}
	//Update optionSet
	public boolean updateOptionSetName(String oldName, String newName) {
		int pos = findOptionSetByName(oldName);
		if( pos != -1){
			opset[pos].setOptionSetName(newName);
			return true;
		}
		return false;
	}
	public boolean updateOptionSet(String oldName, String newName, int size){
		int pos = findOptionSetByName(oldName);
		if( pos != -1){
			opset[pos] = new OptionSet(newName, size);
			return true;
		}
		return false;
	}
	//update option
	public boolean updateOptionValue(String optionSetName, String optionOldName, String newName, float newPrice){
		int pos = findOptionSetByName(optionSetName);
		if( pos != -1){
			return opset[pos].setOption(optionOldName, newName, newPrice);
		}
		return false;
	}
	public boolean updateOptionValue(int i, String oldName, String newName, float newPrice){
		int pos = findOptionByName(i, oldName);
		if( pos != -1){
			opset[i].setOption(pos, newName, newPrice);
			return true;
		}
		return false;
	}
	public boolean updateOptionValue(int i, int pos, String newName, float newPrice) {
		if(checkValidIndex(i)) {
			if(opset[i].checkValidIndex(pos)) {
				opset[i].getOption()[pos].setOptionValue(newName, newPrice);
				return true;
			}
		}
		return false;
	}
	public boolean updateOptionName(int i, int pos, String newName) {
		if(checkValidIndex(i)) {
			if(opset[i].checkValidIndex(pos)) {
				opset[i].getOption()[pos].setOptionName(newName);
				return true;
			}	
		}
		return false;
	}
	public boolean updateOptionPrice(int i, int pos, float newPrice) {
		if(checkValidIndex(i)) {
			if(opset[i].checkValidIndex(pos)) {
				opset[i].getOption()[pos].setOptionPrice(newPrice);
				return true;
			}	
		}
		return false;
	}
	//Check valid index
	public boolean checkValidIndex(int i){
		return i >= 0 && i < opset.length && opset[i] != null;
	}
	//Print
	@Override
	public String toString(){
		StringBuffer s = new StringBuffer(String.format(" %s\n %-35s%10.2f\n\n", getName(), "Base Price", getbaseprice()));
		for(int i = 0; i< opset.length; i++){
			if(opset[i] != null){
				s.append(opset[i].toString());
				s.append('\n');
			}
		}
		return s.toString();
	}
}