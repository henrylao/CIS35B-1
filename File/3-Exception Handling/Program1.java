public class Program1 {
	public static void main (String[] args) {
		int counter = 0;
		try {
			for( int i=0; i <4; i++) {
			counter = 10 / i;
			System.out.println("Counter: " + counter);
			}
		} 
	    catch (ArithmeticException ae) {
			System.out.println("Divide by zero exception");
		}
		finally {
			System.out.println ("In the finally clause");
	  }
	}
}
