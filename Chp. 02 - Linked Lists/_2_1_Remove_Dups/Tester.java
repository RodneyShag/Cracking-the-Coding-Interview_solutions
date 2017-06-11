package _2_1_Remove_Dups;

import common.Node;
import common.ListFunctions;

public class Tester {
	public static void main(String[] args) {
		System.out.println("*** Test 2.1: Remove Dups\n");
		test(new Node(new int[]{9,9,9,9}));
		test(new Node(new int[]{5,7,7,3,7,6,7,5}));
	}
	
	private static void test(Node head) {
		ListFunctions.printList(head);
		RemoveDups.removeDuplicates(head);
		ListFunctions.printList(head);
		System.out.println();
	}
}
