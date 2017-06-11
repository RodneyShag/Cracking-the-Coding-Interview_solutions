package _17_11_Word_Distance;

import java.util.Arrays;

public class Tester {
	public static void main(String[] args) {
		System.out.println("*** Test 17.11: Word Distance\n");
		String[] file = {"hey", "there", "hi", "food", "there", "now", "hope", "hi", "food", "now", "gone", "hey"};
		System.out.println(Arrays.toString(file));
		WordDistance.preProcess(file);
		test(file, "there", "food");
		test(file, "now", "hi");
		test(file, "gone", "hi");
	}
	
	private static void test(String[] file, String s1, String s2) {
		System.out.format("\n(Solution 1) (%s, %s) Distance = %d", s1, s2, WordDistance.shortest(file, s1, s2));
		System.out.format("\n(Solution 2) (%s, %s) Distance = %d\n", s1, s2, WordDistance.shortest2(s1, s2));
	}
}
