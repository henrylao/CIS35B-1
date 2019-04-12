import java.io.*;

public class AllCapsDemo {
	public static void main(String [] arguments) {
		AllCaps cap = new AllCaps(arguments[0]);
		cap.convert();
		
		
	}
}

class AllCaps {
	String sourceName; 
	
	AllCaps(String sourceArg){
		this.sourceName = sourceArg;
	}
	
	void convert() {
		try {
			// using File Class!!!!
			// creating the file object!
			File source = new File(this.sourceName);
			File temp = new File("Cap" + this.sourceName + ".tmp");
			
			// create input stream -- read the data from the text file
			
			// pass the file into the file reader
			FileReader fr = new FileReader(source); // read from a source file
			// pass the FileReader object into BufferedReader
			BufferedReader in = new BufferedReader(fr);
			// in.readLine();
			
			
			// create output stream -- write the data to a file
			// create a FileWriter object 
			FileWriter fw = new FileWriter(temp);
			// pass the FileWriter object to BufferedWriter 
			BufferedWriter out = new BufferedWriter(fw);
			
			// flag
			boolean eof = false; // end of file 
			int inChar = 0; // takes the character as an int...
			do {
				inChar = in.read();	
				if(inChar != -1) {
					char outChar = Character.toUpperCase( (char) inChar);
					out.write(outChar);
				} else	// NOTE**** if the character that is being read is -1 
						// then we're at the end of the file!
					eof = true; 	// set end of file to true
			} while (!eof);
			in.close();	// close the inputFile
			out.close(); // close the outputFile
			
			boolean deleted = source.delete();
			if(deleted)
				temp.renameTo(source);
		} catch(IOException e) {
			System.out.println("Error -- " + e.toString());
		} catch(SecurityException se) {
			System.out.println("Error -- " + se.toString());
		}
	}
}
