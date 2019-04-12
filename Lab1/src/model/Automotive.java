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
		for(int i = 0; i < s; i++){
			opset[i] = new OptionSet("", 0);
		}
	} 
	//Getter
	public String getName(){ return name;}
	public float getbaseprice(){ return baseprice;}
	public OptionSet getOptionSet(int i){ 
		if(checkIndex(i))
			return opset[i];
		else
			return null;
	}	
	//Find
	public int findOptionSetByName(String n){
		int pos = -1;
		for(int i=0; i<opset.length; i++){
			System.out.println(opset[i].getOptionSetName());
			if(opset[i].getOptionSetName().equals(n))
				pos = i;
		}
		return pos;
	}
	public int findOptionByName(int i, String n){
		if(checkIndex(i))
			return opset[i].findOption(n);
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
	//Delete
	public void deleteOptionSet(int i){
		if(checkIndex(i)){
			opset[i] = null;
		}
	}
	public void deleteOption(int i, int pos){
		if(checkIndex(i)){
			opset[i].findAndDeleteOption(pos);
		}
	}
	//Update
	public void updateOptionSet(String name, String n, int size){
		int pos = findOptionSetByName(name);
		if( pos != -1){
			opset[pos] = new OptionSet(n, size);
		}
	}
	public void updateOption(int i, String n, String newName, float newPrice){
		int pos = findOptionByName(i, n);
		if( pos != -1){
			opset[i].setOption(pos, newName, newPrice);
		}
	}
	//Check valid index
	public boolean checkIndex(int i){
		return i >= 0 && i < opset.length && opset[i] != null;
	}
	//Print
	@Override
	public String toString(){
		StringBuffer s = new StringBuffer(getName());
		s.append(String.format("\n%-35s%5.2f\n\n", "Base Price", getbaseprice()));
		for(int i = 0; i< opset.length; i++){
			if(opset[i] != null){
				s.append(opset[i].toString());
				s.append('\n');
			}
		}
		return s.toString();
	}
}