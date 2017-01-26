package chapter02;

import java.util.Stack;

/* Removes duplicates from unsorted list
 * 
 * Solutions                                            Runtime       Preference
 * -----------------------------------------------------------------------------
 * 1) Turn LL into array.                               O(n)          Clever
 * 2) Deep copy list. Reverse it. Compare to original   O(n)          Clever
 * 3) Use Stack to reverse list                         O(n)          Favorite
 */
public class TwoPoint7 {
	/* Solution 1 - Rodney's Solution: Since it's easy to solve this problem for an array 
	 * (using a head and a tail pointer that move inwards), we COULD 
	 * create an array from the linked list and solve it that way.
	 */
	
	/****************************************/
	/* Solution 2 - Not implemented in book */
	/****************************************/
	
	/* - Create Deep Copy of List
	 * - Reverse that list
	 * - Compare the 2 lists.
	 */
	public static boolean palindrome_1(Node head){
		int size = ListFunctions.calculateSize(head); // O(n) to calculate size
		Node reversed = ListFunctions.reverseListIterative(ListFunctions.deepCopy(head)); // O(n) to reverse list
		Node original = head;
		for (int i = 0; i < size/2; i++){ // we only have to check 1/2 the list.
			if (original.data != reversed.data)
				return false;
			original = original.next;
			reversed = reversed.next;
		}
		return true;
	}
	
	/********************************************************/
	/* Solution 3 - Use a STACK to reverse half of the list */
	/********************************************************/
	
	/* Since we don't know size of list, we use SLOW and FAST runners */
	public static boolean palindrome_2(Node head){
		Node slow = head;
		Node fast = head;
		Stack<Integer> stack = new Stack<Integer>();
		while (fast != null && fast.next != null){	//tricky knowing this is a terminating condition.
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		/* CLEVER TRICK - detects if odd number of elements in list, and skips middle element */
		if (fast != null)
			slow = slow.next;
		
		while (slow != null){
			if (stack.pop().intValue() != slow.data)
				return false;
			slow = slow.next;
		}
		return true;
	}
}
