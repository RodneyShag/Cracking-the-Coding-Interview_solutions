package chapter11;

/* Same concept as "merge" from MergeSort.
   Additional Trick: copy to end of array since that's where our empty buffer is. */
public class ElevenPoint1 {	
	public static void merge(int [] a, int [] b, int lastA, int lastB) { // lastA is index of last element in array. same with lastB
		int curr = lastA + lastB + 1;
		while (lastA >= 0 && lastB >= 0) {
			if (a[lastA] > b[lastB]) {
				a[curr--] = a[lastA--];
			} else {
				a[curr--] = b[lastB--];
			}
		}
		
		/* Copy Remaining Elements. No need to copy lastA elements since they're already in correct spot */
		while (lastB >= 0) {
			a[curr--] = b[lastB--];
		}
	}
}
