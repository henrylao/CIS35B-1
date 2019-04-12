public class CatchAndFix {

	/**
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
		
		boolean problemFixed = false;
		System.out.println("Inside main");
		CreateProblem myproblem = new CreateProblem("filenamethatdoesnotexist.txt"); 
		do {
			try {
				problemFixed = myproblem.openFile();
			}
			catch(FixProblems e)
			{
				myproblem.setFileName(e.fixProblemReadFromConsole()); 
			}
		}while(problemFixed == false);
		

	}

}
