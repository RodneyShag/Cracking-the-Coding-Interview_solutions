package chapter11;
/* Clever Trick: Copy to end of array!!! 
 * Uses 3 pointers
 */
public class ElevenPoint1 {	
	public static void merge(int [] a, int [] b, int lastA, int lastB){	//lastA is last element in array. same with lastB
		int curr = lastA + lastB + 1;
		while(lastA >= 0 && lastB >= 0){
			if (a[lastA] > b[lastB])
				a[curr--] = a[lastA--];
			else
				a[curr--] = b[lastB--];
		}
		
		/* Copy Remaining Elements. Clever Trick (From merge in mergesort): No need to copy indexA elements since they're already in correct spot */
		while(lastB >= 0){
			a[curr--] = b[lastB--];
		}
	}
}
