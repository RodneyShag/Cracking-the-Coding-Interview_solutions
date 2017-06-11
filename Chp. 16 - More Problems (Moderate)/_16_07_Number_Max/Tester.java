package _16_07_Number_Max;

public class Tester {
	public static void main(String[] args) {
		System.out.println("*** Test 16.7: Number Max\n");
		System.out.print("0 means negative, 1 means positive");
		
		testSign(-61);
		testSign(-252);
		testSign(61);
		testSign(252);
		System.out.println();
		
		testMax(-3, -5);
		testMax(0, 8);
		testMax(-3, 5);		
	}
	
	private static void testSign(int n) {
		System.out.format("\n%4d (Sign): %d", n, NumberMax.sign(n));
	}
	
	private static void testMax(int a, int b) {
		System.out.format("\nmax(%2d, %2d): %2d", a, b, NumberMax.max(a,  b));
	}
}
