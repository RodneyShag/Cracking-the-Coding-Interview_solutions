package chapter9;
import java.util.ArrayList;
import java.util.HashMap;

public class Chapter9 {
	public static void main (String [] args){
		/******************/
		/* Test Fibonacci */
		/******************/
		System.out.println("*** Test Fibonacci");
		for (int i = 0; i < 16; i++)
			System.out.print(Fibonacci.fib(i) + " ");
		System.out.println();
		for (int i = 0; i < 16; i++)
			System.out.print(Fibonacci.fibIterative(i) + " ");
		
		/************/
		/* Test 9.1 */
		/************/
		System.out.println("\n\n*** Test 9.1");
		System.out.println("3 Steps: " + NinePoint1.steps_A(3));
		System.out.println("3 Steps: " + NinePoint1.steps_B(3));
		
		System.out.println("5 Steps: " + NinePoint1.steps_A(5));
		System.out.println("5 Steps: " + NinePoint1.steps_B(5));
		
		/************/
		/* Test 9.2 */
		/************/
		System.out.println("\n\n*** Test 9.2");
		boolean [][] maze = new boolean[3][3];
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				maze[i][j] = true;
			}
		}
		
		boolean [][] maze2 = new boolean[7][7];
		for (int i = 0; i < 7; i++){
			for (int j = 0; j < 7; j++){
				maze2[i][j] = true;
			}
		}
		
		System.out.println("Solution 1: Number of Paths in 2x2 maze = " + NinePoint2.numPaths(maze, 2, 2));
		System.out.println("Solution 2: Number of Paths in 2x2 maze = " + NinePoint2.numPaths2(maze, 2, 2));
		System.out.println("Solution 1: Number of Paths in 5x6 maze = " + NinePoint2.numPaths(maze2, 6, 6));
		System.out.println("Solution 2: Number of Paths in 5x6 maze = " + NinePoint2.numPaths2(maze2, 6, 6) + "\n");
		
		ArrayList<Point> path = NinePoint2.findPath(maze, 2, 2);
		for (Point p : path){
			System.out.println("(" + p.x + "," + p.y + ")");
		}
		
		/************/
		/* Test 9.3 */
		/************/
		System.out.println("\n\n*** Test 9.3: Find array[i] == i");
		int [] sortedArray = {-5, -3, -1, 3, 5};
		System.out.println("(Result should be 3) = " + NinePoint3.magicFast(sortedArray));

		int [] sortedArray2 = {-10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13};
		System.out.println("(Result should be 2) = " + NinePoint3.magicFast2(sortedArray2));

		
		/************/
		/* Test 9.4 */
		/************/
		System.out.println("\n\n*** Test 9.4: Power set of set");
		ArrayList<Integer> set = new ArrayList<Integer>();
		set.add(3);
		set.add(4);
		set.add(5);
		
		ArrayList<ArrayList<Integer>> subsets = NinePoint4.getSubsets(set);
		System.out.print("Original set is {3, 4, 5}");
		for (ArrayList<Integer> list : subsets){
			for (Integer i : list){
				System.out.print(i + " ");
			}
			System.out.println();
		}
		
		ArrayList<ArrayList<Integer>> subsets2 = NinePoint4.getSubsetsRecursive(set, 0);
		System.out.print("Original set is {3, 4, 5}");
		for (ArrayList<Integer> list : subsets2){
			for (Integer i : list){
				System.out.print(i + " ");
			}
			System.out.println();
		}
		
		
		// 9.5: Code is exactly book's code. No need to test.
		// 9.6: Code is exactly book's code. No need to test.
		// 9.7: Code is exactly book's code. No need to test.
	
		/************/
		/* Test 9.8 */
		/************/
		System.out.println("\n\n*** Test 9.8: Make Change");
		System.out.println("# of ways to make 100 (Using Quarters, Dimes, Nickels, Pennies) = " + NinePoint8.makeChange(100, 25));
		System.out.println("# of ways to make 5 (Using Quarters, Dimes, Nickels, Pennies) = " + NinePoint8.makeChange(5, 25));
		
		
		/************/
		/* Test 9.9 */
		/************/
		System.out.println("\n\n*** Test 9.9: Eight Queens");
		ArrayList<Integer[]> results = NinePoint9.placeQueens();
		for (Integer[] answer : results){
			for (int i = 0; i < answer.length; i++){
				System.out.print("(" + i + "," + answer[i] + ") ");
			}
			System.out.println();
		}
		
		
		// 9.10 Code is exactly book's code. No need to test.
		
		
		/*************/
		/* Test 9.11 */
		/*************/
		System.out.println("\n\n*** Test 9.11: Parenthesize Expression");
		System.out.println("# of ways to parenthesize 1^0|0|1 to be false = " + NinePoint11.f("1^0|0|1", false));
		
	}
}
