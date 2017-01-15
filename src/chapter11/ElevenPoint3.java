package chapter11;
	/* Clever Algorithm. 
	 * - Trick is knowing that the endpoints of the array tell us information
	 * - This code is easier than it looks. We just apply binary search to either LEFT, RIGHT or both subarrays depending on our algorithm
	 * - Annoying edge case when array[start] == array[mid]. 
	 * Runtime: O(log n) average case, but O(n) worst case if there are many duplicates.
	 */

public class ElevenPoint3 {
	public static int search(int [] array, int x){
		return search(array, x, 0, array.length - 1);
	}
	

	public static int search(int [] array, int x, int start, int end){
		if (start > end)
			return -1;
		
		int mid = (start + end) / 2;
		if (array[mid] == x)
			return mid;

		if(array[start] < array[mid]){	//left is ordered correctly
			if(x >= array[start] && x < array[mid])
				return search(array, x, start, mid - 1);
			else
				return search(array, x, mid + 1, end);
		}
		else if (array[start] > array[mid]){
			if(x > array[mid] && x <= array[end])
				return search(array, x, mid + 1, end);
			else
				return search(array, x, start, mid - 1);
		}
		else {	// (array[start] == array[mid])
			if (array[end] != array[mid]){
				return search(array, x, mid + 1, end);
			}
			else{
				/* Search left half */
				int leftResult = search(array, x, start, mid - 1);
				if (leftResult != -1)
					return leftResult;
				
				/* Search right half */
				return search(array, x, mid + 1, end);
			}
		}
	}
}
