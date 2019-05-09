//============================================================================
// Project     : La3
// Name        : AutoLHM.java
// Author      : Tianqi Yang
// Time        : 5/6/2019
// IDE         : Eclipse
// Description : it is generics for auto
//============================================================================
package model;

public class AutoLHM <T extends Automobile>{
	T auto;
	//constructor
	public AutoLHM(T a){
		auto = a;
	}
	//return object
	public T getAuto() {
		return auto;
	}
	//return type
	public void showType() {
		System.out.print("Type of T is ");
		System.out.println(auto.getClass().getName());
	}
	public String setKey() {
		StringBuffer s = new StringBuffer(auto.getMake()).append(auto.getModel()).append( auto.getYear());
		return s.toString();
	}
}
