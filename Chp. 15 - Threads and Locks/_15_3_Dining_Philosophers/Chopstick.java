package _15_3_Dining_Philosophers;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* Code from online solutions */
public class Chopstick {
	private Lock lock;

	public Chopstick() {
		lock = new ReentrantLock();
	}

	public boolean pickUp() {
		return lock.tryLock(); // important that we do .tryLock() instead of
								// .lock()
	}

	public void putDown() {
		lock.unlock();
	}
}
