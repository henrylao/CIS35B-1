/* Inner Class 
 * 
 * Type 2: Defining an inner class inside a method
 * */

package mypackage;

public class Program7 {
	private int value;
	
	public Program7(){
		// constructor for class Program7
	}
	
	private void setValue(int value){
		this.value = value;
	}
	
	public void computeNumber() {
		class InnerClass{
			public int computeValue(int param){
				// method for InnerClass
				return value*100;
			}
		}
		
		InnerClass innerClass = new InnerClass();
		System.out.println("Computed value is: " + innerClass.computeValue(value));
	}
	
	public static void main(String[] args){
		Program7 p = new Program7();
		
		p.setValue(8);     /* here we set the value variable in class Program7 */
		p.computeNumber(); /* here we call Program7.computeNumber(), which uses an InnerClass to perform some simple calculation */	
	}
}
