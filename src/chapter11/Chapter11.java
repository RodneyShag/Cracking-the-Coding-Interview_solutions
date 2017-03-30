package chapter11;

import java.util.Arrays;

public class Chapter11 {
	public static void main(String [] args) {
		test_Sorts();
		test_ElevenPoint1();
		test_ElevenPoint2();
		test_ElevenPoint3();
		// 11.4: No code. Solution: External Sort. See book
		test_ElevenPoint5();
		test_ElevenPoint6();
		// 11.7: Skip it. Same as 9.10's box stacking problem
		test_ElevenPoint8();
	}
	
	public static void test_Sorts() {
		System.out.println("*** Test Sorts");
		int [] arrayBubble    = {3, 6, 1, 6, 25, 16, 62, -3, -6, 4, 16, 26, 0, 0, 25, 25, -3, -3, 6, 7, 0, 1, 29, 28};
		int [] arraySelection = {3, 6, 1, 6, 25, 16, 62, -3, -6, 4, 16, 26, 0, 0, 25, 25, -3, -3, 6, 7, 0, 1, 29, 28};
		int [] arrayInsertion = {3, 6, 1, 6, 25, 16, 62, -3, -6, 4, 16, 26, 0, 0, 25, 25, -3, -3, 6, 7, 0, 1, 29, 28};
		int [] arrayMerge     = {3, 6, 1, 6, 25, 16, 62, -3, -6, 4, 16, 26, 0, 0, 25, 25, -3, -3, 6, 7, 0, 1, 29, 28};
		int [] arrayQuick     = {3, 6, 1, 6, 25, 16, 62, -3, -6, 4, 16, 26, 0, 0, 25, 25, -3, -3, 6, 7, 0, 1, 29, 28};

		System.out.println(Arrays.toString(arrayBubble) + " - Original Array");
		
		Sorts.bubbleSort(arrayBubble);
		System.out.println(Arrays.toString(arrayBubble) + " - BubbleSort");
		
		Sorts.selectionSort(arraySelection);
		System.out.println(Arrays.toString(arraySelection) + " - SelectionSort");

		Sorts.insertionSort(arrayInsertion);
		System.out.println(Arrays.toString(arrayInsertion) + " - InsertionSort");
		
		Sorts.mergeSort(arrayMerge);
		System.out.println(Arrays.toString(arrayMerge) + " - MergeSort");
		
		Sorts.quickSort(arrayQuick);
		System.out.println(Arrays.toString(arrayQuick) + " - QuickSort");
	}
	
	public static void test_ElevenPoint1() {
		System.out.println("\n\n*** Test 11.1: merging arrays");
		int [] array1 = {3, 6, 8, 9, 0, 0, 0, 0};
		int [] array2 = {1, 2, 4, 7};
		ElevenPoint1.merge(array1, array2, 3, 3);
		System.out.println("Merged: " + Arrays.toString(array1));
	}
	
	public static void test_ElevenPoint2() {
		System.out.println("\n\n*** Test 11.2: group anagrams together");
		String [] array  = {"hello", "hi", "ih", "obb", "bob", "helol", "olleh", "god", "loleh", "lolhe", "asd", "nwr", "gsegae", "fesf"};
		String [] array2 = {"hello", "hi", "ih", "obb", "bob", "helol", "olleh", "god", "loleh", "lolhe", "asd", "nwr", "gsegae", "fesf"};
		ElevenPoint2.sort(array2);
		System.out.println("Solution 1: " + Arrays.toString(array));
		System.out.println("Solution 2: " + Arrays.toString(array2));
	}
	
	public static void test_ElevenPoint3() {
		int [] rotatedArray = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
		System.out.println("\n\n*** Test 11.3: Index of value in rotated array");
		for (int i = 0; i < rotatedArray.length; i++) {
			System.out.print(rotatedArray[i] + " ");
		}
		System.out.println("\n5 is at index: " + ElevenPoint3.search(rotatedArray, 5));
	}
	
	public static void test_ElevenPoint5() {
		System.out.println("\n\n*** Test 11.5: Find index of string");
		String [] strings = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
		System.out.println(Arrays.toString(strings));
		System.out.println("\"ball\" is at index: " + ElevenPoint5.find(strings, "ball"));
		System.out.println("\"at\"   is at index: " + ElevenPoint5.find(strings, "at"));	
		System.out.println("\"car\"  is at index: " + ElevenPoint5.find(strings, "car"));
		System.out.println("\"dad\"  is at index: " + ElevenPoint5.find(strings, "dad"));
		System.out.println("\"food\" is at index: " + ElevenPoint5.find(strings, "food"));
	}
	
	public static void test_ElevenPoint6() {
		System.out.println("\n\n*** Test 11.6: Find element in MxN matrix, with rows and columns sorted");
		int [][] array2d = { {1,  6,  8,  9},
							 {3,  8,  9, 11},
							 {6,  9, 11, 15},
							 {7, 14, 17, 22} };
		System.out.println("6 exists: " + ElevenPoint6.findElement(array2d, 6));
		System.out.println("64 exists: " + ElevenPoint6.findElement(array2d, 64));
	}
	
	public static void test_ElevenPoint8() {
		System.out.println("\n\n*** Test 11.7: Rank of numbers");
		int [] array = {5,1,4,4,5,9,7,13,3};
		trackNums(array);
		System.out.println(Arrays.toString(array));
		System.out.println("Rank of 1 = " + ElevenPoint8.getRankOfNumber(1));
		System.out.println("Rank of 3 = " + ElevenPoint8.getRankOfNumber(3));
		System.out.println("Rank of 4 = " + ElevenPoint8.getRankOfNumber(4));
	}
	
	private static void trackNums(int [] array) {
		for (int n : array) {
			ElevenPoint8.track(n);
		}
	}
}
