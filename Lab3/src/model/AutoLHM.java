//============================================================================
// Project     : La3
// Name        : AutoLHM.java
// Author      : Tianqi Yang
// Time        : 5/6/2019
// IDE         : Eclipse
// Description : it is generics for auto
//============================================================================
package model;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class AutoLHM <T extends Automobile>{
	
	private LinkedHashMap<String, T> auto;
	
	//constructor
	public AutoLHM() {
		auto = new LinkedHashMap<String, T>();
	}
	public AutoLHM(T a){
		auto = new LinkedHashMap<String, T>();
	}
	
	//adding
	public void adding(T a) {
		auto.put( getKey(a), a );
	}
		
	//set up the key value for object T
	public String getKey(Object o) {
		StringBuffer s = new StringBuffer(((Automobile) o).getMake()).append(((Automobile) o).getModel()).append( ((Automobile) o).getYear());
		return s.toString();
	}
	
	//Removing
	public boolean removing(String name) {
		Iterator it = auto.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry item = (Map.Entry) it.next();
			if( ((Automobile) item.getValue()).getModel().equals(name)) {
				auto.remove(getKey(item.getValue()));
				System.out.print("Detele the car ");
				System.out.println(name);
				System.out.println("");
				return true;
			}
		}
		return false;
	}
	
	//finding
	public boolean finding(String name) {
		Iterator<?> it = auto.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry item = (Map.Entry) it.next();
			//System.out.println(((Automobile) item.getValue()).getModel());
			if( ((Automobile) item.getValue()).getModel().equals(name)) 
				return true;
			else {
				System.out.print("Cannot find ");
				System.out.println(name);
				System.out.println("");
			}
		}
		return false;		
	}
	
	//return object
	public T returnObject(String name) {
		
		Iterator<?> it = auto.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry item = (Map.Entry) it.next();
			if( ((Automobile) item.getValue()).getModel().equals(name)) {
				return (T) item.getValue();
			}
		}
		return null;		
	}
	
}
