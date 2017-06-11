package _15_3_Dining_Philosophers;

public class Tester {
	public static void main(String[] args) {
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
}
