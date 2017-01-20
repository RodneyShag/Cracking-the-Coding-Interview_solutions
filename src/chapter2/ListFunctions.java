package chapter2;

public class ListFunctions {
	/* Prints linked list */
	public static void printList(Node head){
		if (head == null)
			return;
		Node n = head;
		while (n != null){
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.println();
	}
	
	/* deleteNode mentioned in "Introduction" 
	 * We walk the list linearly with ONE pointer. 
	 * Can alternatively solve it with 2 pointers (prev and curr) */
	public static Node deleteNode(Node head, int d){		// "d" is the node we want to delete
		if (head == null)
			return null;
		
		Node n = head;	//start at beginning of list

		/* If data is at beginning of list */
		if (n.data == d)
			return n.next;

		/* If data is in middle or end of list */
		while(n.next != null){
			if (n.next.data == d){
				n.next = n.next.next;	// We will say it's okay that the deleted node still points to the list
				return head;
			}
			n = n.next;
		}

		return head;
	}
	
	/* Returns size of linked list */
	public static int calculateSize(Node head){
		if (head == null)
			return 0;
			
		int size = 1;
		Node n = head;
		while(n.next != null){
			n = n.next;
			size++;
		}
		return size;
	}

	/* Used for TwoPoint5 */
	public static Node insertInFront(Node head, int value){
		Node front = new Node(value);
		front.next = head;
		return front;
	}

	/* Used for TwoPoint7 */ /* MEMORIZE & CODE THIS ALGORITHM */
	/* O(n) time, O(1) space */
	public static Node reverseListIterative(Node head){
		if (head == null || head.next == null)
			return head;
		/* We use THREE pointers to solve this. Found and understood solution using Google */
		Node curr = head;
		Node prev = null;
		Node next = null;
		while (curr != null){
			next = curr.next; // Update 1st of 3 pointers (we do this here to make sure curr isn't null b4 dereference)
			curr.next = prev; // actually change the direction of arrow in SLL.
			prev = curr;      // Update 2nd of 3 pointers
			curr = next;      // Update 3rd of 3 pointers
		}
		return prev;
	}
	
	/* Used for TwoPoint7 */ /* MEMORIZE & CODE THIS ALGORITHM */
	/* Reverses a list in place in O(n) time. 
	 * Although we don't use other data structures, it's still O(n) space cuz n recursive calls */
	public static Node reverseListRecursive(Node head){ // destroys the original list.
		/* Base Cases */
		if (head == null || head.next == null) // handles lists of size 0 or 1
			return head;
		/* Recursive Case */
		else{
			Node second = head.next;
			head.next = null;
			Node rest = reverseListRecursive(second);
			second.next = head;  //  b4 this executes, "second" points to node that is now the current end of the list.
			return rest;
		}
	}
	
	/* Used for TwoPoint7 Solution 1 */
	public static Node deepCopy(Node n){
		Node head = null;
		Node curr = null;;
		while (n != null){
			Node created = new Node(n.data);
			if (head == null){
				head = created;
				curr = created;
			}
			else{
				curr.next = created;
				curr = curr.next;
			}
			n = n.next;
		}
		return head;
	}
}
