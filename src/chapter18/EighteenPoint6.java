package chapter18;

public class EighteenPoint6 {
	/* Solution 1: Sort
	 * Sort the numbers (O(n log n)). 
	 */
	
	/* Solution 2: Heap (in a special way...see book explanation)
	 * - O(n) to build a MAX heap of first 1 million elements (largest element at the top)
	 * - O(n log m) to remove the largest element (at top of heap), replace it with an entry, and heapifyDown (which is O(log m)). Do
	 *              this n times. (Notice it's O(n log m), with an "m" not an "n")
	 * (...maybe PriorityQueue's internal representation is a heap?)
	 */
	
	/* Solution 3: QUICKSELECT (Finds ith smallest element (counting from 0) in average case O(n) time)
	 * Book uses "Selection Rank" Algorithm. I like the "Quickselect" algorithm from Wikipedia better, which is coded below 
	 * https://en.wikipedia.org/wiki/Quickselect 
	 * */
	
	/* "Once you have found the ith smallest element, you can run through the array to find all values less than or equal to this element." */
	public static void select(int [] array, int n){
		if (n >= array.length)
			return;	//bad input, so do nothing
		
		int nthSmallestValue = quickselect(array, 0, array.length - 1, n);
		/* Go through entire array and print all elements smaller than nthSmallestValue (i.e. prints n smallest elements) */
		for (int i = 0; i < array.length; i++){
			if (array[i] < nthSmallestValue)
			  System.out.print(array[i] + " ");
		}
	}
	
	/* Coded from Wikipedia. Same exact algo as in QuickSort */
	public static int partition(int [] array, int left, int right){ //we're given the pivotIndex in this implementation.
		int pivotIndex = (left + right) /2;
		int pivotValue = array[pivotIndex];
		swap(array, pivotIndex, right);
		int indexToReturn = left;
		for (int i = left; i < right; i++){
			if (array[i] < pivotValue){
				swap(array, i, indexToReturn);
				indexToReturn++;
			}
		}
		swap(array, indexToReturn, right);
		return indexToReturn;
	}
	
	/* Coded from Wikipedia - Finds "nth" smallest element in an array. Returns its value. 
	 * Quickselect side-effect: "Paritally sorts the data" - wiki 
	 * It's O(n) average run-time, O(n^2) worst-case. Wiki had some info but unclear. See:
	 * 		http://stackoverflow.com/questions/5945193/average-runtime-of-quickselect
	 */
	public static int quickselect(int [] array, int left, int right, int n){		//assumes n < array.length
		if (left == right)			//difficult to see why this base case is correct.
			return array[left];
		
		int pivotIndex = partition(array, left, right);
		
		if (n == pivotIndex)
			return array[pivotIndex];
		else if(n < pivotIndex)
			return quickselect(array, left, pivotIndex - 1, n);
		else
			return quickselect(array, pivotIndex + 1, right, n);
	}
	
	private static void swap(int [] array, int i, int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
