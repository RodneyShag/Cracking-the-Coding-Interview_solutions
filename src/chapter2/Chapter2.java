package chapter2;

public class Chapter2 {
	public static void main(String [] args){
		
		/* Test the Linked List itself, and delete Nodes */
		Node n = new Node(7);
		n.next = new Node(8);
		n.next.next = new Node(9);

		ListFunctions.printList(n);
				
		n = ListFunctions.deleteNode(n, 9);
		ListFunctions.printList(n);
	
		n = ListFunctions.deleteNode(n, 7);
		ListFunctions.printList(n);
		
		n = ListFunctions.deleteNode(n, 8);
		ListFunctions.printList(n);
		
		/****************/
		/* Question 2.1 */
		/****************/
		System.out.println("\n*** Question 2.1: Test Remove Duplicates");
		System.out.println("\nSolution Version 1");
		n = new Node(9);
		n.appendToTail(9);
		n.appendToTail(9);
		n.appendToTail(9);
		ListFunctions.printList(n);
		TwoPoint1.removeDuplicates(n);
		ListFunctions.printList(n);
		
		/////////////////
		System.out.println("\nSolution Version 2");
		n = new Node(9);
		n.appendToTail(9);
		n.appendToTail(9);
		n.appendToTail(9);
		
		ListFunctions.printList(n);
		TwoPoint1.removeDuplicates2(n);
		ListFunctions.printList(n);		
		
		/****************/
		/* Question 2.2 */
		/****************/
		System.out.println("\n*** Question 2.2: Kth Last");
		n = new Node(1);
		n.appendToTail(2);
		n.appendToTail(3);
		n.appendToTail(4);

		System.out.println("\nSolution Version 1");
		int k = 2;
		Node m = TwoPoint2.kthToLast_1(n, k);
		if (m != null){
			ListFunctions.printList(n);
			System.out.println("Element " + k + " from end = " + m.data);
		}

		System.out.println("\nSolution Version 2A");
		k = 2;
		TwoPoint2.kthToLast_2A(n, k);
		if (m != null)
			ListFunctions.printList(n);
		
		System.out.println("\nSolution Version 2C");
		k = 2;
		IntWrapper intWrapped = new IntWrapper();
		m = TwoPoint2.kthToLast_2C(n, k, intWrapped);
		if (m != null){
			ListFunctions.printList(n);
			System.out.println("Element " + k + " from end = " + m.data);
		}
		
		System.out.println("\nSolution Version 3");
		k = 2;
		m = TwoPoint2.kthToLast_3(n, k);
		if (m != null){
			ListFunctions.printList(n);
			System.out.println("Element " + k + " from end = " + m.data);
		}
		
		/****************/
		/* Question 2.3 */
		/****************/
		System.out.println("\n*** Question 2.3: Test Delete Mid");
		n = new Node(6);
		n.appendToTail(7);
		n.appendToTail(8);
		n.appendToTail(9);
		ListFunctions.printList(n);
		TwoPoint3.deleteMid(n.next.next);
		ListFunctions.printList(n);
		
		System.out.println("\n Another trial");
		n = new Node(6);
		n.appendToTail(7);
		n.appendToTail(8);
		n.appendToTail(9);
		n.appendToTail(10);
		ListFunctions.printList(n);
		TwoPoint3.deleteMid(n.next.next);
		ListFunctions.printList(n);
		
		/****************/
		/* Question 2.4 */
		/****************/
		System.out.println("\n*** Question 2.4: Test Partition");
		System.out.println("\nSolution Version 1... Partition on 5");
		n = new Node(6);
		n.appendToTail(3);
		n.appendToTail(4);
		n.appendToTail(8);
		n.appendToTail(2);
		
		ListFunctions.printList(n);
		n = TwoPoint4.partition(n, 5);
		ListFunctions.printList(n);

		System.out.println("\nSolution Version 2... Partition on 5");
		n = new Node(6);
		n.appendToTail(3);
		n.appendToTail(4);
		n.appendToTail(8);
		n.appendToTail(2);
		
		ListFunctions.printList(n);
		n = TwoPoint4.partition2(n, 5);
		ListFunctions.printList(n);

		/****************/
		/* Question 2.5 */
		/****************/
		System.out.println("\n*** Question 2.5: Add Lists");
		System.out.println("\nSolution Part 1 (Reverse Ordered Lists: Addition)");
		n = new Node(6);
		n.appendToTail(3);
		n.appendToTail(4);
		n.appendToTail(8);
		n.appendToTail(2);
		
		m = new Node(7);
		m.appendToTail(1);
		m.appendToTail(3);
		
		ListFunctions.printList(n);
		ListFunctions.printList(m);
		Node twoPoint5_Reverse = TwoPoint5.addReverseOrder(n, m);
		ListFunctions.printList(twoPoint5_Reverse);
		
		System.out.println();
		
		n = new Node(9);
		n.appendToTail(4);
		
		m = new Node(7);
		m.appendToTail(7);
		
		ListFunctions.printList(n);
		ListFunctions.printList(m);
		twoPoint5_Reverse = TwoPoint5.addReverseOrder(n, m);
		ListFunctions.printList(twoPoint5_Reverse);
		
		System.out.println("\nSolution Part 2 (Forward Ordered Lists: Addition)");
		n = new Node(3);
		n.appendToTail(3);
		n.appendToTail(4);
		
		m = new Node(7);
		m.appendToTail(6);
		m.appendToTail(8);
		m.appendToTail(7);
		
		ListFunctions.printList(n);
		ListFunctions.printList(m);
		Node twoPoint5_Forward = TwoPoint5.addForwardOrder(n, m);
		ListFunctions.printList(twoPoint5_Forward);
		
		System.out.println();
		
		n = new Node(3);
		n.appendToTail(9);
		
		m = new Node(7);
		m.appendToTail(5);
		
		ListFunctions.printList(n);
		ListFunctions.printList(m);
		twoPoint5_Forward = TwoPoint5.addForwardOrder(n, m);
		ListFunctions.printList(twoPoint5_Forward);
		
		/****************/		
		/* Question 2.6 */
		/****************/
		System.out.println("\n*** Question 2.6: Circular Linked List");
		Node a1 = new Node(1);
		Node a2 = new Node(2); // will be beginning of loop.
		Node a3 = new Node(3);
		Node a4 = new Node(4);
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a2; // points to beginning of loop.
		
		Node loopBeginning = TwoPoint6.findBeginning(a1);
		System.out.println("Loop Beginning = " + loopBeginning.data);
		
		/****************/
		/* Question 2.7 */
		/****************/
		System.out.println("\n*** Question 2.7: Palindrome");
		System.out.println("Test Reverse List");
		n = new Node(1);
		n.appendToTail(2);
		n.appendToTail(3);
		n.appendToTail(4);
		ListFunctions.printList(n);
		n = ListFunctions.reverseListRecursive(n);
		ListFunctions.printList(n);
		n = ListFunctions.reverseListIterative(n);
		ListFunctions.printList(n);
		
		System.out.println();

		// solution 1
		ListFunctions.printList(n);		
		boolean palindrome = TwoPoint7.palindrome_1(n);
		if (palindrome)
			System.out.println("Solution 1: Palindrome");
		else
			System.out.println("Solution 1: Not a Palindrome");		
		// solution 2
		palindrome = TwoPoint7.palindrome_2(n);
		if (palindrome)
			System.out.println("Solution 2: Palindrome");
		else
			System.out.println("Solution 2: Not a Palindrome");
		// solution 3
		palindrome = TwoPoint7.palindrome_3(n);
		if (palindrome)
			System.out.println("Solution 3: Palindrome");
		else
			System.out.println("Solution 3: Not a Palindrome");
	
		n.appendToTail(3);
		n.appendToTail(2);
		n.appendToTail(1);
		ListFunctions.printList(n);
		// solution 1
		palindrome = TwoPoint7.palindrome_1(n);
		if (palindrome)
			System.out.println("Solution 1: Palindrome");
		else
			System.out.println("Solution 1: Not a Palindrome");
		// solution 2
		palindrome = TwoPoint7.palindrome_2(n);
		if (palindrome)
			System.out.println("Solution 2: Palindrome");
		else
			System.out.println("Solution 2: Not a Palindrome");
		// solution 3
		palindrome = TwoPoint7.palindrome_3(n);
		if (palindrome)
			System.out.println("Solution 3: Palindrome");
		else
			System.out.println("Solution 3: Not a Palindrome");

		n = new Node(1);
		n.appendToTail(2);
		n.appendToTail(2);
		n.appendToTail(1);
		ListFunctions.printList(n);
		// solution 1
		palindrome = TwoPoint7.palindrome_1(n);
		if (palindrome)
			System.out.println("Solution 1: Palindrome");
		else
			System.out.println("Solution 1: Not a Palindrome");
		// solution 2
		palindrome = TwoPoint7.palindrome_2(n);
		if (palindrome)
			System.out.println("Solution 2: Palindrome");
		else
			System.out.println("Solution 2: Not a Palindrome");
		// solution 3
		palindrome = TwoPoint7.palindrome_3(n);
		if (palindrome)
			System.out.println("Solution 3: Palindrome");
		else
			System.out.println("Solution 3: Not a Palindrome");
		
		n.appendToTail(8);
		n.appendToTail(2);
		n.appendToTail(1);
		ListFunctions.printList(n);
		// solution 1
		palindrome = TwoPoint7.palindrome_1(n);
		if (palindrome)
			System.out.println("Solution 1: Palindrome");
		else
			System.out.println("Solution 1: Not a Palindrome");
		// solution 2
		palindrome = TwoPoint7.palindrome_2(n);
		if (palindrome)
			System.out.println("Solution 2: Palindrome");
		else
			System.out.println("Solution 2: Not a Palindrome");
		// solution 3
		palindrome = TwoPoint7.palindrome_3(n);
		if (palindrome)
			System.out.println("Solution 3: Palindrome");
		else
			System.out.println("Solution 3: Not a Palindrome");
	}
}
