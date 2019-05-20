public class Hello extends Thread {
	int x;
	Coffee x1;
	int threadno;

	Hello(int x, Coffee x1) {
		this.x = x;
		threadno = x;
		this.x1 = x1;
	}

	public void run() {
		switch (x) {
		case 0:
			System.out.println("Start thread " + threadno + " Get");
			break;
		case 1:
			System.out.println("Start thread " + threadno + " Put");
			break;
		}
		ops();
		System.out.println("Stopping thread " + threadno);

	}

	public void ops() {
		switch (x) {
		case 0:
			x1.get();
			break;
		case 1:
			x1.put(45);
			break;
		}
	}

	public static void main(String[] args) {
		Coffee c1 = new Coffee();
		Hello get = new Hello(0, c1);
		Hello put = new Hello(1, c1);
		get.start();
		put.start();

	}
}
