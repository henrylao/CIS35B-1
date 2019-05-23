// Using stop with a sentinel since stop itself is deprecated now.

public class Program3 {
  public static void main(String args[]) {
    Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
    MyThread3 hi = new MyThread3(Thread.NORM_PRIORITY + 2);
    MyThread3 lo = new MyThread3(Thread.NORM_PRIORITY - 2);
    lo.start();
    hi.start();

    try {
      Thread.sleep(10000);
    } catch (Exception e) {
    }

    lo.stop();
    hi.stop();
    System.out.println(lo.click + " vs. " + hi.click);
  }
}

class MyThread3 implements Runnable {
	  public int click = 0;

	  private Thread t;

	  private boolean running = true;

	  public MyThread3(int p) {
	    t = new Thread(this);
	    t.setPriority(p);
	  }

	  public void run() {
	    while (running) {
	      click++;
	    }
	  }

	  public void stop() {
	    running = false;
	  }

	  public void start() {
	    t.start();
	  }
	}

