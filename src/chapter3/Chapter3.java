package chapter3;

public class Chapter3 {
	public static void main (String [] args){
		System.out.println("*** Test Stack");
		Stack s = new Stack();
		s.push(1);
		s.push(2);
		s.push(3);
		System.out.println("Stack after pushes");
		ListFunctions.printList(s.peek());
		s.pop();
		s.pop();
		s.pop();
		System.out.println("Stack after pops");		
		ListFunctions.printList(s.peek());
		
		System.out.println("\n*** Test Queue");
		Queue q = new Queue();
		q.enqueue(new Node(1));
		q.enqueue(new Node(2));
		q.enqueue(new Node(3));
		System.out.println("Queue after enqueues");
		ListFunctions.printList(q.peek());
		q.dequeue();
		q.dequeue();
		q.dequeue();
		System.out.println("Queue after dequeues");	
		ListFunctions.printList(q.peek());
		
		/**************
		 * 3.1
		 **************/
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
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
		threePoint1.printArray();
		
		
		/**************
		 * 3.2
		 **************/
		System.out.println("\n\n*** Test 3.2");
		System.out.println("For stack of 8 4 6 3 2");
		ThreePoint2 threePoint2 = new ThreePoint2();
		threePoint2.push(8);
		System.out.println("Min = " + threePoint2.min());
		threePoint2.push(4);
		System.out.println("Min = " + threePoint2.min());
		threePoint2.push(6);
		System.out.println("Min = " + threePoint2.min());
		threePoint2.push(3);
		System.out.println("Min = " + threePoint2.min());
		threePoint2.push(2);
		System.out.println("Min = " + threePoint2.min());
		threePoint2.pop();
		threePoint2.pop();
		System.out.println("For stack of 8 4 6");
		System.out.println("Min = " + threePoint2.min());
		
		
		/**************
		 * 3.3
		 **************/
		System.out.println("\n*** Test 3.3: No testing. My code is basically copied from the book");
		
		
		/**************
		 * 3.4
		 **************/
		System.out.println("\n*** Test 3.4");
		int numTowers = 3;
		int numDisks = 8;
		Tower [] towers = new Tower[numTowers];
		for (int i = 0; i < numTowers; i++){
			towers[i] = new Tower(i);
		}
		for (int i = numDisks; i > 0; i--){
			towers[0].add(i);
		}
		ThreePoint4.moveDisks(numDisks, towers[0], towers[2], towers[1]);	//book says "towers[2]" instead of "2"
		
		
		/**************
		 * 3.5
		 **************/
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
		
		
		/**************
		 * 3.6
		 **************/
		System.out.println("\n*** Test 3.6: Sort a stack. Top elements should be bigger");
		java.util.Stack<Integer> stackToSort = new java.util.Stack<Integer>();
		stackToSort.push(3);
		stackToSort.push(7);
		stackToSort.push(2);
		stackToSort.push(6);
		stackToSort.push(1);
		java.util.Stack<Integer> sortedStack = ThreePoint6.sort(stackToSort);
		while(!sortedStack.isEmpty()){
			System.out.println(sortedStack.pop());
		}
		
		
		/**************
		 * 3.7
		 **************/
		System.out.println("\n*** I did 3.7 as it's own separate program");
	}
}
