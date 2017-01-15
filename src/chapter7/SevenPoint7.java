package chapter7;
import java.util.Queue;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class SevenPoint7 {
	/* Solution 0 - Horribly slow O(n^2) solution mentioned in book: For the (k-1) numbers we've generated so far, multiply
	 * each by 3, 5, 7 to see which one is our next minimum "kth" number. Do this step each time.
	 */
	
	/* Rodney's Solution using PriorityQueue (instead of book's stupid way of using Queue/LinkedList. Makes job much easier. */
	public static void addProducts(PriorityQueue<Integer> pq, int v){
		if (!pq.contains(3*v))
			pq.add(3 * v);
		if (!pq.contains(5*v))
			pq.add(5 * v);
		if (!pq.contains(7*v))
			pq.add(7 * v);
	}
	
	public static int getKthMagicNumber(int k) {
		if (k < 0)
			return 0;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		addProducts(pq, 1);
		int val = 1;
		for (int i = 1; i <= k; i++){
			val = pq.remove();
			addProducts(pq, val);
		}
		return val;
	}
	
	/* Solution 2 - If can't use PriorityQueue, do this book solution using 3 queues to avoid putting in duplicates 
	 * (based on mathematical principle from book). 
	 * My code is slightly different (but better) than book.
	 * I think this solution is O(n) since removing the minimum takes constant time.
	 * - This may be a more efficient solution than my PQ solution above.
	 * */
	public static int getKthMagicNumber2(int k){
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
			/* We only add certain multiples to the queues based on trick from book (to avoid duplicates) */
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
