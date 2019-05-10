//============================================================================
// Project     : La3
// Name        : ProxyAutomobile.java
// Author      : Tianqi Yang
// Time        : 5/6/2019
// IDE         : Eclipse
// Description : it is the parent class of buildAuto and contains the code of
// the methods
//============================================================================
package adapter;
import java.io.*;


import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.LinkedHashMap;
import exception.*;
import model.*;
import util.*;

public abstract class ProxyAutomobile  {//acting as a delegate
	
	private static LinkedHashMap<String, Automobile> cars;
	
	private static int [] error;
	
	private String errorFile = "errorFile.dat";
	private static Automobile a1;
	public void setOptionChoice(String modelName, String optionSetName, String optionName) {
		//cars.get(modelName).setOptionChoice(optionSetName, optionName);
		a1.setOptionChoice(optionSetName, optionName);
	}
	
	public void BuildAuto(String filename) {
		FileIO file = new FileIO();
		a1 = file.readFile(filename);
		//cars.put(a.getMake(), a);
		error = new int [4];
		Arrays.fill(error, -1);
		getErrors();
		fixErrors();
		//clearError();
	}
	
	public void printAuto(String modelName) {
		System.out.println(a1.toString());
//		if (cars.isEmpty()) {
//			System.out.println("The object is empty, error number = 301" );
//			saveErrors(301);
//		}else{
//			if(cars.get(modelName) == null ) {
//				saveErrors(304);//no such object
//			}
//			else {
//				System.out.println( cars.get(modelName).toString());
//			}
//		}
	}
	
	public void updateOptionSetName(String modelName, String OptionSetname, String newName) {
		boolean isError = cars.get(modelName).updateOptionSetName(OptionSetname, newName);
		if(error[2] == -1 && isError != true) {
			System.out.println("UpdateOptionSetName fail, error number = 302" );
			saveErrors(302); // 302
		}
	}
	
	public void updateOptionPrice(String modelName, String optionName, String option, float newPrice) {
		boolean isError = cars.get(modelName).updateOptionPrice(optionName, option, newPrice);
		if(error[3] == -1 && isError != true) {
			System.out.println("UpdateOptionPrice fail, error number = 303" );
			saveErrors(303); // 303
		}
	}
	
	public String fix() {
		return null;
	}
	
	public String fix(int i) {
		Helper301to400 h4 = new Helper301to400();
		switch(i) {
			case 301:
				return h4.fix301();
			case 302:
				return h4.fix302();
			case 303:
				return h4.fix303();
		}
		return "";
	}
	
	public void getErrors() {
		try {
	         BufferedReader buff = new BufferedReader(new FileReader(errorFile));
		     boolean eof = false;
		     int in = 0;
		     while (!eof) {
		    	 String line = buff.readLine();
		    	 if (line == null)
	                	eof = true;
	             else 
	            	 error[in] = Integer.parseInt(line);
		    	in++;
		     }
		     buff.close();
		} catch (IOException e) {
			saveErrors(0);
		}
	}
	
	public void fixErrors() {
		for(int i = 0; i<error.length; i++) {
			if(error[i] != -1) {
				String temp = fix(error[i]);
				StringTokenizer stk = new StringTokenizer(temp, ",");
//				if(error[i] == 302){
//					a1.updateOptionSetName(stk.nextToken(), stk.nextToken());
//				}
			}
		}
	}
	
	public void saveErrors(int i) {
		FileWriter wr;
		try {
			wr = new FileWriter(new File(errorFile), true);
			BufferedWriter buffer = new BufferedWriter(wr);
			buffer.write(Integer.toString(i));
			buffer.write("\n");
			buffer.close();
			wr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void clearError() {
		File f = new File(errorFile);
		if(f.exists()) {
			f.delete();
		}
	}
}