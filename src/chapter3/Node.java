package chapter3;

public class Node {
	Node next = null;
	int data;
	
	public Node(int d){
		data = d;
	}
	
	/* This makes no sense but here so STACK and QUEUE classes from book will work for now */
	public Node(Object o){
		data = 0; 
	}
	
	void appendToTail(int d){
		Node end = new Node(d);
		Node n = this;			//slick move
		while (n.next != null){
			n = n.next;
		}
		n.next = end;
	}
}
