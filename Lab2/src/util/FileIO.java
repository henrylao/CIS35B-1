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
import exception.*;
import java.io.*;
import java.util.*;

public class FileIO {
	
	public Automotive readFile(String fileName) {
		Automotive a = null;
		BufferedReader buff = null;
        boolean nextStep = false;
		while(nextStep == false){
			try {
				buff = openFile(fileName);
				nextStep = true;
			}catch(AutoException | FileNotFoundException e) {
				fileName = ((FixAuto) e).fix();
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
				line = ((FixAuto) e).fix();
			}
        }
		nextStep = false;
		boolean eof = false;
		int index = -1;
		int counter = 0;
		int pos = 0;
		//int lineCounter = 2;
		while (!eof) {
			try {
				line = buff.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (line == null)
				eof = true;
			else{
				if(pos >= counter){//if there is no more option need to be read
					index++;
					while(nextStep == false){
						try {
							counter = createOptionSet( a, line, index);
							nextStep = true;
							pos = 0;
						} catch (AutoException |NumberFormatException e) {
							line = ((FixAuto) e).fix();
						}
					}
					nextStep = false;
				}
				else{
					while(nextStep == false){
						try {
							createOption( a, line, index, pos);
							nextStep = true;
						} catch (AutoException | NumberFormatException e) {
							line = ((FixAuto) e).fix();
						}
					}
					nextStep = false;
					pos++;
				}
			}
		}
        try {
			buff.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        //check if the option set is full
        try {
        	if(index+1 < a.getOptionSetSize()) {
        		System.out.println(index);
        		throw new AutoException(102, "Not enough optionSet");
        	}
        }catch( AutoException e) {
			((FixAuto) e).fix();
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
			throw new AutoException(101, "Cannot open file");
		}
	} 
	

	public Automotive buildObject(Automotive a, String line) throws AutoException {
		try {
			StringTokenizer stk = new StringTokenizer(line, ",");
			a = new Automotive(stk.nextToken(), Float.parseFloat(stk.nextToken()), Integer.parseInt(stk.nextToken()));
			return a;
		}catch(NoSuchElementException e){
			throw new AutoException(1, "First line is not correct"); 
		}
	}
	
	public int createOptionSet(Automotive a, String line, int index) throws AutoException {
		try {
			StringTokenizer stk = new StringTokenizer(line, ",");
			String name = stk.nextToken();
	        int size = Integer.parseInt(stk.nextToken());
	        a.setValueOptionSet(index, name, size);//optionSetIndex, optionSetName, optionSetSize
	        return size;
		}catch(NoSuchElementException | NumberFormatException e){
			System.out.print(line);
			System.out.println("  !!!This line is not complete");
			throw new AutoException(2, "Cannot create optionSet"); 
		}
		
	}
	
	public void createOption(Automotive a, String line, int index, int pos) throws AutoException {
		try {
			StringTokenizer stk = new StringTokenizer(line, ",");
			a.setValuesOption(index, pos, stk.nextToken(), Float.parseFloat(stk.nextToken()));//optionSetIndex, optionIndex, optionName, optionPrice
		}catch(NoSuchElementException | NumberFormatException e){
			System.out.print(line);
			System.out.println("  !!!This line is not complete");
			throw new AutoException(3, "Cannot create option"); 
		}
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
