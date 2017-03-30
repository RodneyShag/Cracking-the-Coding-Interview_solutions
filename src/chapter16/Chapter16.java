package chapter16;

public class Chapter16 {
	public static void main(String[] args) {
		/* Only run 1 of these at a time */
		//test_sixteenPoint3();
		test_sixteenPoint5();

		// 16.1: Read book's short answer
		// 16.2: Skip
		// 16.4: Not Implemented. Answer is to implement a directed graph and use DFS/BFS to detect a cycle. Cycle = deadlock can occur.
		// 16.6: Read book's short answer
	}
	
	public static void test_sixteenPoint3() {
		int numPhilosophers = 3;
		
		Chopstick[] chopsticks = new Chopstick[numPhilosophers + 1];
		for (int i = 0; i < numPhilosophers + 1; i++) {
			chopsticks[i] = new Chopstick();
		}
		
		Philosopher[] philosophers = new Philosopher[numPhilosophers];
		for (int i = 0; i < numPhilosophers; i++) {
			Chopstick left  = chopsticks[leftOf(i)];
			Chopstick right = chopsticks[rightOf(i, numPhilosophers)];
			philosophers[i] = new Philosopher(i, left, right);
		}
		
		for (int i = 0; i < numPhilosophers; i++) {
			philosophers[i].start(); // I believe this will call the Philosopher's overwritten run() method
		}
	}
	
	private static int leftOf(int i) {
		return i;
	}
	
	private static int rightOf(int i, int numPhilosophers) {
		return (i + 1) % numPhilosophers;
	}
	
	public static void test_sixteenPoint5(){
		SixteenPoint5 sixteenPoint5 = new SixteenPoint5();
		
		MyThread thread1 = new MyThread(sixteenPoint5, "first");
		MyThread thread2 = new MyThread(sixteenPoint5, "second");
		MyThread thread3 = new MyThread(sixteenPoint5, "third");
		
		thread3.start();
		thread2.start();
		thread1.start();
	}
}
