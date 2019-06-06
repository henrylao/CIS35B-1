//============================================================================
// Project     : Lab5
// Name        : FileIO.java
// Author      : Tianqi Yang
// Time        : 5/29/2019
// IDE         : Eclipse
// Description : read the file and creates the Automotive object. It has 
// functions to de-serialize and seriablize the object from and to the file.
//============================================================================
package util;
import model.*;
import exception.*;
import java.io.*;
import java.util.*;

public class FileIO {
	
	public Automobile readFile(String fileName) {
		Automobile a = null;
		BufferedReader buff = null;
        boolean nextStep = false;
        
		while(nextStep == false){
			try {
				buff = openFile(fileName);
				nextStep = true;
			}catch(AutoException | FileNotFoundException e) {
				fileName =  ((AutoException) e).fix();
			}
        }
		nextStep = false;
		String line = null; 
    	try {
			line = buff.readLine();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		while(nextStep == false){
			try {
		        a = buildObject(a, line);
		        nextStep = true;
			}catch(AutoException | NumberFormatException e) {
				line = ((AutoException) e).fix();
			}
        }
		nextStep = false;
		boolean eof = false;
		int index=-1;
		while (!eof) {
			try {
				line = buff.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (line == null)
				eof = true;
			else{
				if(line.charAt(0) == '0'){
					try {
						createOptionSet( a, line);
						index++;
						nextStep = true;
					} catch (AutoException | NumberFormatException e) {
						line = ((AutoException) e).fix();
					}
				}else{
					try {
						createOption( a, line, index);
						nextStep = true;
					} catch (AutoException | NumberFormatException e) {
						line = ((AutoException) e).fix();
					}
				}
			}
		}
        try {
			buff.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return a;
	}

	public BufferedReader openFile(String fileName) throws AutoException, FileNotFoundException {
		try {
			FileReader file = new FileReader(fileName);
			BufferedReader buff = new BufferedReader(file);
			return buff;
		}
		catch(FileNotFoundException e) {
			throw new AutoException(1, "Cannot open file");
		}
	} 
	

	public Automobile buildObject(Automobile a, String line) throws AutoException {
		try {
			StringTokenizer stk = new StringTokenizer(line, ",");
			a = new Automobile(stk.nextToken(), stk.nextToken(), stk.nextToken(), Float.parseFloat(stk.nextToken()));
			return a;
		}catch(NoSuchElementException e){
			throw new AutoException(2, "First line is not correct"); 
		}
	}
	
	public void createOptionSet(Automobile a, String line) throws AutoException {
		try {
			StringTokenizer stk = new StringTokenizer(line, "0");
	        a.setValueOptionSet(stk.nextToken());//optionSetName
		}catch(NoSuchElementException | NumberFormatException e){
			System.out.print(line);
			System.out.println("  !!!This line is not complete");
			throw new AutoException(3, "Cannot create optionSet"); 
		}
	}
	
	public void createOption(Automobile a, String line, int index) throws AutoException {
		try {
			StringTokenizer stk = new StringTokenizer(line, ",");
			a.setValuesOption(index, stk.nextToken(), Float.parseFloat(stk.nextToken()));//optionSetIndex, optionName, optionPrice
		}catch(NoSuchElementException | NumberFormatException e){
			System.out.print(line);
			System.out.println("  !!!This line is not complete");
			throw new AutoException(4, "Cannot create option"); 
		}
	}
	
	public void serializeAuto(Automobile a, String fileName) throws IOException{
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
	
	public Automobile deserializeAuto(String fileName){

		Automobile b = null;
		 // Deserialization 
        try
        {    
            // Reading the object from a file 
            FileInputStream file = new FileInputStream(fileName); 
            ObjectInputStream in = new ObjectInputStream(file); 
            // Method for deserialization of object 
            b = (Automobile)in.readObject();    
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
	public Automobile buildAutoProperties(Properties props) {
    	Automobile auto = new Automobile();
    	String CarMake = props.getProperty("Make");
    	if(!CarMake.equals(null)) {
    		auto.setMake(CarMake);
    		auto.setModel(props.getProperty("Model"));
    		auto.setYear(props.getProperty("Year"));
    		auto.setBasePrice(Float.parseFloat(props.getProperty("BasePrice")));
    		int setNum = Integer.parseInt(props.getProperty("00"));
            for(int i = 1; i <= setNum; i++) {
            	int opsSize = Integer.parseInt(props.getProperty(i+"0"));
            	char character = 'a';
            	for(int j = 0; j < opsSize; j++ ) {
            	    auto.setValueOptionSet(props.getProperty(Integer.toString(i)));
                    auto.setValuesOption(i,props.getProperty(Integer.toString(i)+character), Float.parseFloat(props.getProperty(Integer.toString(i)+character+1)));
            		character += 1;
            	}
            }
        }
    	return auto;
    }
	
}
