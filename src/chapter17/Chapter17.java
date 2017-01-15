package chapter17;

public class Chapter17 {
	public static void main (String [] args){
		/********/
		/* 17.4 */
		/********/
		System.out.println("*** Test 17.4: Detect Max of 2 ints (without if-else or comparators)");
		System.out.println("0 means negative, 1 means positive");
		System.out.println("-2  : " + SeventeenPoint4.sign(-2));
		System.out.println("-6  : " + SeventeenPoint4.sign(-6));
		System.out.println("-61 : " + SeventeenPoint4.sign(-61));
		System.out.println("-252: " + SeventeenPoint4.sign(-252));
		System.out.println(" 2  : " + SeventeenPoint4.sign(2));
		System.out.println(" 6  : " + SeventeenPoint4.sign(6));
		System.out.println(" 61 : " + SeventeenPoint4.sign(61));
		System.out.println(" 252: " + SeventeenPoint4.sign(252));
		System.out.println("max(-3, -5): " + SeventeenPoint4.max(-3, -5));
		System.out.println("max(0, 8)  : " + SeventeenPoint4.max(0, 8));
		System.out.println("max(-3, 5) : " + SeventeenPoint4.max(-3, 5));
		
		/********/
		/* 17.5 */
		/********/
		System.out.println("\n*** Test 17.5: Mastermind");
		Result result = SeventeenPoint5.estimate("RGBY", "GGRR");
		System.out.println(result);
		
		
		/********/
		/* 17.6 */
		/********/
		System.out.println("\n*** Test 17.6: Subsequence of array to sort");
		int [] array = {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
		SeventeenPoint6.minMax(array);
		int [] array2 = {1, 2, 4, 7, 10, 11, 12, 13, 16, 16, 18, 19};
		SeventeenPoint6.minMax(array2);
		
		
		/********/
		/* 17.7 */
		/********/
		System.out.println("\n*** Test 17.7: Print number as words");
		System.out.println("This problem was easy so I stopped coding it midway");
		System.out.print("1234: ");
		SeventeenPoint7.print(1234);
		System.out.print("698: ");
		SeventeenPoint7.print(698);
		
		
		/********/
		/* 17.8 */
		/********/
		System.out.println("\n*** Test 17.8: Max Sum (of subsequence)");
		int [] array3 = {2, -8, 3, -2, 4, -10};
		System.out.println("Max Subsequence = " + SeventeenPoint8.maxSum(array3));
		int [] array4 = {-6, -8, -3, -2, -4, -10};
		System.out.println("Max Subsequence = " + SeventeenPoint8.maxSum(array4));
		
		
		/*********/		
		/* 17.12 */
		/*********/
		System.out.println("\n*** Test 17.12: Print pairs in array that sum to value");
		int [] array5 = {5, 2, 7, 3, 1, 5, 7, 7};
		System.out.print("Solution 1: ");
		SeventeenPoint12.printPairsSums(array5, 12);
		System.out.print("\nSolution 2: ");
		SeventeenPoint12.printPairsSums2(array5, 12);
		
		
		/*********/
		/* 17.13 */
		/*********/
		System.out.println("\n\n*** Test 17.13: BiNode");
		
		//////////// Test Solution 0 ////////////
		BiNode _zero  = new BiNode(0);
		BiNode _one   = new BiNode(1);
		BiNode _two   = new BiNode(2);
		BiNode _three = new BiNode(3);
		BiNode _four  = new BiNode(4);
		BiNode _five  = new BiNode(5);
		BiNode _six   = new BiNode(6);
		_four.node1 = _two;
		_four.node2 = _five;
		_two.node1 = _one;
		_two.node2 = _three;
		_five.node2 = _six;
		_one.node1 = _zero;
		SeventeenPoint13.inorderTraverse(_four);
		System.out.println();
		print(SeventeenPoint13.head);
		
		////////////Test Solution 1 ////////////
		/* This is the tree from the book */
		BiNode zero  = new BiNode(0);
		BiNode one   = new BiNode(1);
		BiNode two   = new BiNode(2);
		BiNode three = new BiNode(3);
		BiNode four  = new BiNode(4);
		BiNode five  = new BiNode(5);
		BiNode six   = new BiNode(6);
		four.node1 = two;
		four.node2 = five;
		two.node1 = one;
		two.node2 = three;
		five.node2 = six;
		one.node1 = zero;
		
		NodePair np = SeventeenPoint13.convert(four);
		print(np.head);

		// 17.14 - Code is untestable since we don't have access to dictionary.
	}
	
	private static void print(BiNode n){
		while (n != null){
			System.out.print(n.data + " ");
			n = n.node2;
		}
	}
}
