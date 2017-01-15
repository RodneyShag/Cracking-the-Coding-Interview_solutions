package chapter3;
/* I made a Queue of NODES. Book does a Queue of OBJECTS */
/* Easy to code */
public class Queue {
	Node first = null;
	Node last = null;
	
	public void enqueue(Node n){	//Book does a deep copy here
		if (first == null){
			first = n;
			last = n;
		}
		else{
			last.next = n;
			last = n;
		}
	}
	
	public Node dequeue(){
		if (first == null)
			return null;
		else{
			Node front = first;
			first = first.next;
			if (first == null)		//the book forgot this
				last = null;		//error check
			front.next = null;	//probably necessary
			return front;
		}
	}
	
	/* I Wrote this. Thought it'd be useful. */
	public Node peek(){
		return first;
	}
}
