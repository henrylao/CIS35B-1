import java.io.*;
public class Driver {

	public static void main(String[] args) throws IOException {

		File file = null;
		FileOutputStream fileOut = null;
		
		try {
			file = new File("output.dat");
			if(!file.exists())
				file.createNewFile();
			fileOut = new FileOutputStream(file);
			String textToSave = "Hello, World.";
			byte[] textToSaveBytes = textToSave.getBytes();
			fileOut.write(textToSaveBytes);
			
		} catch(IOException ex) {
			
		}
		
		
		
		
	}

}
