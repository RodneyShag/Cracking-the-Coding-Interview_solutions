package _8_07_Permutations_without_Dups;

import java.util.ArrayList;

public class Tester {
	public static void main(String[] args) {
		System.out.println("*** Test 8.7: Permutations without Dups\n");
		test("cat");
	}
	
	private static void test(String str) {
		ArrayList<String> permutations = PermutationsWithoutDups.getPermutations(str);
		System.out.println("Original string: " + str);
		System.out.println("Permutations: " + permutations + "\n");
	}
}
