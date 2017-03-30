package chapter03;

import chapter02.ListFunctions;

public class Chapter3 {
	public static void main (String [] args) {
		test_Stack();
		test_Queue();
		test_ThreePoint1();
		test_ThreePoint2();
		test_ThreePoint3();
		test_ThreePoint4();
		test_ThreePoint5();
		test_ThreePoint6();
		System.out.println("\n*** I did 3.7 as its own separate program");
	}
	
	public static void test_Stack() {
		System.out.println("*** Test Stack");
		Stack s = new Stack();
		s.push(1);
		s.push(2);
		s.push(3);
		System.out.println("Stack after pushes (top of stack printed first)");
		ListFunctions.printList(s.peek());
		s.pop();
		s.pop();
		s.pop();
		System.out.println("Stack after 3 pops");		
		ListFunctions.printList(s.peek());
	}
	
	public static void test_Queue() {
		System.out.println("\n*** Test Queue");
		Queue q = new Queue();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		System.out.println("Queue after enqueues");
		ListFunctions.printList(q.peek());
		q.dequeue();
		q.dequeue();
		q.dequeue();
		System.out.println("Queue after 3 dequeues");	
		ListFunctions.printList(q.peek());
	}
	
	public static void test_ThreePoint1() {
		System.out.print("\n*** Test 3.1");
		ThreePoint1 threePoint1 = new ThreePoint1();
		try{
			threePoint1.push(1, 0);
			threePoint1.push(2, 0);
			threePoint1.push(3, 0);
			threePoint1.push(4, 1);
			threePoint1.push(5, 1);
			threePoint1.push(6, 1);
			threePoint1.push(7, 2);
			threePoint1.push(8, 2);
			threePoint1.push(9, 2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		threePoint1.printArray();
	}
	
	public static void test_ThreePoint2() {
		System.out.println("\n\n*** Test 3.2");
		System.out.println("For stack of 8 4 6 3 3");
		ThreePoint2 threePoint2 = new ThreePoint2();
		threePoint2.push(8);
		System.out.println("(after 1st push) Min = " + threePoint2.min());
		threePoint2.push(4);
		System.out.println("(after 2nd push) Min = " + threePoint2.min());
		threePoint2.push(6);
		System.out.println("(after 3rd push) Min = " + threePoint2.min());
		threePoint2.push(3);
		System.out.println("(after 4th push) Min = " + threePoint2.min());
		threePoint2.push(3);
		System.out.println("(after 5th push) Min = " + threePoint2.min());
		threePoint2.pop();
		System.out.println("(after 1 pop) Min = " + threePoint2.min());
		threePoint2.pop();
		System.out.println("(after 2 pops) Min = " + threePoint2.min());
	}
	
	public static void test_ThreePoint3() {
		System.out.println("\n*** Test 3.3");
		ThreePoint3 stack = new ThreePoint3();
		for (int i = 1; i <= 7; i++) {
			System.out.println("Pushed " + i);
			stack.push(i);
		}
		for (int i = 1; i <= 7; i++) {
			System.out.println("Popped " + stack.pop());
		}
	}
	
	public static void test_ThreePoint4() {
		System.out.println("\n*** Test 3.4");
		int numTowers = 3;
		int numDisks = 4; // can make this bigger
		Tower [] towers = new Tower[numTowers];
		for (int i = 0; i < numTowers; i++) { 
			towers[i] = new Tower(i); // don't forget. We have to do this too!
		}
		for (int i = numDisks; i > 0; i--) {
			towers[0].push(i);
		}
		ThreePoint4.moveDisks(numDisks, towers[0], towers[2], towers[1]);
	}
	
	public static void test_ThreePoint5() {
		System.out.println("\n*** Test 3.5: Queue from 2 stacks");
		MyQueue<Integer> myQueue = new MyQueue<Integer>();
		myQueue.enqueue(1);
		myQueue.enqueue(2);
		myQueue.enqueue(3);
		myQueue.enqueue(4);
		System.out.println("1st dequeued (should be 1) = " + myQueue.dequeue());
		myQueue.enqueue(5);
		System.out.println("2nd dequeued (should be 2) = " + myQueue.dequeue());
		System.out.println("3rd dequeued (should be 3) = " + myQueue.dequeue());
	}
	
	public static void test_ThreePoint6() {
		System.out.println("\n*** Test 3.6: Sort a stack. Top elements should be bigger");
		java.util.Stack<Integer> stackToSort = new java.util.Stack<Integer>();
		stackToSort.push(3);
		stackToSort.push(7);
		stackToSort.push(2);
		stackToSort.push(6);
		stackToSort.push(1);
		java.util.Stack<Integer> sortedStack = ThreePoint6.sort(stackToSort);
		while (!sortedStack.isEmpty()) {
			System.out.println(sortedStack.pop());
		}
	}
}
