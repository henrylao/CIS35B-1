//============================================================================
// Project     : Lab3
// Name        : OptionSet.java
// Author      : Tianqi Yang
// Time        : 5/6/2019
// IDE         : Eclipse
// Description : It has the OptionSet class and Option inner class. OptionSet
// saves an array of Options and Options object contain the value of the 
// option.
//============================================================================
package model;
import java.io.Serializable;
import java.util.ArrayList;

public class OptionSet implements Serializable{
	
	private String name;
	
	private ArrayList<Option> opt;
	
	private Option choice;
	
	//Constructor
	protected OptionSet(){}
	
	protected OptionSet(String n) {
		name = n; 
		opt = new ArrayList<Option>();
	}
	//Setter
	protected void setOptionSetName(String n){ name = n; }
	
	protected void setOption(String n, float p ){ opt.add(new Option(n, p)); }
	
	protected void setOptionChoice(String optionName) {
		int pos = findOption(optionName);
		if (pos != -1) {
			choice = opt.get(pos);
		}
	}
	//Getter
	protected String getOptionSetName(){ return name; }
	
	protected Option getOption(int index){ return opt.get(index); }
	
	public Option getOptionChoice() { return choice; }
	
	//Find
	protected int findOption(String n){
		for(int j = 0; j< opt.size(); j++){
			if(opt.get(j).getOptionName().equals(n)) {
				return j;
			}
		}
		return -1;
	}
	
	//update
	protected boolean updateOptionName(int i, String n) {
		opt.get(i).setOptionName(n);
		return true;
	}
	
	protected boolean updateOptionPrice(int i, float p) {
		opt.get(i).setOptionPrice(p);
		return true;
	}
	
	//Delete
	protected boolean findAndDeleteOption(int pos){//search by index
		if(checkValidIndex(pos)){
			opt.remove(pos);
			return true;
		}
		else
			return false;
	}
	
	protected boolean findAndDeleteOption(String name){//search by name
		int pos = findOption(name);
		if(pos != -1){
			opt.remove(pos);
			return true;
		}
		else
			return false;
	}
	
	//Check valid index
	protected boolean checkValidIndex(int i){
		return i >= 0 && i < opt.size();
	}
	
	//Print
	@Override
	public String toString(){
		StringBuffer s = new StringBuffer();
		s.append(String.format(" %s\n ---------------------------------------------", getOptionSetName())).append(String.format("\n %-35s%10s\n", "Name", "Fee"));
		for(int i=0; i< opt.size(); i++){
				s.append(String.format("%2s.%-35s%8.2f\n",i+1,opt.get(i).getOptionName(),opt.get(i).getOptionPrice()));
		}
		return s.toString();
	}
}