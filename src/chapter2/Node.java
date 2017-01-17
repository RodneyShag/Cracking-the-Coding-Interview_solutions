package chapter2;

/* Implementation of SINGLY-linked list */
/* In interview, ask if it's DOUBLY or SINGLY linked */
public class Node{
	/* Data */
	public Node next = null;
	public int data = 0;
	
	/* Constuctor */
	public Node(int d){
		data = d;
	}

	/* Constructor - Converts array to singly linked list (added for testing) */
	public Node(int [] array){
		data = array[0];
		Node curr = this;
		for (int i = 1; i < array.length; i++){
			curr.next = new Node(array[i]);
			curr = curr.next;
		}
	}
	
	/* Creates a Node and appends it to tail of linked list */
	void appendToTail(int d){
		Node n = this;			// slick move
		while (n.next != null){
			n = n.next;
		}
		n.next = new Node(d);
	}
	
	//More functions written in ListFunctions.java
}
