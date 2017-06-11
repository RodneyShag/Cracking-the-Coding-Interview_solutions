package introduction;

public class Pair {
	int a;
	int b;
	
	Pair(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	@Override
	public String toString() {
		return "(" + a + "," + b + ")";
	}
}
