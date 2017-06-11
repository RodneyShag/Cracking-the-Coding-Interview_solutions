package _17_09_Kth_Multiple;

import java.util.ArrayDeque;

//  Time Complexity: O(n)
// Space Complexity: O(n)

public class KthMultiple {
	public static int getKthMagicNumber(int k) { // assuming "k" counts from 1...
		if (k < 1) {
			return -1;
		}
		
		/* Use each deque as a queue */
		ArrayDeque<Integer> q3 = new ArrayDeque<>();
		ArrayDeque<Integer> q5 = new ArrayDeque<>();
		ArrayDeque<Integer> q7 = new ArrayDeque<>();
		
		q3.addLast(3);
		q5.addLast(5);
		q7.addLast(7);
		
		int val = 0;
		for (int i = 1; i <= k; i++) {
			int v3 = q3.peek();
			int v5 = q5.peek();
			int v7 = q7.peek();
			val = Math.min(v3, Math.min(v5, v7)); // minimum of 3 values
			/* We only add certain multiples to the queues (based on trick from book) to avoid duplicates */
			if (val == v3) {
				q3.removeFirst();
				q3.addLast(3 * val);
				q5.addLast(5 * val);
			} else if (val == v5) {
				q5.removeFirst();
				q5.addLast(5 * val);
			} else if (val == v7) {
				q7.removeFirst();
			}
			q7.addLast(7 * val);
		}
		return val;
	}
}
