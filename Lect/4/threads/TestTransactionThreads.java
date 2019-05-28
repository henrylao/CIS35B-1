package examples.threads;

import bank.TransactionThread;

/**
 * Class TestTransactionThreads demonstrates 
 * ThreadLocal variables 
 * in the threads that it creates
 */
public class TestTransactionThreads {
   public static void main(String[] args) {   
      for (int i=1; i < 4; i++) {
   	 TransactionThread tThread = new TransactionThread();
   	 tThread.start();
   	 try {
   	   Thread.currentThread().sleep(50);
   	 } catch (InterruptedException e) {}
      }   		
   }
}
