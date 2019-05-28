//============================================================================
//Project     : Lab4
//Name        : FixProblems.java
//Author      : Tianqi Yang
//Time        : 5/6/2019
//IDE         : Eclipse
//Description : it is the child class of Exception and print out the exception
//============================================================================
package exception;

import java.io.*;
import java.text.SimpleDateFormat;

import adapter.FixAuto;

public class AutoException extends Exception implements FixAuto{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6340849508326297449L;
	private int errorno;
	private String errormsg;
	private String loggingName="logging.txt";
	
	public AutoException() {
		super();
	}

	public String fix() {
		Helper1to100 h1 = new Helper1to100();
		Helper101to200 h2 = new Helper101to200();
		Helper201to300 h3 = new Helper201to300();

		switch(errorno) {

			case 1://Cannot open file
				return h1.fix1();	
			case 2://First line is not correct
				return h1.fix2();	
			case 3://Cannot create optionSet
				return h1.fix3();	
			case 4://Cannot create option
				return h1.fix4();		
			case 101:
				return h2.fix101();
			case 201://Cannot open logging
				return h3.fix201();
		}
		return "";
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
		return null;
	}
	public AutoException(int errorno, String errormsg) {
		super();
		this.errorno = errorno;
		this.errormsg = errormsg;
		System.out.print(printmyproblem());
		try {
			logging();
		} catch (AutoException e) {
			((FixAuto) e).fix();
		}
	}
	
	public int getErrorno() {
		return errorno;
	}
	
	public void setErrorno(int errorno) {
		this.errorno = errorno;
	}
	
	public String getErrormsg() {
		return errormsg;
	}
	
	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}
	
	public String printmyproblem() {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());			
		StringBuffer s = new StringBuffer(timeStamp);
		s.append(" FixProblems errorno = ").append(errorno).append(", errormsg = ").append(errormsg).append("\n");
		return s.toString(); 
	}
	
	public void logging() throws AutoException{
		try {
			FileWriter wr = new FileWriter(new File(loggingName), true);
			BufferedWriter buffer = new BufferedWriter(wr);
			buffer.write(printmyproblem());
			buffer.close(); 
			wr.close();
		} catch (IOException e) {
			throw new AutoException(201, "Cannot open logging"); 		
		}
	}

	
}
