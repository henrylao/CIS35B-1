//============================================================================
// Name        : FileIO.java
// Author      : Tianqi Yang
// Time        : 4/10/2019
// IDE         : Eclipse
// Description : read the file and creates the Automotive object. It has 
// functions to de-serialize and seriablize the object from and to the file.
//============================================================================
package util;
import model.*;
import java.io.*;
import java.util.*;
public class FileIO {
	
	public Automotive readFile(String fileName){
		Automotive a = null;
		try {
            FileReader file = new FileReader(fileName);
            BufferedReader buff = new BufferedReader(file);
            boolean eof = false;
            int index = -1;
            int counter = 0;
            int pos = 0;
            String line = buff.readLine();
    		StringTokenizer stk = new StringTokenizer(line, ",");
    		a = new Automotive(stk.nextToken(), Float.parseFloat(stk.nextToken()), Integer.parseInt(stk.nextToken()));;
            while (!eof) {
            	line = buff.readLine();
                if (line == null) 
                	eof = true;
                else{
            		stk = new StringTokenizer(line, ",");
                	if(pos >= counter){
                        String s = stk.nextToken();
                        counter = Integer.parseInt(stk.nextToken());
                        a.setValueOptionSet(++index, s, counter);
                        pos = 0;
                	}
                	else{
                		a.setValuesOption(index, pos++, stk.nextToken(), Float.parseFloat(stk.nextToken()));
                	}
                }
            }
            buff.close();
        } catch (IOException e) {
            System.out.println("Cannot open " + fileName);
        }
		return a;
	}
	
	public void serializeAuto(Automotive a, String fileName) throws IOException{
		  try
		  {    
			  //Saving of object in a file 
			  ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName)); 
			  // Method for serialization of object 
			  out.writeObject(a); 
			  out.close(); 
		  } 
		  catch(FileNotFoundException ex) 
		  { 
			  System.out.println("IOException is caught"); 
			  File file = new File(fileName);
			  if (file.createNewFile())
			  {
				  System.out.println("File is created!");
				  serializeAuto( a,  fileName);
			  } else {
				  System.out.println("File already exists.");
			  }
		  } 	  	
	}
	
	public Automotive DeserializeAuto(String fileName){
		Automotive b = null;
		 // Deserialization 
        try
        {    
            // Reading the object from a file 
            FileInputStream file = new FileInputStream(fileName); 
            ObjectInputStream in = new ObjectInputStream(file); 
            // Method for deserialization of object 
            b = (Automotive)in.readObject();    
            in.close(); 
            file.close(); 
        } 
        catch(IOException ex) 
        { 
            System.out.println("IOException is caught"); 
        }  
        catch(ClassNotFoundException ex) 
        { 
            System.out.println("ClassNotFoundException is caught"); 
        } 
		return b;
	}
}
