package __Intro_Examples;

public class Main {
	public static void main (String [] args) {
		/* Only run 1 of these at a time */
		//test_RunnableThreadExample();
		//test_ThreadExample();
		//test_DifferentReferences();
		//test_SameReferences();
		test_Locks();
	}
	
	public static void test_RunnableThreadExample() {
		RunnableThreadExample instance = new RunnableThreadExample();
		Thread thread = new Thread(instance);
		thread.start();
		
		/* waits until above thread counts to 5 (slowly) */
		while (instance.count != 5) {
			try {
				Thread.sleep(250);
			} catch (InterruptedException exc) {
				exc.printStackTrace();
			}
		}
	}
	
	public static void test_ThreadExample() {
		ThreadExample instance = new ThreadExample();
		instance.start();
		
		while (instance.count != 5) {
			try {
				Thread.sleep(250);
			} catch (InterruptedException exc) {
				exc.printStackTrace();
			}
		}
	}
	
	public static void test_DifferentReferences() {
		/* Difference references - both threads can call MyObject.foo() */
		MyObject objl = new MyObject();
		MyObject obj2 = new MyObject();
		MyClass threadl = new MyClass(objl, "1");
		MyClass thread2 = new MyClass(obj2, "2");
		threadl.start();
		thread2.start();
	}
	
	public static void test_SameReferences() {
		/* Same reference to obj. Only one will be allowed to call foo, and the other will be forced to wait. */
		MyObject obj = new MyObject();
		MyClass threadl = new MyClass(obj, "1");
		MyClass thread2 = new MyClass(obj, "2");
		threadl.start();
		thread2.start();
	}
	
	public static void test_Locks() {
		LockedATM atm = new LockedATM();
		System.out.println("Balance = " + atm.getBalance());
		atm.deposit(20);
		System.out.println("Balance = " + atm.getBalance());
		atm.withdraw(50);
		System.out.println("Balance = " + atm.getBalance());
	}
}
