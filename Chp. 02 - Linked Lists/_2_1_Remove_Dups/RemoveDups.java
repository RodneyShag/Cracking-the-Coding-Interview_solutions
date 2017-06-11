package _2_1_Remove_Dups;

import java.util.HashSet;
import common.Node;

//  Time Complexity: O(n)
// Space Complexity: O(n)

public class RemoveDups {
	static void removeDuplicates(Node head) {
		HashSet<Integer> set = new HashSet<>();
		set.add(head.data);
		Node n = head;
		while (n.next != null) {
			if (set.contains(n.next.data)) {
				n.next = n.next.next;
			} else {
				set.add(n.next.data);
				n = n.next;
			}
		}
		return;
	}
	
	// Alternate solution: Brute-force compare all pairs (Advantage is low space complexity)
	// Use 1 pointer to walk list, and another pointer to check all remaining nodes each time
	//  Time Complexity: O(n^2)
	// Space Complexity: O(1)
}
