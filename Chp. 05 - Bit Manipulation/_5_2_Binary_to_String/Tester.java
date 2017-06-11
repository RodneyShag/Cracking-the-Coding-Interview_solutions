package _5_2_Binary_to_String;

public class Tester {
	public static void main(String[] args) {
		System.out.println("*** Test 5.2: Binary to String\n");
		test(0.625);
		test(0.3);
	}
	
	private static void test(double decimal) {
		System.out.println("Decimal: " + decimal + "   Binary: " + BinaryToString.printBinary(decimal));
	}
}
