package chapter3;

public class ListFunctions {
	/* Copied from "Chapter 2" code */
	static void printList(Node head){
		if (head == null)
			return;
		Node n = head;
		while (n != null){
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.println();
	}
	
}
