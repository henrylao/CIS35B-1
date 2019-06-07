import java.io.*;
public class CreateProblem {
	private String fileName;
	@SuppressWarnings("unused")
	private FileInputStream a1;
	
	CreateProblem() { }
	
	public CreateProblem(String fileName) {
		super();
		this.fileName = fileName;
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	boolean openFile() throws FixProblems
	{
		a1 = null;
		boolean flag = false;
		try {
			a1 = new FileInputStream(fileName);
			System.out.println("Now it is done!");
			flag = true;
		}
		catch(FileNotFoundException f)
		{
			throw new FixProblems();
		}
		finally 
		{			
			
		}
		return flag;	
	}	
}
