/* Inner Class 
 * 
 * Type 1: Defining an inner class inside a class (standard type)
 * */

package mypackage;

public class Program6 {
	private int value;
	InnerClass innerClass = new InnerClass();
	
	public Program6(){
		// constructor for class Program6
	}
	
	public void printValue(){
		// method for class Program6
		System.out.println(getValue());
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		innerClass.changeValue(value);
	}
	
	// inner class inside class Program6
	private class InnerClass{
		public void changeValue(int newValue){
			// method for InnerClass
			value = newValue;
			System.out.println("Changing value of variable a, new value is now: " + value );
		}
	}
	
	public static void main(String[] args){
		Program6 p = new Program6();
		
		p.setValue(8);   /* setValue method in Program6 calls InnerClass.changeValue() method */
		p.setValue(100);	
	}
}
