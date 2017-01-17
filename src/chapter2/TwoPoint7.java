package chapter2;

import java.util.Stack;

public class TwoPoint7 {
	/* Solution 0 - Rodney's Solution: Since it's easy to solve this problem for an array 
	 * (using a head and a tail pointer that move inwards), we COULD 
	 * create an array from the linked list and solve it that way.
	 */
	
	/****************************************/
	/* Solution 1 - Not implemented in book */
	/****************************************/
	
	 /* - Create Deep Copy of List
	 * - Reverse that list
	 * - Compare the 2 lists.
	 * (Not implemented in book)
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
	/* Solution 2 - Use a STACK to reverse half of the list */
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
	
	/********************************************************************************/
	/* Solution 3 - SKIP THIS SOLUTION. Very Difficult recursive solution from book */
	/********************************************************************************/
	
	public static boolean palindrome_3(Node head){
		Result p = palindromeRecurse(head, ListFunctions.calculateSize(head));
		return p.result;
	}
	
	/* Uses our own "Result" class so that we can return TWO things */
	private static Result palindromeRecurse(Node head, int length){
		/* Base cases */
		if (head == null || length == 0)
			return new Result(null, true);
		else if (length == 1)
			return new Result(head.next, true);	//this is when list is odd number of elements
		else if (length == 2)
			return new Result(head.next.next, head.data == head.next.data);	//notice it's head.next.next since this is if list has even # of elements
		
		Result res = palindromeRecurse(head.next, length - 2);
		if (!res.result) //book has another check here
			return res;
		else{
			res.result = (head.data == res.node.data);
			res.node = res.node.next;
			return res;
		}
	}
}
