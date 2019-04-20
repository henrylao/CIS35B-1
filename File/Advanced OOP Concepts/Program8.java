/* Inner Class 
 * 
 * Type 3: Static inner class
 * */

package mypackage;

public class Program8 {
	
	public Program8(){
		// constructor for class Program8
	}
	
	// inner class inside class Program8
	static class InnerClass{
		public void performCalculation(int number){
			// method for InnerClass
			int answer = number * 1000;
			System.out.println("Performing some calculation in static inner class, answer is: " + answer);
		}
	}
	
	public static void main(String[] args){
		Program8.InnerClass inner = new Program8.InnerClass();
		
		inner.performCalculation(5);   /* call method in static inner class */
	
	}
}
