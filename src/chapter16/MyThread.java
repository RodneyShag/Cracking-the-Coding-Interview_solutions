package chapter16;

/* Code from online solutions */
public class MyThread extends Thread {
	private String method;
	private SixteenPoint5 foo;
	
	public MyThread(SixteenPoint5 foo, String method) {
		this.method = method;
		this.foo = foo;
	}
	
	@Override
	public void run() {
		if (method == "first") {
			foo.first();
		} else if (method == "second") {
			foo.second();
		} else if (method == "third") {
			foo.third();
		}
	}
}
