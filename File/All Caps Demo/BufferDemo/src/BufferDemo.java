import java.io.*;

public class BufferDemo {

	public static void main(String[] arguments) {
		
		int start = 0; 
		int finish = 10; 
		
		if(arguments.length > 1) {	// if there is more than 1 character in the arguments
			start = Integer.parseInt(arguments[0]);		// take the first one, convert to int
			finish = Integer.parseInt(arguments[1]);	// take the second one, convert to int 
		} else if (arguments.length > 0) // if there is only 1 character in the arguments
			start = Integer.parseInt(arguments[0]);
		ArgStream as = new ArgStream(start, finish);
		System.out.println("\nWriting: ");
		boolean success = as.writeStream();
		System.out.println("\nReading: ");
		boolean readSuccess = as.readStream();
		
	}

}
