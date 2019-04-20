package exception;

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
		switch(x) {
		case 1:
			Helper1to100 h1 = new Helper1to100();
			h1.fix1();
			break;
		case 2:
		case 3:
		}
		return "";
	} 
}