package _16_08_English_Int;

public class Tester {
	public static void main(String[] args) {
		System.out.println("*** Test 16.8: English Int");
		for (int i = 0; i < 23; i++) {
			test(i);
		}
		test(1000);
		test(2998);
		test(253513);
		test(10090034);
	}
	
	private static void test(int n) {
		System.out.format("\n%d: %s", n, EnglishInt.numToString(n));
	}
}
