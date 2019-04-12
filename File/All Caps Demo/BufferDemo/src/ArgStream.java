import java.io.*;
public class ArgStream {
	int start = 0; 
	int finish = 100;
	
	// overloading constructor taking start and finish
	public ArgStream (int st, int fin) {
		this.start = st; 
		this.finish = fin; 
	}
	
	public boolean writeStream() {
		try {
			// If true, the data you write will be appended to the end of the file, 
			// rather than overwriting what was already there.
			FileOutputStream file = new FileOutputStream("numbers.dat" , true);
			BufferedOutputStream buff = new BufferedOutputStream(file);
			
			for(int out = start; out <= finish; out++) {
				buff.write(out);
				System.out.print(" " + out);
			}
			buff.close();
			return true;
		}catch(IOException e) {
			System.out.println("Exception: " + e.getMessage());
			return false;
		}
	}
	
	boolean readStream() {
		try {
			FileInputStream file = new FileInputStream("numbers.dat");
			BufferedInputStream buff = new BufferedInputStream(file);
			
			int in = 0; 
			do {
				in = buff.read();
				if(in != -1 )
					System.out.println(" " + in);
			}while (in != -1);
			buff.close();
			return true; 
		}catch(IOException e) {
			System.out.println("Exception " + e.getMessage());
			return false; 
		}
	}
	
	
	
	
	

}
