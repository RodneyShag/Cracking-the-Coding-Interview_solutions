package chapter11;

public class BinarySearch {	

	/*****************************/
	/* Binary Search - Recursive */  // my preferred version
	/*****************************/
	public static Integer BinarySearchRecursive(int [] array, int value) {
		return BinarySearchHelper(array, value, 0, array.length - 1);
	}
	
	/* Since this is tail-recursive, the compiler will optimize it to iterative code */
	private static Integer BinarySearchHelper(int [] array, int value, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = (start + end) / 2; // to avoid integer overflow, can say: mid = start + ((end - start) / 2)
		if (array[mid] > value) {
			return BinarySearchHelper(array, value, start, mid - 1);
		} else if (array[mid] < value) {
			return BinarySearchHelper(array, value, mid + 1, end);
		} else {
			return mid;	// Returns index
		}
	}
	
	/*****************************/
	/* Binary Search - Iterative */
	/*****************************/
	public static Integer BinarySearchIterative(int [] array, int value) {
		int start = 0;
		int end = array.length - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (array[mid] > value) {
				end = mid - 1;
			} else if (array[mid] < value) {
				start = mid + 1;
			} else {
				return mid;	
			}
		}
		return null;
	}
}
