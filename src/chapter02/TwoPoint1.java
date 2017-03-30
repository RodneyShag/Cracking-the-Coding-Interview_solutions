package chapter02;

import java.util.HashSet;

/* Removes duplicates from unsorted list
 * 
 * Solutions         Runtime    Space   Preference
 * -----------------------------------------------
 * 1) HashMap        O(n)       O(n)    Favorite
 * 2) Brute-Force    O(n^2)     O(1)    Naive (but O(1) space)
 */
public class TwoPoint1 {
	/* Solution 1 */
	static void removeDuplicates(Node head) {
		if (head == null) {
			return;
		}
		HashSet<Integer> map = new HashSet<>();
		map.add(head.data);
		Node n = head;
		while (n.next != null) {
			if (map.contains(n.next.data)) {
				n.next = n.next.next;
			} else {
				map.add(n.next.data);
				n = n.next;
			}
		}
		return;
	}
	
	/* Solution 2 - Use 1 pointer to walk list, and another pointer to check all remaining nodes each time */
	static void removeDuplicates2(Node head) {
		Node curr   = head;
		Node runner = null;
		while (curr != null) {
			runner = curr;
			while (runner.next != null) {
				if (curr.data == runner.next.data) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			curr = curr.next;
		}
		return;
	}
}
