package __Intro_Sorts;

import java.util.Arrays;

public class Tester {
	public static void main(String[] args) {
		System.out.println("*** Test Sorts");
		int[] arrayBubble    = {3, 6, 1, 6, 25, 16, 62, -3, -6, 4, 16, 26, 0, 0, 25, 25, -3, -3, 6, 7, 0, 1, 29, 28};
		int[] arraySelection = {3, 6, 1, 6, 25, 16, 62, -3, -6, 4, 16, 26, 0, 0, 25, 25, -3, -3, 6, 7, 0, 1, 29, 28};
		int[] arrayInsertion = {3, 6, 1, 6, 25, 16, 62, -3, -6, 4, 16, 26, 0, 0, 25, 25, -3, -3, 6, 7, 0, 1, 29, 28};
		int[] arrayMerge     = {3, 6, 1, 6, 25, 16, 62, -3, -6, 4, 16, 26, 0, 0, 25, 25, -3, -3, 6, 7, 0, 1, 29, 28};
		int[] arrayQuick     = {3, 6, 1, 6, 25, 16, 62, -3, -6, 4, 16, 26, 0, 0, 25, 25, -3, -3, 6, 7, 0, 1, 29, 28};

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
}
