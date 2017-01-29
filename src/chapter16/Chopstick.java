package chapter16;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* 16.3 - Code from online solutions */
public class Chopstick {
	private Lock lock;
	
	public Chopstick() {
		lock = new ReentrantLock();
	}
	
	public boolean pickUp() {
		return lock.tryLock(); // important that we do .tryLock() instead of .lock()
	}
	
	public void putDown() {
		lock.unlock();
	}
}
