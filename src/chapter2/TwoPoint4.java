package chapter2;
/* I had the same exact idea as the book, which is implemented below */
/* I also had the idea of walking linearly and swapping elements, which the book also mentioned */
public class TwoPoint4 {
	/* Solution 1 - Rip apart the original SLL and form 2 other SLL. Then connect them.
	 * I came up with with solution on my own 2x, and it was exactly how the book did it. 
	 * */
	public static Node partition(Node n, int x){
		if (n == null)
			return null;

		Node list1_head = null;
		Node list2_head = null;
		Node list1_tail = null; // to walk list1
		Node list2_tail = null; // to walk list2

		while (n != null){
			if (n.data < x){
				if (list1_head == null){
					list1_head = n;
					list1_tail = n;
				}
				else{
					list1_tail.next = n;
					list1_tail = list1_tail.next;
				}
			}
			else{
				if (list2_head == null){
					list2_head = n;
					list2_tail = n;
				}
				else{
					list2_tail.next = n;
					list2_tail = list2_tail.next;
				}
			}
			n = n.next;
		}
		list2_tail.next = null;
		
		if (list1_head == null)
			return list2_head;
		else{
			list1_tail.next = list2_head;
			return list1_head;
		}
	}
	
	/* Solution 2 (From book): Can use 2 pointers instead of 4 by inserting at beginning of our 2 new lists instead of at end */
	
	/* Solution 3 - Swapping "data" elements (if allowed) */
	/* Rodney's Clever Algorithm! - Basically similar to Partition for QuickSort Algo. We swap data, treating the SLL as an array.
	 * Very simple to code. Just remember it uses 2 pointers.
	 */
	public static Node partition2(Node head, int x){
		if (head == null)
			return null;
		Node curr = head;
		Node p = head;
		while (curr != null){
			if (curr.data < x){
				/* Swap DATA values */
				int temp = p.data;
				p.data = curr.data;
				curr.data = temp;

				p = p.next;
			}
			
			curr = curr.next;
		}
		return head;
	}
}
