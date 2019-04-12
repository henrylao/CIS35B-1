import java.io.*;

public class AllCapsDemo {
    public static void main(String[] arguments) {
        AllCaps cap = new AllCaps(arguments[0]);
        cap.convert();
    }
}

class AllCaps {
    String sourceName;

    AllCaps(String sourceArg) {
        sourceName = sourceArg;
    }

    void convert() {
        try {
            // Create file objects
            File source = new File(sourceName);
            File temp = new File("cap" + sourceName + ".tmp");

            // Create input stream
            FileReader fr = new
                FileReader(source);
            BufferedReader in = new
                BufferedReader(fr);

            // Create output stream
            FileWriter fw = new
                FileWriter(temp);
            BufferedWriter out = new
                BufferedWriter(fw);

            boolean eof = false;
            int inChar = 0;
            do {
                inChar = in.read();
                if (inChar != -1) {
                    char outChar = Character.toUpperCase( (char)inChar );
                    out.write(outChar);
                } else
                    eof = true;
            } while (!eof);
            in.close();
            out.close();

            boolean deleted = source.delete();
            if (deleted)
                temp.renameTo(source);
        } catch (IOException e) {
            System.out.println("Error -- " + e.toString());
        } catch (SecurityException se) {
            System.out.println("Error -- " + se.toString());
        }
    }
}
