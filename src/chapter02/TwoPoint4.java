package chapter02;

/* Partitioning a SLL
 * 
 * Solutions                                 Runtime   Preference
 * ------------------------------------------------------------------------------------
 * 1) Use Quicksort's Partition function.    O(n)      Favorite
 * 2) Create 2 SLLs from SLL. Connect them.  O(n)      Use if swapping data not allowed
 */
public class TwoPoint4 {
	/* Solution 1 */
	public static Node partition(Node head, int x) {
		if (head == null) {
			return null;
		}
		Node curr = head;
		Node p    = head;
		while (curr != null) {
			if (curr.data < x) {
				/* Swap DATA values */
				int temp  = p.data;
				p.data    = curr.data;
				curr.data = temp;

				p = p.next;
			}
			
			curr = curr.next;
		}
		return head;
	}

	/* Solution 2 */
	public static Node partition2(Node n, int x) {
		if (n == null) {
			return null;
		}
		Node list1_head = null;
		Node list2_head = null;
		Node list1_tail = null; // to walk list1
		Node list2_tail = null; // to walk list2

		while (n != null) {
			if (n.data < x) {
				if (list1_head == null) {
					list1_head = n;
					list1_tail = n;
				} else {
					list1_tail.next = n;
					list1_tail = list1_tail.next;
				}
			} else {
				if (list2_head == null) {
					list2_head = n;
					list2_tail = n;
				} else {
					list2_tail.next = n;
					list2_tail = list2_tail.next;
				}
			}
			n = n.next;
		}
		list2_tail.next = null;
		
		if (list1_head == null) {
			return list2_head;
		} else {
			list1_tail.next = list2_head;
			return list1_head;
		}
	}
}
