package _2_5_Sum_Lists;

import common.Node;
import common.ListFunctions;

public class Tester {
	public static void main(String[] args) {
		System.out.println("*** Test 2.5: Sum Lists");

		/* Part 1 - Reverse Order */
		testReverse(new Node(new int[] { 6, 3, 4, 8, 2 }), new Node(new int[] { 7, 1, 3 }));
		testReverse(new Node(new int[] { 9, 4 }), new Node(new int[] { 7, 7 }));

		/* Part 2 - Forward Order */
		testForward(new Node(new int[] { 3, 3, 4 }), new Node(new int[] { 7, 6, 8, 7 }));
		testForward(new Node(new int[] { 3, 9 }), new Node(new int[] { 7, 5 }));
	}

	private static void testReverse(Node num1_head, Node num2_head) {
		System.out.println("\nPart 1 - Reverse Order");
		ListFunctions.printList(num1_head);
		ListFunctions.printList(num2_head);
		Node sum = SumLists.addReverseOrder(num1_head, num2_head);
		ListFunctions.printList(sum);
	}

	private static void testForward(Node num1_head, Node num2_head) {
		System.out.println("\nPart 2 - Forward Order");
		ListFunctions.printList(num1_head);
		ListFunctions.printList(num2_head);
		Node sum = SumLists.addForwardOrder(num1_head, num2_head);
		ListFunctions.printList(sum);
	}
}
