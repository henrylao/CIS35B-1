//Using Runnable - enqueue/dequeue from list
//Using Runnable - enqueue/dequeue from list
class Queue {
  int n;

  synchronized int get() {
  	System.out.println("Got: " + n);
	try {  
		Thread.sleep(3000); 
     	} catch (InterruptedException e) { }	
	return n;
  }

  synchronized void put(int n) {
  	this.n = n;
	System.out.println("Put: " + n);
	try {  
		Thread.sleep(3000); 
     	} catch (InterruptedException e) { }	
  }

}

class Consumer implements Runnable {
  Queue q;

  Consumer(Queue q) {
  this.q = q;
  new Thread(this, "Consumer").start();
  }

  public void run() {
    while(true) {
	q.get();      
   }
  }

}

class Producer implements Runnable {
  Queue q;

  Producer(Queue q) {
  this.q = q;
  new Thread(this, "Producer").start();
  }

  public void run() {
   int i = 0;
   while(true) {
      i = i + 1;
      q.put(i);
   }
  }

}

public class Program4{
  public static void main(String args[]) {
  Queue q = new Queue();
  new Consumer(q);
  new Producer(q);
  }
}

