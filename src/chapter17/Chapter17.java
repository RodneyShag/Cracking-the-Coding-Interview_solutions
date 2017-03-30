package chapter17;

public class Chapter17 {
	public static void main (String [] args) {
		test_SeventeenPoint1();
		test_SeventeenPoint2();
		test_SeventeenPoint3();
		test_SeventeenPoint4();
		test_SeventeenPoint5();
		test_SeventeenPoint6();
		test_SeventeenPoint7();
		test_SeventeenPoint8();
		// 17.9: Skip (too easy). Simply save document into a HashMap<String, Integer>
		// 17.10: Skip (Bad, outdated problem)
		// 17.11: Can't test due to randomness in solution
		test_SeventeenPoint12();
		test_SeventeenPoint13();
		// 17.14: Skip (Too difficult for interview)
	}
	
	public static void test_SeventeenPoint1() {
		System.out.println("*** Test 17.1: Swap in place");
		SeventeenPoint01.swap(2, 4);
		SeventeenPoint01.swap(3, 5);
	}
	
	public static void test_SeventeenPoint2() {
		System.out.println("\n\n*** Test 17.2: Tic-tac-toe");
		char [][] board = { {'x', 'o', 'x'},
							{' ', ' ', ' '},
							{' ', ' ', ' '} };
		int intValue = SeventeenPoint02.convertBoardToInt(board);
		System.out.println("Board int value (should be 23): " + intValue);
	}
	
	public static void test_SeventeenPoint3() {
		System.out.println("\n\n*** Test 17.3: number of trailing 0s in n!");
		System.out.println("8! = " + calculateFactorial(8) + "      # Trailing 0s = " + SeventeenPoint03.numTrailingZeros(8));
		System.out.println("9! = " + calculateFactorial(9) + "      # Trailing 0s = " + SeventeenPoint03.numTrailingZeros(9));
		System.out.println("10! = " + calculateFactorial(10) + "    # Trailing 0s = " + SeventeenPoint03.numTrailingZeros(10));
		System.out.println("20! = " + calculateFactorial(20) + "    # Trailing 0s = " + SeventeenPoint03.numTrailingZeros(20));
	}
	
	private static long calculateFactorial(long num) {
		if (num > 20) {
			return -1; // since result may cause overflow
		}
		long result = 1;
		while (num > 1) {
			result *= num;
			num--;
		}
		return result;
	}
	
	public static void test_SeventeenPoint4() {
		System.out.println("\n\n*** Test 17.4: Detect Max of 2 ints (without if-else or comparators)");
		System.out.println("0 means negative, 1 means positive");

		System.out.println("-61  (Sign): " + SeventeenPoint04.sign(-61));
		System.out.println("-252 (Sign): " + SeventeenPoint04.sign(-252));
		System.out.println(" 61  (Sign): " + SeventeenPoint04.sign(61));
		System.out.println(" 252 (Sign): " + SeventeenPoint04.sign(252));
		System.out.println("max(-3, -5): " + SeventeenPoint04.max(-3, -5));
		System.out.println("max(0, 8)  : " + SeventeenPoint04.max(0, 8));
		System.out.println("max(-3, 5) : " + SeventeenPoint04.max(-3, 5));
	}
	
	public static void test_SeventeenPoint5() {
		System.out.println("\n\n*** Test 17.5: Mastermind");
		System.out.println("Solution = RGBY\nGuess    = GGRR\n" + SeventeenPoint05.estimate("RGBY", "GGRR") + '\n');
		System.out.println("Solution = RRRG\nGuess    = GGRR\n" + SeventeenPoint05.estimate("RRRG", "GGRR") + '\n');
		System.out.println("Solution = YYBY\nGuess    = BBBB\n" + SeventeenPoint05.estimate("YYBY", "BBBB") + '\n');
	}
	
	public static void test_SeventeenPoint6() {
		System.out.println("\n*** Test 17.6: Subsequence of array to sort");
		SeventeenPoint06.minMax(new int[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19});
		SeventeenPoint06.minMax(new int[]{1, 2, 4, 7, 10, 11, 12, 13, 16, 16, 18, 19});
		SeventeenPoint06.minMax(new int[]{4, 6, 5, 2, 9, 8, 7, 10});
	}
	
	public static void test_SeventeenPoint7() {
		System.out.println("\n\n*** Test 17.7: Print number as words");
		for (int i = 0; i < 23; i++) {
			System.out.println(i + ": " + SeventeenPoint07.numToString(i));
		}
		System.out.println(100 + ": " + SeventeenPoint07.numToString(100));
		System.out.println(2998 + ": " + SeventeenPoint07.numToString(2998));
		System.out.println(253513 + ": " + SeventeenPoint07.numToString(253513));
		System.out.println(10090034 + ": " + SeventeenPoint07.numToString(10090034));
	}
	
	public static void test_SeventeenPoint8() {
		System.out.println("\n*** Test 17.8: Max Sum (of subsequence)");
		int [] array3 = {2, -8, 3, -2, 4, -10};
		System.out.println("Max Subsequence = " + SeventeenPoint08.maxSum(array3));
		int [] array4 = {-6, -8, -3, -2, -4, -10};
		System.out.println("Max Subsequence = " + SeventeenPoint08.maxSum(array4));
	}
	
	public static void test_SeventeenPoint12() {
		System.out.println("\n*** Test 17.12: Print pairs in array that sum to value");
		int [] array5 = {5, 2, 7, 3, 1, 5, 7, 7};
		SeventeenPoint12.printPairsSums(array5, 12);
	}
	
	public static void test_SeventeenPoint13() {
		System.out.println("\n\n*** Test 17.13: BiNode");
		
		/* Testing the tree from the book 
		 * 
		 *             4
		 *           2   5
		 *          1 3   6
		 *         0
		 */
		
		//////////// Test Solution 1 ////////////
		BiNode _zero  = new BiNode(0);
		BiNode _one   = new BiNode(1);
		BiNode _two   = new BiNode(2);
		BiNode _three = new BiNode(3);
		BiNode _four  = new BiNode(4);
		BiNode _five  = new BiNode(5);
		BiNode _six   = new BiNode(6);
		_four.left = _two;
		_four.right = _five;
		_two.left = _one;
		_two.right = _three;
		_five.right = _six;
		_one.left = _zero;
		SeventeenPoint13.inorderTraverse(_four);
		System.out.print("Solution 1: ");
		print(SeventeenPoint13.head);

		////////////Test Solution 2 ////////////
		
		/* This is the tree from the book 
		 * 
		 *             4
		 *           2   5
		 *          1 3   6
		 *         0
		 * 
		 */
		BiNode zero  = new BiNode(0);
		BiNode one   = new BiNode(1);
		BiNode two   = new BiNode(2);
		BiNode three = new BiNode(3);
		BiNode four  = new BiNode(4);
		BiNode five  = new BiNode(5);
		BiNode six   = new BiNode(6);
		four.left = two;
		four.right = five;
		two.left = one;
		two.right = three;
		five.right = six;
		one.left = zero;
		NodePair np = SeventeenPoint13.convert(four);
		System.out.print("\nSolution 2: ");
		print(np.head);
	}
	
	private static void print(BiNode n) {
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.right;
		}
	}
}
