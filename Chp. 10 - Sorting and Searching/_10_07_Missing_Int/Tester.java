package _10_07_Missing_Int;

import java.util.Arrays;

public class Tester {
	public static void main(String[] args) {
		System.out.println("*** Test 10.3: Missing Int");
		test(new int[]{22, 25, 0, 1, 2, 3, 4, 5, 6, 7, 8, 200, 201, 202});
		test(new int[]{5, 7, 0, 1, 2});
	}
	
	private static void test(int[] input) {
		System.out.println("\ninput: " + Arrays.toString(input));
		MissingInt.findNumber(input);
		MissingInt.findNumber2(input);
	}
}
