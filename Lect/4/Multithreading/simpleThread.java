//Many threads of the same class and each has its own name.
public class simpleThread extends Thread
{
	private int countDown = 5;
	private int threadNumber;
	private static int threadCount = 0;
	
	public simpleThread()
	{
		threadNumber = ++threadCount;
		System.out.println("Making "+ threadNumber);
	}

	public void run()
	{
		while(true)
		{
			System.out.println("Thread "+ threadNumber + " ( "+countDown + " ) ");
			if(--countDown == 0)
				return;
		}
	}

	public static void main (String[] args)
	{
		for(int I = 0; I < 5; I++)
			new simpleThread().start();
		System.out.println("All threads started");
	}
}