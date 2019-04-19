//============================================================================
// Project     : Lab2
// Name        : FileIO.java
// Author      : Tianqi Yang
// Time        : 4/18/2019
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
            a = buildObject(a, line);
            while (!eof) {
            	line = buff.readLine();
                if (line == null) 
                	eof = true;
                else{
                	if(pos >= counter){//if there is no more option need to be read
                		counter = createOptionSet( a,  line, pos,  ++index) ;
                        pos = 0;
                	}
                	else{
                		createOption( a,  line,  index,  pos++);
                	}
                }
            }
            buff.close();
        } catch (IOException e) {
            System.out.println("Cannot open " + fileName);
        }
		return a;
	}
	public Automotive buildObject(Automotive a, String line) {
		StringTokenizer stk = new StringTokenizer(line, ",");
		return new Automotive(stk.nextToken(), Float.parseFloat(stk.nextToken()), Integer.parseInt(stk.nextToken()));
	}
	public int createOptionSet(Automotive a, String line,int pos, int index) {
		StringTokenizer stk = new StringTokenizer(line, ",");
		String name = stk.nextToken();
        int size = Integer.parseInt(stk.nextToken());
        a.setValueOptionSet(index, name, size);//optionSetIndex, optionSetName, optionSetSize
        return size;
	}
	public void createOption(Automotive a, String line, int index, int pos) {
		StringTokenizer stk = new StringTokenizer(line, ",");
		a.setValuesOption(index, pos, stk.nextToken(), Float.parseFloat(stk.nextToken()));//optionSetIndex, optionIndex, optionName, optionPrice
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
	
	public Automotive deserializeAuto(String fileName){
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
