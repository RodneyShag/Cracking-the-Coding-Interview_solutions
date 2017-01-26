package lessons;

import java.util.ArrayList;

/*  This is a lesson on how Integer differs from other objects when it comes to copying values
 * 
 * - .clone() on an ArrayList<> gives you a new ArrayList. If it's an ArrayList of Integers
 *   then you get your own deep copy of Integers. If it's an ArrayList of other objects then 
 *   your ArrayList contains references to the original objects.
 */
public class ShallowDeep {
	public static void main (String [] args){
		/***********/
		/* Integer */
		/***********/
		System.out.println("************* Integer **************");
		ArrayList<Integer> array1 = new ArrayList<>();
		ArrayList<Integer> array2 = new ArrayList<>();
		
		Integer a = 2;
		array1.add(a);
		array2.add(a);
		printArrays(array1, array2);
		
		a = 88; // changed value of a, but neither array is affected.
		printArrays(array1, array2);
		
		array1.set(0, 99); // changed entry in 1st array. 2nd array remains unaffected.
		printArrays(array1, array2);
		
		array2 = (ArrayList<Integer>) array1.clone(); // cloned 1st array into 2nd array
		printArrays(array1, array2);
		
		array1.set(0, 700); // changed value of element in 1st array, 2nd array remains unaffected
		printArrays(array1, array2);

		/**************/
		/* IntWrapper */
		/**************/
		System.out.println("************* IntWrapper **************");
		ArrayList<IntWrapper> array3 = new ArrayList<>();
		ArrayList<IntWrapper> array4 = new ArrayList<>();
		
		IntWrapper four = new IntWrapper(4);
		array3.add(four);
		array4.add(four);
		printArrays2(array3, array4);
		
		four.value = 55; // changed value in 1 array, and it changes in other array too
		printArrays2(array3, array4);

		array3.get(0).value = 99; // changed value in 1st array, changes in 2nd array also
		printArrays2(array3, array4);

		/* .clone() */
		ArrayList<IntWrapper> array5 = new ArrayList<>();
		ArrayList<IntWrapper> array6 = new ArrayList<>();
		
		IntWrapper six   = new IntWrapper(6);
		IntWrapper seven = new IntWrapper(7);
		array5.add(six);
		array5.add(seven);
		printArrays2(array5, array6);
		
		array6.addAll((ArrayList<IntWrapper>) array5.clone()); //cloned 1st array into 2nd array
		printArrays2(array5, array6);
		
		array6.get(0).value = 99; // changed value in 1st array, and it changes in 2nd array as well
		printArrays2(array5, array6);		
	}
	
	private static void printArrays(ArrayList<Integer> array1, ArrayList<Integer> array2){
		System.out.println("(1st) array = " + array1);
		System.out.println("(2nd) array = " + array2 + "\n");
	}
	
	private static void printArrays2(ArrayList<IntWrapper> array1, ArrayList<IntWrapper> array2){
		System.out.println("(1st) array = " + array1);
		System.out.println("(2nd) array = " + array2 + "\n");
	}
}
