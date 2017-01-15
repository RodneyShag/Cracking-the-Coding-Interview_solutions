package chapter11;

/* Binary Search... with a twist */
public class ElevenPoint5 {
	public static int search(String [] array, String str){
		return search(array, str, 0, array.length - 1);
	}
	
	// technically we have to account for a user searching for the empty string ""
	public static int search(String [] array, String str, int start, int end){
		if (start > end)
			return -1;
		
		int mid = (start + end) / 2;
		
		/* Linear search left and right to find closest non-empty string.  This idea is from book. Originally, I had only searched RIGHT
		 * for closest non-empty string
		 */
		if (array[mid].equals("")){
			int left = mid - 1;
			int right = mid + 1;
			while (true){
				if (left < start && right > end)
					return -1;
				else if (left >= start && !array[left].isEmpty()){
					mid = left;
					break;
				}
				else if (right <= end && !array[right].isEmpty()){
					mid = right;
					break;
				}
				left--;
				right++;
			}
		}
		if (array[mid].equals(str))	//originally I (incorrectly) had this line too early, before moving "mid" to proper spot.
			return mid;
		else if (array[mid].compareTo(str) < 0)
			return search(array, str, mid + 1, end);
		else
			return search(array, str, start, mid - 1);
	}
}
