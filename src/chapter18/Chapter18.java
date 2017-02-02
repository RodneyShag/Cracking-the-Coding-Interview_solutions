package chapter18;

import java.util.Arrays;
import java.util.LinkedList;

public class Chapter18 {
	public static void main (String [] args){
		test_EighteenPoint1();
		// 18.2 - Can't test randomness
		// 18.3 - Can't test randomness
		test_EighteenPoint4();
		test_EighteenPoint5();
		test_EighteenPoint6();
		test_EighteenPoint7();
		// 18.8 - Skip (First learn tries. Then maybe do this suffix tree problem)
		test_EighteenPoint9();
		test_EighteenPoint10();
		test_EighteenPoint11();
		test_EighteenPoint12();
		// 18.13: Skip (too complicated for an interview)
	}
	
	public static void test_EighteenPoint1(){
		System.out.println("*** Test 18.1: Add 2 numbers (without using +)");
		System.out.println("17 + 34 = " + EighteenPoint01.add(17, 34));
		System.out.println("-17 + 34 = " + EighteenPoint01.add(-17, 34));
		System.out.println("17 + -34 = " + EighteenPoint01.add(17, -34));
		System.out.println("-17 + -34 = " + EighteenPoint01.add(-17, -34));
		System.out.println();
		System.out.println("17 + 34 = " + EighteenPoint01.addBook(17, 34));
		System.out.println("-17 + 34 = " + EighteenPoint01.addBook(-17, 34));
		System.out.println("17 + -34 = " + EighteenPoint01.addBook(17, -34));
		System.out.println("-17 + -34 = " + EighteenPoint01.addBook(-17, -34));
		System.out.println();
		System.out.println("9 + 234 = " + EighteenPoint01.add(9, 234));
		System.out.println("-9 + 234 = " + EighteenPoint01.add(-9, 234));
		System.out.println("9 + -234 = " + EighteenPoint01.add(9, -234));
		System.out.println("-9 + -234 = " + EighteenPoint01.add(-9, -234));
		System.out.println();
		System.out.println("9 + 234 = " + EighteenPoint01.addBook(9, 234));
		System.out.println("-9 + 234 = " + EighteenPoint01.addBook(-9, 234));
		System.out.println("9 + -234 = " + EighteenPoint01.addBook(9, -234));
		System.out.println("-9 + -234 = " + EighteenPoint01.addBook(-9, -234));
	}
	
	public static void test_EighteenPoint4(){
		System.out.println("\n\n*** Test 18.4: Count 2s in range 1...n");
		System.out.println("(from 1 to 99): " + EighteenPoint04.count2s(99));
	}
	
	public static void test_EighteenPoint5(){
		System.out.println("\n\n*** Test 18.5: Shortest distance between 2 words in a file");
		String [] file = {"hey", "there", "hi", "food", "there", "now", "hope", "hi", "food", "now", "gone", "hey"};
		System.out.println(Arrays.toString(file));
		
		EighteenPoint05.preProcess(file);
		
		System.out.println("(Solution 1) (there, food) Distance = " + EighteenPoint05.shortest(file, "there", "food"));
		System.out.println("(Solution 2) (there, food) Distance = " + EighteenPoint05.shortest2("there", "food"));

		System.out.println("\n(Solution 1) (now, hi) Distance = " + EighteenPoint05.shortest(file, "now", "hi"));
		System.out.println("(Solution 2) (now, hi) Distance = " + EighteenPoint05.shortest2("now", "hi"));
		
		System.out.println("\n(Solution 1) (gone, hi) Distance = " + EighteenPoint05.shortest(file, "gone", "hi"));
		System.out.println("(Solution 2) (gone, hi) Distance = " + EighteenPoint05.shortest2("gone", "hi"));
	}
	
	public static void test_EighteenPoint6(){
		System.out.println("\n\n*** Test 18.6: Find n smallest elements in an array");
		int [] array = {52, 14, 16, 17, 26, 31, 16, 0, 6, 19, 6, 26, 14, 26, 22, 25};
		System.out.println(Arrays.toString(array));

		System.out.print("\n3 Smallest: ");
		EighteenPoint06.findNthSmallestNums(array, 3);
		System.out.print("\n8 Smallest: ");
		EighteenPoint06.findNthSmallestNums(array, 8);
		System.out.print("\n12 Smallest: ");
		EighteenPoint06.findNthSmallestNums(array, 12);
	}
	
	public static void test_EighteenPoint7(){
		System.out.println("\n\n\n*** Test 18.7: Find longest word composed of other words");
		String [] array1 = {"cat", "banana", "dog", "nana", "walk", "walker", "dogwalker", "spectaculous"};
		String [] array2 = {"cat", "banana", "dog", "nana", "walk", "nanadogwalkercat", "walker", "dogwalker"};

		System.out.print(Arrays.toString(array1));
		System.out.println("\nSolution: " + EighteenPoint07.longestWord(array1));
		
		System.out.print("\n" + Arrays.toString(array2));
		System.out.println("\nSolution: " + EighteenPoint07.longestWord(array2));
	}
	
	public static void test_EighteenPoint9(){
		System.out.println("\n\n*** Test 18.9: Keep track of median");
        for (int i = 0; i < 5; i++) {
            EighteenPoint09.addNum(i);
            System.out.println("Add " + i + " to data structure.  Median = " + EighteenPoint09.getMedian());
        }
	}
	
	public static void test_EighteenPoint10(){
		System.out.println("\n\n*** Test 18.10: Transform 1 word into another (changing 1 letter at a time)");
		EighteenPoint10.setUpDict();
		LinkedList<String> solution = EighteenPoint10.convert("Damp", "Like");
		System.out.println(solution);
	}
	
	public static void test_EighteenPoint11(){
		System.out.println("\n\n*** Test 18.11: Find maximum subsquare with black borders");
        int[][] matrix = {{1,0,1,1,1},
		                  {1,1,1,0,1},
		                  {1,1,1,1,1},
		                  {1,1,1,1,0},
		                  {1,0,1,0,1}};
		System.out.println(EighteenPoint11.findLargestSubsquare(matrix));
		System.out.println(EighteenPoint11.findLargestSubsquare2(matrix));
	}
	
	public static void test_EighteenPoint12(){
		System.out.println("\n\n*** Test 18.12: Find submatrix with largest possible sum");
        int[][] matrix = {{ 1,-2, 3, 1},
		                  { 1, 5,-4, 1},
		                  { 1, 1, 0, 2},
		                  {-1, 1, 1,-8},
		                  {-8,-9, 9,-3}};
		System.out.println("(Solution 1): " + EighteenPoint12.findLargestSubmatrix(matrix));
		System.out.println("(Solution 2): " + EighteenPoint12.findLargestSubmatrix2(matrix));
		System.out.println("(Solution 3): " + EighteenPoint12.findLargestSubmatrix3(matrix));
	}
}
