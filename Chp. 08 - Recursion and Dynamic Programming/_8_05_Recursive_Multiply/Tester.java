package _8_05_Recursive_Multiply;

public class Tester {
	public static void main(String[] args) {
		System.out.println("*** Test 8.5: Recursive Multiply\n");
		test(4, 3);
		test(0, 3);
	}
	
	private static void test(int a, int b) {
		System.out.format("%d * %d = %d\n", a, b, RecursiveMultiply.multiply(a, b));
	}
}
