package chapter18;

import chapter11.Sorts;

/* Find smallest 1 million numbers in 1 billion numbers
 * 
 * Let "m" be the million numbers and "n" be the billion numbers.
 * 
 * Solutions        Runtime                                            Preference
 * ------------------------------------------------------------------------------------
 * 1) Sort          O(n log n)                                         Worth Mentioning
 * 2) Max Heap      O(n log m) (Notice it's "m" not "n")               Worth Mentioning
 * 3) QuickSelect   O(n) average case, O(n^2) worst case (bad pivot)   Favorite
 */
public class EighteenPoint06 {
	
	/* Solution 2 
	 * 
	 * Max Heap (Using PriorityQueue in Java, which has O(log m) for add() remove())
	 * 
	 * Algorithm:
	 * 	  1) O(m) to build a MAX heap of first 1 million elements (using algo from CS 225), largest element at the top.
	 *    2) For each of the remaining "n" entries, if it's smaller than the heap's max element, we insert it into our heap 
	 *       by replacing the largest element (top of heap) with it. remove(), add() are O(log m), so total runtime O(n log m)
	 */
	
	/* Solution 3 */
	
	public static void findNthSmallestNums(int [] array, int n){
		if (array == null || n < 0 || n >= array.length)
			return;
		
		int nthSmallestValue = quickselect(array, 0, array.length - 1, n);
		
		/* Do O(n) Go through entire array and print all elements smaller than nthSmallestValue (i.e. prints n smallest elements) */
		for (int i = 0; i < array.length; i++){
			if (array[i] < nthSmallestValue)
			  System.out.print(array[i] + " ");
		}
	}
	
	/* Quickselect - Finds "nth" smallest element in an array. Returns its value. (Code from Wikipedia)
	 * 
	 * Notes:
	 *  - also "partially sorts the data" - Wikipedia
	 *  - O(n) average run-time is since we recurse only on 1 side (n + n/2 + n/4 + ...) = n (1 + 1/2 + 1/4 + ...) = O(n).
	 *    Notice our formula above is a geometric series with "r = 1/2", which would converge to 1/(1-r) for infinite geometric series
	 *  - O(n^2) worst-case run-time is if we consistently pick a bad pivot
	 */
	private static Integer quickselect(int [] array, int start, int end, int n){
		if (n < 0 || n >= array.length || start < 0 || start >= array.length || end < 0 || end >= array.length)
			return null;
		
		if (start == end)			// a 1-element array is our base case
			return array[start];
		
		int pivotIndex = Sorts.partition(array, start, end);
		
		/* Recurse on only 1 side, until found */
		if (n == pivotIndex)
			return array[pivotIndex];
		else if(n < pivotIndex)
			return quickselect(array, start, pivotIndex - 1, n);
		else
			return quickselect(array, pivotIndex + 1, end, n);
	}
}
