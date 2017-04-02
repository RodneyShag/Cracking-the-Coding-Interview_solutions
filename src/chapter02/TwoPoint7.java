package chapter02;

import java.util.ArrayDeque;

/* Check if Linked List is a palindrome
 * 
 * Solutions                                                                          Runtime   Space   Preference
 * ---------------------------------------------------------------------------------------------------------------------
 * 1) Use Stack to reverse list 1/2 of list. Use slow/fast runners to get list size.  O(n)      O(n)    Favorite
 * 2) Deep copy list. Reverse it. Compare to original.                                O(n)      O(n)    Worth mentioning
 */
public class TwoPoint7 {
	/* Solution 1 */
	public static boolean palindrome_2(Node head) {
		Node slow = head;
		Node fast = head;
		ArrayDeque<Integer> deque = new ArrayDeque<>(); // use deque as a stack
		while (fast != null && fast.next != null) {
			deque.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		/* If list had odd number of elements -> skip middle element */
		if (fast != null) {
			slow = slow.next;
		}
		while (slow != null) {
			if (deque.pop() != slow.data) {
				return false;
			}
			slow = slow.next;
		}
		return true;
	}
	
	/* Solution 2 */
	public static boolean palindrome_1(Node head) {
		int size = ListFunctions.calculateSize(head); // O(n) to calculate size
		Node reversed = ListFunctions.reverseListIterative(ListFunctions.deepCopy(head)); // O(n) to reverse list
		Node original = head;
		for (int i = 0; i < size/2; i++) { // we only have to check 1/2 the list.
			if (original.data != reversed.data) {
				return false;
			}
			original = original.next;
			reversed = reversed.next;
		}
		return true;
	}
}
