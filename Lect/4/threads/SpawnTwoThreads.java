
import java.io.*;
/**
 * Class to demonstrate spawning threads 
 * that are subclasses of the Thread class
 */
public class SpawnTwoThreads {

	public static void main(String[] args) 
	   throws InterruptedException {
		   Thread one = new HelloName();
		   one.start();
		   Thread two = new NumberCrunch();
		   two.start();
		   one.join();
		   ( (NumberCrunch) two ).end();
	}
}
/**
 * Class that performs I/O and runs on a thread
 */
class HelloName extends Thread {
	public void run() {
		try {
			System.out.print( "What is your name? " );
			BufferedReader br =
				new BufferedReader(
				new InputStreamReader( System.in ) );
			String name = br.readLine();
			System.out.println( "Hello " + name );
		} catch (IOException ioe) {
			System.out.println( ioe.getMessage() );
		}
	}
}
/**
 * Class that performs processor-heavy calculations 
 * and runs on a thread
 */
class NumberCrunch extends Thread {
	private static boolean stopflag = false;
	public void run() {
		try {
			int i = 1;
			double d = 0;
			while ( !stopflag ) {
				d = Math.log( i++ );
				sleep( 1 );
			}
			System.out.println(
			   "The log of " + i + " is " + d );
		} catch ( InterruptedException ie ) {
			System.out.println(ie.getMessage() );
		}
	}
	public void end() {
		stopflag = true;
	}
}
