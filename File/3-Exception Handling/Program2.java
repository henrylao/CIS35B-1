public class Program2 {
	public void test() throws CustomException  {			// potentially throw customException
		throw new CustomException("Houston...we have a problem");
	}

	public static void main(String[] args) {
		Program2 p = new Program2();
		try {
			p.test();
		} catch (CustomException e) {
			System.out.println("Custom exception: " + e.getMessage());
		}
	}

}
