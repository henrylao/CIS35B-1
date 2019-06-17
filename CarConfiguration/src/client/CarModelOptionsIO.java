
package client;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class CarModelOptionsIO {

	////////// PROPERTIES //////////


	////////// CONSTRUCTORS //////////

	public CarModelOptionsIO() {
 
	}

	////////// INSTANCE METHODS //////////

	public Object loadPropsFile(String fname) {
		Properties props = new Properties();
		try {
			props.load(new FileInputStream(fname));
		} 
		catch (FileNotFoundException e) {
			Path currentRelativePath = Paths.get("");
			String s = currentRelativePath.toAbsolutePath().toString();
			System.out.println("Current relative path is: " + s);
			System.err.println("Error in file directory ... ");
			System.exit(1);
		}
		catch (IOException e) {
			System.err.println("Error reading file from directory ... ");
			System.exit(1);
		}

		return props;
	}

	public Object loadTextFile(String fname) { 
		StringBuffer sbuff = new StringBuffer();
		try {
			Path currentRelativePath = Paths.get("");
			String s = currentRelativePath.toAbsolutePath().toString();
			BufferedReader buff = new BufferedReader(new FileReader(fname));
			boolean eof = false;
			int counter = 0;
			while (!eof) { 
				String line = buff.readLine();
				if (line == null)
					eof = true;
				else {
					if (counter == 0)
						sbuff.append(line);
					else
						sbuff.append("\n" + line);
				}
				counter++;
			}
			buff.close();
		}
		catch (FileNotFoundException e) {
			System.err.println("Error in file directory ... ");
			System.exit(1);
		}
		catch (IOException e) {
			System.err.println("Error reading file from directory ... ");
			System.exit(1);
		}

		return sbuff;
	}

}
