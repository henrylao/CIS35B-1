package exception;
import java.util.Arrays;

//============================================================================
//Project     : Lab2
//Name        : FixProblems.java
//Author      : Tianqi Yang
//Time        : 4/18/2019
//IDE         : Eclipse
//Description : it is the child class of Exception and print out the exception
//============================================================================
public class FixProblems extends Exception{
	private int errorno;
	private String errormsg;
	public FixProblems() {
		super();
		logproblem("");
	}
	public void logproblem(String x) {
		
	}

	public String fix(int x) {
		String resp = "";
		switch(x) {
		case 1://cannot open file
			System.out.println("in fix function");
			Helper1to100 h1 = new Helper1to100();
			resp = h1.fix1();
			break;
		case 2:
			
		case 3:
		}
		return resp;
	} 
	public FixProblems(int errorno) {
		super();
		this.errorno = errorno;
		printmyproblem();
	}
	
	public FixProblems(int errorno, String errormsg) {
		super();
		this.errorno = errorno;
		this.errormsg = errormsg;
		printmyproblem();
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
	
	public void printmyproblem() {
		System.out.println("FixProblems [errorno=" + errorno + ", errormsg=" + errormsg); 
	}

	public String fixProblemReadFromConsole()
	{
		String a = "/Users/home/Desktop/1.txt";
		System.out.println("got here --> fixProblemReadFromConsole");
		return a;
	}
}