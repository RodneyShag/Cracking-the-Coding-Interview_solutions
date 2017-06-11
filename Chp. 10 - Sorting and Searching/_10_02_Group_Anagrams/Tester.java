package _10_02_Group_Anagrams;

import java.util.Arrays;

public class Tester {
	public static void main(String[] args) {
		System.out.println("*** 10.2: Group Anagrams");
		String[] arrayA = {"hello", "hi", "ih", "obb", "bob", "helol", "olleh", "god", "loleh", "lolhe", "asd", "nwr", "gsegae", "fesf"};
		String[] arrayB = {"hello", "hi", "ih", "obb", "bob", "helol", "olleh", "god", "loleh", "lolhe", "asd", "nwr", "gsegae", "fesf"};
		test(arrayA, arrayB);
	}
	
	private static void test(String[] arrayA, String[] arrayB) {
		GroupAnagrams.groupAnagrams(arrayB);
		System.out.println("\n" + Arrays.toString(arrayA));
		System.out.println(Arrays.toString(arrayB));
	}
}
