
public class FixProblems extends Exception {
	private int errorno; // error number;
	private String errormsg; // error message;
	
	public FixProblems() {
		super();
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
		String a = "fixed.txt";
		System.out.println("got here --> fixProblemReadFromConsole");
		return a;
	}
	

}
