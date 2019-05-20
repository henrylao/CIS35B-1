// Using stop with a sentinel since stop itself is deprecated now.
class MyThread implements Runnable {
  public int click = 0;

  private Thread t;

  private boolean running = true;

  public MyThread(int p) {
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

public class Program3 {
  public static void main(String args[]) {
    Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
    MyThread hi = new MyThread(Thread.NORM_PRIORITY + 2);
    MyThread lo = new MyThread(Thread.NORM_PRIORITY - 2);
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


