package chapter11;

public class Sort {
	/***************/
	/* Bubble Sort */		// code from Wikipedia. Compared to website code, this code is longer but more efficient.
	/***************/
	public static void bubbleSort(int [] array){
		if (array == null)
			return;
		
		boolean swapped = true;
		int endOffset = 0;		//this complicates but slightly optimizes our code. Can remove it completely and code will still work.
		while(swapped){
			swapped = false;
			for (int i = 1; i < array.length - endOffset; i++){
				if (array[i-1] > array[i]){				//comparing to the previous "i-1" element makes it easier to avoid off-end-of-array errors
					swap(array, i-1, i);
					swapped = true;
				}
			}
			endOffset++;
		}
	}
	
	private static void swap (int [] array, int i, int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
    
	/******************/
	/* Selection Sort */	//code from Wikipedia
	/******************/
	public static void selectionSort(int [] array){
		if (array == null)
			return;
		
		for (int i = 0; i < array.length; i++){
			int minIndex = i;
			for (int j = i; j < array.length; j++){
				if (array[j] < array[minIndex])
					minIndex = j;
			}
			swap(array, i, minIndex);
		}
	}
	
	/******************/
	/* Insertion Sort */	//Code from Wikipedia (which is same as book's website). Code not in book though.
	/******************/
	public static void insertionSort(int [] array){
		if (array == null)
			return;
		
		for (int i = 1; i < array.length; i++){
			int j = i;
			int value = array[i];
			while (j > 0 && array[j-1] > value){
				array[j] = array[j-1];				//notice we copy values (instead of swapping) in this sort.
				j--;
			}
			array[j] = value;
		}
	}
	
	/**************/
	/* Merge Sort */		//code from book
	/**************/
	public static void mergeSort(int [] array){
		if (array == null)
			return;
		int [] helper = new int[array.length];
		mergeSort(array, helper, 0, array.length - 1);
	}
	
	public static void mergeSort(int [] array, int [] helper, int start, int end){
		if (start < end){
			int mid = (start + end) / 2;
			mergeSort(array, helper, start, mid);
			mergeSort(array, helper, mid + 1, end);
			merge(array, helper, start, mid, end);
		}
	}
	
	private static void merge(int [] array, int [] helper, int start, int mid, int end){
		/* Create elements */
		for (int i = start; i <= end; i++){			//notice i goes from "start" to "end", not "0" to "array.length"!! Tricky.
			helper[i] = array[i];
		}

		/* Go through 2 parts of array at same time and keep copying the smaller element */
		int curr = start;
		int left = start;
		int right = mid + 1;
		while (left <= mid && right <= end){
			if (helper[left] <= helper[right])
				array[curr++] = helper[left++];
			else
				array[curr++] = helper[right++];
		}
		
		/* Copy remaining elements of left half. Right half elements are already in proper place (see book for explanation) */
		while (left <= mid){
			array[curr++] = helper[left++];
		}
	}

	/**************/
	/* Quick Sort */
	/**************/
	public static void quickSort(int [] array){
		if (array == null)
			return;
		quickSort(array, 0, array.length - 1);
	}
	
	private static void quickSort(int [] array, int start, int end){
		if (start < end){
			int pivotIndex = partition(array, start, end);
			quickSort(array, start, pivotIndex - 1);
			quickSort(array, pivotIndex + 1, end);
		}
	}
	
	/* Wikipedia, CS 125 version - I like this version (instead of books version, which is easy to make off-by-1 errors) */
	private static int partition(int [] array, int start, int end){
		int pivotIndex = (start + end) / 2;
		int pivotValue = array[pivotIndex];
		
		swap(array, pivotIndex, end);	//put pivot at end for now.
		
		/* Linear search, comparing all elements to pivotValue and swapping as necessary */
		int indexToReturn = start;	//Notice we set it to "start", not to "0". I made this mistake FOUR times
		for (int i = start; i < end; i++){
			if (array[i] < pivotValue){
				swap(array, i, indexToReturn);
				indexToReturn++;
			}
		}
		
		swap(array, indexToReturn, end);	//put pivot where it belongs
		return indexToReturn;
	}
}
