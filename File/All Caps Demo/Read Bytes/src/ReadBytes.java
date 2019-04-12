import java.io.*;

public class ReadBytes {
	public static void main(String[] arguments) {
		try {
			FileInputStream file = new FileInputStream("pic.gif");
			boolean eof = false;
			int count = 0;
			while (!eof) {
				int input = file.read();			// read a byte and store it into an integer.
													// largest value of a byte is 255
				System.out.print(input + " ");
				if (input == -1)
					eof = true;
				else
					count++;
			}
			file.close();
			System.out.println("\nBytes read: " + count);
		} catch (IOException e) {
			System.out.println("Error -- " + e.toString());
		}
	}
}
