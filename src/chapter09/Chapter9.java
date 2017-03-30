package chapter09;

import java.util.ArrayList;

public class Chapter9 {
	public static void main(String [] args) {
		test_Fibonacci();
		test_NinePoint1();
		test_NinePoint2();
		test_NinePoint3();
		test_NinePoint4();
		test_NinePoint5();
		test_NinePoint6();
		// 9.7: No testing. Written code is same as book's code.		
		test_NinePoint8();
		test_NinePoint9();
		test_NinePoint10();
		test_NinePoint11();
	}
	
	/* Fibonacci */
	public static void test_Fibonacci() {
		System.out.println("*** Test Fibonacci");
		System.out.print("\nSolution 2 (Starting from 1):   ");
		for (int i = 0; i < 16; i++) {
			System.out.print(Fibonacci.fib(i) + " ");
		}
		System.out.print("\nSolution 2 (Starting from 0): ");
		for (int i = 0; i < 16; i++) {
			System.out.print(Fibonacci.fibIterative(i) + " ");
		}
	}
	
	/* 9.1 */
	public static void test_NinePoint1() {
		System.out.println("\n\n\n*** Test 9.1: Staircase Problem");
		System.out.println("(Iterative Solution) 3 Step Staircase: " + NinePoint01.numPathsIterative(3));
		System.out.println("(Recursive Solution) 3 Step Staircase: " + NinePoint01.numPathsRecursive(3));
		System.out.println("(Iterative Solution) 5 Step Staircase: " + NinePoint01.numPathsIterative(5));
		System.out.println("(Iterative Solution) 5 Step Staircase: " + NinePoint01.numPathsRecursive(5));
	}

	/* 9.2 */
	public static void test_NinePoint2() {
		System.out.println("\n\n*** Test 9.2: paths from (0,0) to (x,y)");		
		System.out.println("Number of Paths in 1x1 maze = " + NinePoint02.numPaths(1, 1));
		System.out.println("Number of Paths in 2x2 maze = " + NinePoint02.numPaths(2, 2));
		System.out.println("Number of Paths in 3x3 maze = " + NinePoint02.numPaths(3, 3));
		
		/************ Follow-up: Find solution path ************/
		/* Create maze */
		boolean [][] maze = new boolean[3][3];
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				maze[row][col] = true;
			}
		}
		
		/* Find and print solution */
		ArrayList<Point> path = NinePoint02.findPath(maze, 2, 2);
		System.out.print("\nOld Path: " + path);
		
		/* Add walls to block the original solution path, to see if it will find a different solution */
		maze[1][1] = false;
		maze[2][1] = false;
		
		/* Find and print solution */
		path = NinePoint02.findPath(maze, 2, 2);
		System.out.print("\nNew Path: " + path);

		/************ Follow-up: Find all solution paths ************/
		maze[1][1] = true;
		maze[2][1] = true;
		ArrayList<ArrayList<Point>> solutionPaths = NinePoint02.allPaths(maze, 2, 2);
		printAllPaths(solutionPaths);
	}
	
	private static void printAllPaths(ArrayList<ArrayList<Point>> solutionPaths) {
		if (solutionPaths != null) {
			System.out.print("\n\nAll solution paths:\n");
			for (ArrayList<Point> path : solutionPaths) {
				System.out.println(path);
			}
		}
	}
	
	/* 9.3 */
	public static void test_NinePoint3() {
		System.out.println("\n\n*** Test 9.3: Find array[i] == i");
		int [] sortedArray = {-5, -3, -1, 3, 5};
		System.out.println("(Result should be 3) = " + NinePoint03.magicFast(sortedArray));

		int [] sortedArray2 = {-10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13};
		System.out.println("(Result should be 2) = " + NinePoint03.magicFast2(sortedArray2));
	}
	
	/* 9.4 */
	public static void test_NinePoint4() {	
		System.out.println("\n\n*** Test 9.4: Power set of set");
		ArrayList<Integer> set = new ArrayList<Integer>();
		set.add(3);
		set.add(4);
		set.add(5);
		
		ArrayList<ArrayList<Integer>> subsets = NinePoint04.getSubsets(set);
		System.out.println("Original set is {3, 4, 5}");
		System.out.println("Subsets: " + subsets);
	}
	
	/* 9.5 */
	public static void test_NinePoint5() {
		System.out.println("\n\n*** Test 9.5: Permutations of a string");
		String str = "cat";
		ArrayList<String> permutations = NinePoint05.getPermutations(str);
		System.out.println("Original string: " + str);
		System.out.println("Permutations:" + permutations);
	}
	
	/* 9.6 */	
	public static void test_NinePoint6() {
		System.out.println("\n\n*** Test 9.6: Generate pairs of parentheses");
		ArrayList<String> list = NinePoint06.generateParentheses(3);
		for (String str : list) {
			System.out.println(str);
		}
		System.out.println("Number of solutions: " + list.size());	
	}
	
	/* 9.8 */
	public static void test_NinePoint8() {
		System.out.println("\n\n*** Test 9.8: Make Change");
		System.out.println("# of ways to make 100 (Using Quarters, Dimes, Nickels, Pennies) = " + NinePoint08.makeChange(100));
		System.out.println("# of ways to make 5 (Using Quarters, Dimes, Nickels, Pennies) = " + NinePoint08.makeChange(5));
	}
	
	/* 9.9 */
	public static void test_NinePoint9() {
		System.out.println("\n\n*** Test 9.9: Eight Queens");
		ArrayList<Integer[]> results = NinePoint09.placeQueens();
		for (Integer[] board : results) {
			printBoard(board);
		}
	}
	
	private static void printBoard(Integer[] board) {
		for (int i = 0; i < board.length; i++) {
			System.out.print("(" + i + "," + board[i] + ") ");
		}
		System.out.println();
	}
		
	/* 9.10 */
	public static void test_NinePoint10() {
		System.out.println("\n\n*** Test 9.10: Box stacking");
		ArrayList<Box> boxes = new ArrayList<>();
		boxes.add(new Box(3,4,1));
		boxes.add(new Box(8,6,2));
		boxes.add(new Box(4,8,3));
		
		ArrayList<Box> stack = NinePoint10.buildTallestStack(boxes);	
		for (int i = stack.size() - 1; i >= 0; i--) {
			Box box = stack.get(i);
			System.out.println(box);
		}
	}
	
	/* 9.11 */
	public static void test_NinePoint11() {
		System.out.println("\n\n*** Test 9.11: Parenthesize Expression");
		System.out.println("# of ways to parenthesize 1^0|0|1 to be false = " + NinePoint11.f("1^0|0|1", false));
	}
}
