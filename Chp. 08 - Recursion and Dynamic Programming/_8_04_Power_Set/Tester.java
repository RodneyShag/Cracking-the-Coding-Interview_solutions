package _8_04_Power_Set;

import java.util.ArrayList;

public class Tester {
	public static void main(String[] args) {
		System.out.println("*** Test 8.4: Power Set\n");
		ArrayList<Integer> set = new ArrayList<>();
		set.add(3);
		test(set);
		set.add(4);
		test(set);
		set.add(5);
		test(set);
	}
	
	private static void test(ArrayList<Integer> set) {
		ArrayList<ArrayList<Integer>> subsets = PowerSet.getSubsets(set);
		System.out.println("Original set: " + set);
		System.out.println("Subsets: " + subsets + "\n");
	}
}
