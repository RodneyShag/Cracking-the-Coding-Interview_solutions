package chapter2;

public class Chapter2 {
	public static void main (String [] args){
		test_Introduction();
		test_TwoPoint1();
		test_TwoPoint2();
		test_TwoPoint3();
		test_TwoPoint4();
		test_TwoPoint5();
		test_TwoPoint6();
		test_TwoPoint7();
	}
	
	public static void test_Introduction(){
		System.out.println("\n**********************************************");
		System.out.println("Introduction: Test linked list and deleteNode()\n");
		Node head = new Node(new int[]{9,7,8});

		ListFunctions.printList(head);
				
		head = ListFunctions.deleteNode(head, 9);
		ListFunctions.printList(head);
	
		head = ListFunctions.deleteNode(head, 7);
		ListFunctions.printList(head);
		
		head = ListFunctions.deleteNode(head, 8);
		ListFunctions.printList(head);
	}
	
	public static void test_TwoPoint1(){
		System.out.println("\n**********************************************");
		System.out.println("Question 2.1: Remove Duplicates");
		
		System.out.println("\nSolution Version 1");
		Node head = new Node(new int[]{9,9,9,9});
		ListFunctions.printList(head);
		TwoPoint1.removeDuplicates(head);
		ListFunctions.printList(head);

		System.out.println("\nSolution Version 2");
		head = new Node(new int[]{9,9,9,9});
		ListFunctions.printList(head);
		TwoPoint1.removeDuplicates2(head);
		ListFunctions.printList(head);
	}
	
	public static void test_TwoPoint2(){
		System.out.println("\n**********************************************");
		System.out.println("Question 2.2: Kth Last");
		Node head = new Node(new int[]{1,2,3,4});
		ListFunctions.printList(head);
		
		System.out.println("\nSolution 1");
		int k = 2;
		Node m = TwoPoint2.kthToLast_1(head, k);
		if (m != null)
			System.out.println("Element " + k + " from end = " + m.data);

		System.out.println("\nSolution 2A");
		k = 2;
		TwoPoint2.kthToLast_2A(head, k); // this prints solution to screen
		
		System.out.println("\nSolution 2C");
		k = 2;
		IntWrapper intWrapped = new IntWrapper();
		m = TwoPoint2.kthToLast_2C(head, k, intWrapped);
		if (m != null)
			System.out.println("Element " + k + " from end = " + m.data);
		
		System.out.println("\nSolution 3");
		k = 2;
		m = TwoPoint2.kthToLast_3(head, k);
		if (m != null)
			System.out.println("Element " + k + " from end = " + m.data);	
	}

	public static void test_TwoPoint3(){
		System.out.println("\n**********************************************");
		System.out.println("Question 2.3: Test Delete Mid\n");
		Node head = new Node(new int[]{6,7,8,9});
		ListFunctions.printList(head);
		TwoPoint3.deleteMid(head.next.next);
		ListFunctions.printList(head);
		
		System.out.println("\n Another trial");
		head = new Node(new int[]{6,7,8,9,10});
		ListFunctions.printList(head);
		TwoPoint3.deleteMid(head.next.next);
		ListFunctions.printList(head);
	}
	
	public static void test_TwoPoint4(){
		System.out.println("\n**********************************************");
		System.out.println("Question 2.4: Test Partition");

		/* Solution 1 */
		Node head = new Node(new int[]{6,3,4,8,2});
		
		System.out.print("\nOriginal list: ");
		ListFunctions.printList(head);

		System.out.println("\nSolution Version 1... Partition on 5");
		head = TwoPoint4.partition(head, 5);
		ListFunctions.printList(head);

		/* Solution 2 */
		head = new Node(new int[]{6,3,4,8,2});
		System.out.println("\nSolution Version 2... Partition on 5");
		head = TwoPoint4.partition2(head, 5);
		ListFunctions.printList(head);
	}
	
	public static void test_TwoPoint5(){
		System.out.println("\n**********************************************");
		System.out.println("Question 2.5: Add Lists");
		
		/* Part 1 */
		System.out.println("\nSolution Part 1 (Reverse Ordered Lists: Addition)");
		Node num1 = new Node(new int[]{6,3,4,8,2});
		Node num2 = new Node(new int[]{7,1,3});
		
		ListFunctions.printList(num1);
		ListFunctions.printList(num2);
		Node twoPoint5_Reverse = TwoPoint5.addReverseOrder(num1, num2);
		ListFunctions.printList(twoPoint5_Reverse);
		System.out.println();
		
		num1 = new Node(new int[]{9,4});
		num2 = new Node(new int[]{7,7});
		
		ListFunctions.printList(num1);
		ListFunctions.printList(num2);
		twoPoint5_Reverse = TwoPoint5.addReverseOrder(num1, num2);
		ListFunctions.printList(twoPoint5_Reverse);
		
		/* Part 2 */
		System.out.println("\nSolution Part 2 (Forward Ordered Lists: Addition)");
		num1 = new Node(new int[]{3,3,4});
		num2 = new Node(new int[]{7,6,8,7});
		
		ListFunctions.printList(num1);
		ListFunctions.printList(num2);
		Node twoPoint5_Forward = TwoPoint5.addForwardOrder(num1, num2);
		ListFunctions.printList(twoPoint5_Forward);
		System.out.println();
		
		num1 = new Node(new int[]{3,9});
		num2 = new Node(new int[]{7,5});
		
		ListFunctions.printList(num1);
		ListFunctions.printList(num2);
		twoPoint5_Forward = TwoPoint5.addForwardOrder(num1, num2);
		ListFunctions.printList(twoPoint5_Forward);
	}
	
	public static void test_TwoPoint6(){
		System.out.println("\n**********************************************");
		System.out.println("Question 2.6: Circular Linked List\n");
		Node a1 = new Node(1);
		Node a2 = new Node(2); // will be beginning of loop.
		Node a3 = new Node(3);
		Node a4 = new Node(4);
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a2; // a4 points to beginning of loop (a2).
		
		Node loopBeginning = TwoPoint6.findBeginning(a1);
		System.out.println("Loop Beginning (Value) = " + loopBeginning.data);
	}
	
	public static void test_TwoPoint7(){
		System.out.println("\n**********************************************");
		System.out.println("Question 2.7: Palindrome\n");
		
		/* Test Reverse List */
		System.out.println("Test Reverse List");
		Node head = new Node(new int[]{1,2,3,4});
		System.out.print("Original List: ");
		ListFunctions.printList(head);
		System.out.print("Reverse List:  ");
		head = ListFunctions.reverseListRecursive(head);
		ListFunctions.printList(head);
		System.out.print("Reverse Again: ");
		head = ListFunctions.reverseListIterative(head);
		ListFunctions.printList(head);
		System.out.println();

		/* Test 1 */
		ListFunctions.printList(head);
		System.out.println("Solution 1: Palindrome? " + TwoPoint7.palindrome_1(head));
		System.out.println("Solution 2: Palindrome? " + TwoPoint7.palindrome_2(head) + "\n");

		/* Test 2 */
		head = new Node(new int[]{1,2,3,4,3,2,1});
		ListFunctions.printList(head);
		System.out.println("Solution 1: Palindrome? " + TwoPoint7.palindrome_1(head));
		System.out.println("Solution 2: Palindrome? " + TwoPoint7.palindrome_2(head) + "\n");
		
		/* Test 3 */
		head = new Node(new int[]{1,2,2,1});
		ListFunctions.printList(head);
		System.out.println("Solution 1: Palindrome? " + TwoPoint7.palindrome_1(head));
		System.out.println("Solution 2: Palindrome? " + TwoPoint7.palindrome_2(head)+ "\n");
		
		/* Test 4 */
		head = new Node(new int[]{1,2,2,1,8,2,1});
		ListFunctions.printList(head);
		System.out.println("Solution 1: Palindrome? " + TwoPoint7.palindrome_1(head));
		System.out.println("Solution 2: Palindrome? " + TwoPoint7.palindrome_2(head) + "\n");
	}
}
