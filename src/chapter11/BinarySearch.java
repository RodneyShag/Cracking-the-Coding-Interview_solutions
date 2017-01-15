package chapter11;
/* Binary Search - Recursive and Iterative Versions. I prefer the recursive version */
public class BinarySearch {
	
	/*****************************/
	/* Binary Search - Iterative */
	/*****************************/
	public static int BinarySearchIterative(int [] array, int value){
		int start = 0;
		int end = array.length -1;
		int mid;	//must set it to a value inside the loop. I messed this up originally
		while (start <= end){
			mid = (start + end) / 2;
			if (array[mid] > value)
				end = mid - 1;
			else if (array[mid] < value)
				start = mid + 1;
			else
				return mid;	
		}
		return -1; //ideally would throw an exception
	}
	

	/*****************************/
	/* Binary Search - Recursive */
	/*****************************/
	public static int BinarySearchRecursive(int [] array, int value){
		return BinarySearchHelper(array, value, 0, array.length - 1);
	}
	
	/* Since this is tail-recursive, the compiler will optimize this to iterative code */
	private static int BinarySearchHelper(int [] array, int value, int start, int end){
		if (start > end)
			return -1;	//ideally would throw an exception
		int mid = (start + end) / 2;
		if (array[mid] > value)
			return BinarySearchHelper(array, value, start, mid - 1);
		else if (array[mid] < value)
			return BinarySearchHelper(array, value, mid + 1, end);
		else
			return mid;	//returns index, not value.
	}
}
