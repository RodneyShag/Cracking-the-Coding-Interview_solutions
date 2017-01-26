package chapter03;

import chapter02.Node;

/* I made a Queue of NODES. Book does a Queue of OBJECTS */
public class Queue {
	private Node head = null;
	private Node tail = null;
	
	public void enqueue(int data){
		Node n = new Node(data);
		if (head == null){
			head = n;
			tail = n;
		}
		else{
			tail.next = n;
			tail = n;
		}
	}

	public Node dequeue(){
		if (head == null)
			return null;
		else{
			Node front = head;
			head = head.next;
			if (head == null)   // the book forgot this error check (to prevent but in 1-item lists)
				tail = null;	
			front.next = null;	// rips the Node from the Queue
			return front;
		}
	}
	
	/* I added this. Thought it'd be useful. */
	public Node peek(){
		return head;
	}
}
