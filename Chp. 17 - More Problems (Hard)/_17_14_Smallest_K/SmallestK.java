package _17_14_Smallest_K;

// Find smallest 1 million numbers in 1 billion numbers
// 
// Let "m" be the million numbers and "n" be the billion numbers.
// 
// Solutions        Runtime                                            Preference
// ------------------------------------------------------------------------------------
// 0) Sort          O(n log n)                                         Worth Mentioning
// 1) Max Heap      O(n log m) (Notice it's "m" not "n")               Worth Mentioning
// 2) QuickSelect   O(n) average case, O(n^2) worst case (bad pivot)   Favorite
public class SmallestK {
	// Solution 1 
	// 
	// Max Heap (Using PriorityQueue in Java, which has O(log m) for add() remove())
	// 
	// Algorithm:
	// 	  1) O(m) to build a MAX heap of first 1 million elements (using algo from CS 225), largest element at the top.
	//    2) For each of the remaining "n" entries, if it's smaller than the heap's max element, we insert it into our heap 
	//       by replacing the largest element (top of heap) with it. remove(), add() are O(log m), so total runtime O(n log m)
	
	/* Solution 2 */
	public static void findNthSmallestNums(int[] array, int n) {
		quickselect(array, n);
		for (int i = 0; i < n; i++) {
			System.out.print(array[i] + " ");
		}
	}
	
    // Quickselect 
    //  - Finds "nth" smallest element in an array. Returns its value (Code from Wikipedia)
	//  - Also partially sorts the data. If the value of the nth smallest element is x, all values to the
    //    left of it are smaller than x, and all values to the right of it are greater than x
	//  - O(n) average run-time is since we recurse only on 1 side (n + n/2 + n/4 + ...) = n (1 + 1/2 + 1/4 + ...) = O(n)
	//    Our formula above is a geometric series with "r = 1/2", which would converge to 1/(1-r) for infinite geometric series
	//  - O(n^2) worst-case run-time is if "partition()" consistently picks a bad pivot
	private static Integer quickselect(int[] array, int n) {
		int start = 0;
		int end   = array.length - 1;
	    while (start <= end) {
	    	int pivotIndex = partition(array, start, end);
	        if (pivotIndex == n) {
	            return array[n];
	        } else if (pivotIndex < n) {
	            start = pivotIndex + 1;
	        } else {
	            end = pivotIndex - 1;
	        }
	    }
	    return null;
	}
	
	// Partitions array into 2 parts. 
	// 		1) Left side has values smaller than pivotValue
	// 		2) Right side has values larger than pivotValue
	// Returns pivotIndex
	private static Integer partition(int[] array, int start, int end) {
		if (start > end) {
			return null;
		}
		int pivotIndex = (start + end) / 2; // there are many ways to choose a pivot
		int pivotValue = array[pivotIndex];
		
		swap(array, pivotIndex, end); // puts pivot at end for now.
		
		/* Linear search, comparing all elements to pivotValue and swapping as necessary */
		int indexToReturn = start;	// Notice we set it to "start", not to "0".
		for (int i = start; i < end; i++) {
			if (array[i] < pivotValue) {
				swap(array, i, indexToReturn);
				indexToReturn++;
			}
		}
		
		swap(array, indexToReturn, end); // puts pivot where it belongs
		return indexToReturn;
	}
	
	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
