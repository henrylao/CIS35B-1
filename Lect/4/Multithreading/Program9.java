//import static java.util.concurrent.TimeUnit.SECONDS;
//
//public class Program9{
//  public static void main(String args[]) {
//
//    try {
//      Thread.sleep(1000);
//    } catch (Exception e) {
//    }
//    System.out.println("]");
//  }
//}public class ProgramThread extends Thread {
//	  // This field is volatile because two different threads may access it
//	  volatile boolean keepRunning = true;
//
//	  public ProgramThread() {
//	    setDaemon(true);
//	  }
//
//	  public void run() {
//	    while (keepRunning) {
//	      long now = System.currentTimeMillis();
//	      System.out.printf("%tr%n", now);
//	      try {
//	        Thread.sleep(1000);
//	      } catch (InterruptedException e) {
//	        return;
//	      }
//	    }
//	  }
//	  public void pleaseStop() {
//	    keepRunning = false;
//	  }
//
//	  public static void main(String[] args) {
//	    ProgramThread thread = new ProgramThread();
//	    thread.start();
//	    try {
//	      SECONDS.sleep(10);
//	    } catch (InterruptedException ignore) {
//	    }
//	    thread.pleaseStop();
//	  }
//	}