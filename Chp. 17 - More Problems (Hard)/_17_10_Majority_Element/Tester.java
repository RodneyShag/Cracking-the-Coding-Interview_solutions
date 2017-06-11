package _17_10_Majority_Element;

import java.util.Arrays;

public class Tester {
	public static void main(String[] args) {
		System.out.println("*** Test 17.10: Majority Element");
		test(new int[]{1,2,5,9,5,9,5,5,5});
		test(new int[]{3,1,7,1,1,7,7,3,7,7,7});
		test(new int[]{1,2,2,3});
	}
	
	private static void test(int[] array) {
		System.out.print("\n" + Arrays.toString(array) + "\nmajority element = ");
		System.out.println(MajorityElement.majorityElement(array));
	}
}
