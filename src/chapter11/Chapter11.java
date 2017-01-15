package chapter11;
import java.util.Arrays;

public class Chapter11 {
	public static void main(String [] args){
		int [] arrayBubble    = {3, 6, 1, 6, 25, 16, 62, -3, -6, 4, 16, 26, 0, 0, 25, 25, -3, -3, 6, 7, 0, 1, 29, 28};
		int [] arraySelection = {3, 6, 1, 6, 25, 16, 62, -3, -6, 4, 16, 26, 0, 0, 25, 25, -3, -3, 6, 7, 0, 1, 29, 28};
		int [] arrayInsertion = {3, 6, 1, 6, 25, 16, 62, -3, -6, 4, 16, 26, 0, 0, 25, 25, -3, -3, 6, 7, 0, 1, 29, 28};
		int [] arrayMerge     = {3, 6, 1, 6, 25, 16, 62, -3, -6, 4, 16, 26, 0, 0, 25, 25, -3, -3, 6, 7, 0, 1, 29, 28};
		int [] arrayQuick     = {3, 6, 1, 6, 25, 16, 62, -3, -6, 4, 16, 26, 0, 0, 25, 25, -3, -3, 6, 7, 0, 1, 29, 28};
		printArray(arrayBubble);
		System.out.println(" - Original Array");
		
		Sort.bubbleSort(arrayBubble);
		printArray(arrayBubble);
		System.out.println(" - BubbleSort");
		
		Sort.selectionSort(arraySelection);
		printArray(arraySelection);
		System.out.println(" - SelectionSort");
		
		Sort.bubbleSort(arrayInsertion);
		printArray(arrayInsertion);
		System.out.println(" - arrayInsertion");
		
		Sort.mergeSort(arrayMerge);
		printArray(arrayMerge);
		System.out.println(" - MergeSort");
		
		Sort.quickSort(arrayQuick);
		printArray(arrayQuick);
		System.out.println(" - QuickSort");
		
		
		/************/
		/*** 11.2 ***/
		/************/
		System.out.println("\n*** Test 11.2 - group anagrams together");
		String [] array  = {"hello", "hi", "ih", "obb", "bob", "helol", "olleh", "god", "loleh", "lolhe", "asd", "nwr", "gsegae", "fesf"};
		String [] array2 = {"hello", "hi", "ih", "obb", "bob", "helol", "olleh", "god", "loleh", "lolhe", "asd", "nwr", "gsegae", "fesf"};
		Arrays.sort(array, new AnagramComparator());
		ElevenPoint2.sort(array2);
		System.out.print("Solution 1: ");
		printArray(array);
		System.out.print("\nSolution 2: ");
		printArray(array2);
		
		/************/
		/*** 11.3 ***/
		/************/		
		int [] rotatedArray = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
		System.out.println("\n\n*** Test 11.3: Index of value in rotated array");
		for (int i = 0; i < rotatedArray.length; i++){
			System.out.print(rotatedArray[i] + " ");
		}
		System.out.println("\n5 is at index: " + ElevenPoint3.search(rotatedArray, 5));
		
		
		/************/
		/*** 11.5 ***/
		/************/
		System.out.println("\n*** Test 11.5: Find index of string");
		String [] strings = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
		printArray(strings);
		System.out.println("\n\"ball\" is at index: " + ElevenPoint5.search(strings, "ball"));
		
		/************/
		/*** 11.6 ***/
		/************/
		System.out.println("\n*** Test 11.6: Find element in MxN matrix, with rows and columns sorted");
		int [][] array2d = { {1,  6,  8,  9},
							 {3,  8,  9, 11},
							 {6,  9, 11, 15},
							 {7, 14, 17, 22} };
		System.out.println("6 exists: " + ElevenPoint6.findElement(array2d, 6));
		System.out.println("64 exists: " + ElevenPoint6.findElement(array2d, 64));
	}
	
	private static void printArray(int [] array){
		for (int i = 0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}
	}
	private static void printArray(String [] array){
		for (int i = 0; i < array.length; i++){
			if (array[i] == "")
				System.out.print("\"\"" + " ");
			else
				System.out.print(array[i] + " ");
		}
	}
}
