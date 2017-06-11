package __Intro_Queue;

import common.ListFunctions;

public class Tester {
	public static void main(String[] args) {
		System.out.println("*** Test Queue\n");
		Queue q = new Queue();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		System.out.print("Queue after 3 enqueues: ");
		ListFunctions.printList(q.peek());
		q.dequeue();
		System.out.print("Queue after dequeue: ");	
		ListFunctions.printList(q.peek());
	}	
}
