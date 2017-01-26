package chapter02;

/* CLEVER SOLUTION - I would have never gotten this solution without the book 
 * - Easy to code (once algorithm is understood)
 */
public class TwoPoint6 {
	public static Node findBeginning(Node head){
		Node slow = head;	//moves at normal speed
		Node fast = head;	//moves at double speed
		
		/* Let "k" be number of nodes from beginning of list to beginning of loop
		 * When "slow" enters loop (after k nodes), "fast" is k nodes into the list.
		 * That means they will meet in "LOOP_SIZE - k" steps (Since they get 1 step closer each time). (Comment in book said this incorrectly)
		 * When they meet, "slow" is "LOOP_SIZE - k" steps into the loop, so "slow" will be at beginning of loop in "k" single steps.
		 */
		while (fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) //they collided !
				break;
		}
		
		/* Error Check - Detects if no loop was found. Don't forget this step! */
		if (fast == null || fast.next == null)
			return null;
		
		/* Now put "slow" at beginning of list and have "fast" and "slow" both move in SINGLE steps til collision */
		fast = head; //now moves at normal speed.
		while (fast != slow){
			fast = fast.next;	
			slow = slow.next;
		}
		return slow;	//or return fast here. They've collided!
	}
}
