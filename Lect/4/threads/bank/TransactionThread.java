package bank;

/**
 * Class TransactionThreads creates objects that 
 * contain ThreadLocal variables and illustrates 
 * how these variables work 
 */
public class TransactionThread extends Thread {
   private Transaction tran;
   TransactionThread() {
   	tran = new Transaction();
   }
   public void run() {
      try {
      	doActionA();
      	sleep(50);
      	doActionB();
      	sleep(50);
      	// restart transaction due to rollback or error
      	tran = new Transaction();
      	doActionC();
      	sleep(50);
      } catch (InterruptedException e) {
      	System.out.println("Thread Interrupted");
      }
   }		
   public void doActionA() {
      System.out.println(
      	"Action A for thread-safe id = "
      	+ tran.getThreadTranId()
      	+ ". Transaction instance = "
      	+ tran.getTranId()
      	+ ".");
   }
   public void doActionB() {
      System.out.println(
      	"Action B for thread-safe id = "
      	+ tran.getThreadTranId()
      	+ ". Transaction instance = "
      	+ tran.getTranId()
      	+ ".");
   }
   public void doActionC() {
      System.out.println(
      	"Action C for thread-safe id = "
      	+ tran.getThreadTranId()
      	+ ". Transaction instance = "
      	+ tran.getTranId()
      	+ ".");
   }
}
