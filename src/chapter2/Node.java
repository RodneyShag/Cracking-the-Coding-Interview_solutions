package chapter2;

/* Implementation of SINGLY-linked list */  /* In interview, ask if it's DOUBLY or SINGLY linked */
public class Node{
	Node next = null;
	int data = 0;
	
	public Node(int d){
		data = d;
	}
	
	void appendToTail(int d){
		Node n = this;			// slick move
		while (n.next != null){
			n = n.next;
		}
		n.next = new Node(d);
	}
	
	//More functions written in "ListFunctions" class
}

