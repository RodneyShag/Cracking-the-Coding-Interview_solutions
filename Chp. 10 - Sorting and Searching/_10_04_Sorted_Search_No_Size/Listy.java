package _10_04_Sorted_Search_No_Size;

public class Listy {
	int[] array;
	
	public Listy(int[] arr) {
		array = arr;
	}
	
	public int elementAt(int index) {
		if (index >= array.length) {
			return -1;
		}
		return array[index];
	}
}
