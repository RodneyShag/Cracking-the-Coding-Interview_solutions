package __Intro_Sorts;

// Sort                 Runtime      Space      Notes
// ---------------------------------------------------------
// 1) Bubble Sort       O(n^2)       O(1)       Best case is O(n) runtime if list is already almost sorted
// 2) Selection Sort    O(n^2)       O(1)
// 3) Insertion Sort	O(n^2)       O(1)
// 4) Merge Sort        O(n log n)   O(n)
// 5) Quick Sort        O(n^2)       O(log n)   Average Case Runtime: O(n log n)

public class Sorts {
	/***************/
	/* Bubble Sort */ // code from Wikipedia
	/***************/
	public static void bubbleSort(int[] array) {
		if (array == null) {
			return;
		}
		
		boolean swapped = true;
		int offset = 0; // optimizes code
		while (swapped) {
			swapped = false;
			for (int i = 1; i < array.length - offset; i++) {
				if (array[i-1] > array[i]){
					swap(array, i-1, i);
					swapped = true;
				}
			}
			offset++;
		}
	}
	
	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
    
	/******************/
	/* Selection Sort */ // code from Wikipedia
	/******************/
	public static void selectionSort(int[] array) {
		if (array == null) {
			return;
		}
		
		for (int i = 0; i < array.length; i++) {
			int minIndex = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[minIndex]) {
					minIndex = j;
				}
			}
			swap(array, i, minIndex);
		}
	}
	
	/******************/
	/* Insertion Sort */ // code from Wikipedia
	/******************/
	public static void insertionSort(int[] array) {
		if (array == null) {
			return;
		}
		
		for (int i = 1; i < array.length; i++) {
			int j = i;
			int value = array[i];
			while (j >= 1 && array[j-1] > value) { // find where to insert "value"
				array[j] = array[j-1];		       // shift the elements (1 by 1) to make room for inserting
				j--;
			}
			array[j] = value;
		}
	}
	
	/**************/
	/* Merge Sort */ // code from book
	/**************/
	public static void mergeSort(int[] array) {
		if (array != null) {
			int[] helper = new int[array.length];
			mergeSort(array, helper, 0, array.length - 1);
		}
	}
	
	private static void mergeSort(int[] array, int[] helper, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(array, helper, start, mid);
			mergeSort(array, helper, mid + 1, end);
			merge(array, helper, start, mid, end);
		}
	}
	
	private static void merge(int[] array, int[] helper, int start, int mid, int end) {
		for (int i = start; i <= end; i++) { // notice "i" goes from "start" to "end", not "0" to "array.length"
			helper[i] = array[i];
		}

		/* Loop through helper[] left and right halves and continuously copy smaller element to array[] */
		int curr = start;
		int left = start;
		int right = mid + 1;
		while (left <= mid && right <= end) {
			if (helper[left] <= helper[right]) {
				array[curr++] = helper[left++];
			} else {
				array[curr++] = helper[right++];
			}
		}
		
		/* Copy remaining elements of left half. Right half elements are already in proper place (see book for explanation) */
		while (left <= mid) {
			array[curr++] = helper[left++];
		}
	}

	/**************/
	/* Quick Sort */ // code from Wikipedia, CS 125
	/**************/
	public static void quickSort(int[] array) {
		if (array != null) {
			quickSort(array, 0, array.length - 1);
		}
	}
	
	private static void quickSort(int[] array, int start, int end) {
		if (start < end) {
			int pivotIndex = partition(array, start, end);
			quickSort(array, start, pivotIndex - 1);
			quickSort(array, pivotIndex + 1, end);
		}
	}
	
	/* Partitions array into 2 parts. 
	 * 		1) Left side has values smaller than pivotValue
	 * 		2) Right side has values larger than pivotValue
	 * Returns pivotIndex
	 */
	public static Integer partition(int[] array, int start, int end) {
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
}
