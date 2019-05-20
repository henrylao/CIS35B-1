//Hello Threads
class ThreadX extends Thread {
  
  public void run() {
    try {
      while(true) {
        Thread.sleep(2000);
        System.out.println("Hello");
      }
    }
    catch(InterruptedException ex) {
      ex.printStackTrace();
    }
  }
}

public class Program1{

  public static void main(String args[]) {
    
    ThreadX tx = new ThreadX();
    tx.start();
  }
}