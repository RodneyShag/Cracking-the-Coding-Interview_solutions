package chapter7;

import java.util.Queue;
import java.util.LinkedList;

/* Finds kth magic number
 * 
 * Solutions                      Runtime     Preference
 * -----------------------------------------------------
 * 1) Brute Force                 O(n^2)      Naive
 * 2) Use PriorityQueue           O(n^2)      Naive
 * 3) Use PriorityQueue, HashMap  O(n log n)  Naive
 * 4) Use 3 Queues                O(n)        Favorite
 */
public class SevenPoint7 {
	/* Solution 1 
	 * - Solution from book. Brute Force.
	 * - Traverse our list each time to generate next k: For the (k-1) numbers we've generated so far, multiply
	 * each by 3, 5, 7 to see which one is our next minimum "kth" number. Do this step each time to generate a new k
	 */
	
	/* Solution 2 - Use 1 PriorityQueue. Getting minimum is now O(1). But O(n) for contains() and O(log n) for add(). */
	
	/* Solution 3 - Use a HashMap alongside Solution 2's PriorityQueue (putting each entry in both data structures). This will turn contains() into O(1). */

	/* Solution 4
	 * - Uses 3 queues (and a math trick from the book) to solve the putting in duplicates problem 
	 * - My code is slightly different (but better) than book's.
	 * - O(n) since we now have O(1) removeMin and O(1) to enqueue :)
	 */
	public static int getKthMagicNumber(int k){
		if (k < 0)
			return 0;
		Queue<Integer> q3 = new LinkedList<Integer>();
		Queue<Integer> q5 = new LinkedList<Integer>();
		Queue<Integer> q7 = new LinkedList<Integer>();

		q3.add(3);
		q5.add(5);
		q7.add(7);
		int val = 0;
		for (int i = 1; i <= k; i++){
			int v3 = q3.peek();
			int v5 = q5.peek();
			int v7 = q7.peek();
			val = Math.min(v3, Math.min(v5, v7));	//minimum of 3 values
			/* We only add certain multiples to the queues (based on trick from book) to avoid duplicates */
			if (val == v3){
				q3.remove();
				q3.add(3 * val);
				q5.add(5 * val);
			}
			else if (val == v5){
				q5.remove();
				q5.add(5 * val);
			}
			else if (val == v7){
				q7.remove();
			}
			q7.add(7 * val);
		}
		return val;
	}
}
