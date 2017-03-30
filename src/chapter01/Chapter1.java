package chapter01;

import java.util.ArrayList;
import java.util.HashMap;

public class Chapter1 {
	public static void main (String [] args) {
		testHashMap();
		testArrayList();
		testStringBuffer();
		test_OnePoint1();
		// skipped 1.2 since it's C++
		test_OnePoint3();
		test_OnePoint4();
		test_OnePoint5();
		test_OnePoint6();
		test_OnePoint7();
		test_OnePoint8();
	}
	
	/* HashMap */
	public static void testHashMap() {
		System.out.println("*** Test HashMap");
		String [] strings = {"Bob", "Jane", "Alex"};
		HashMap<Integer, String> map = IntroHashMap.buildMap(strings);
		for (Integer key : map.keySet()) {
			System.out.println("key = " + key + "   value = " + map.get(key));
		}
	}
	
	/* ArrayList */
	public static void testArrayList() {
		System.out.println("\n*** Test ArrayList");
		ArrayList<String> strings = new ArrayList<String>();

		String [] string1 = {"Hi", "there"};
		String [] string2 = {"Robert", "Jones"};
		
		strings = IntroArrayList.merge(string1, string2);
		for (String string : strings) {
			System.out.print(string + " ");
		}
	}
	
	/* StringBuffer */
	public static void testStringBuffer() {
		System.out.println("\n\n*** Test StringBuffer");
		String [] myStrings = {"Hi ", "there ", "Rob. ", "How ", "are ", "you?"};
		System.out.println(IntroStringBuffer.joinWords(myStrings));
	}
	
	/* 1.1 */
	public static void test_OnePoint1() {
		System.out.println("\n*** Test 1.1: Unique characters?");
		test_OnePoint1_helper("Benny");
		test_OnePoint1_helper("Ben");
		test_OnePoint1_helper("Alex");
	}
	
	private static void test_OnePoint1_helper(String str) {
		System.out.println("\n" + str);
		System.out.println("Solution 1: " + OnePoint1.uniqueCharacters_1(str));
		System.out.println("Solution 2: " + OnePoint1.uniqueCharacters_2(str));
	}
	
	/* 1.3 */
	public static void test_OnePoint3() {
		System.out.println("\n*** Test 1.3: Permutations");
		System.out.println(OnePoint3.isPermutation_1("hello", "olhel"));
		System.out.println(OnePoint3.isPermutation_1("james", "bean"));
	}
	
	/* 1.4 */
	public static void test_OnePoint4() {
		System.out.println("\n*** Test 1.4: Replace spaces with %20");
		test_OnePoint4_helper("Dad is smart    ");
	}
	
	private static void test_OnePoint4_helper(String s) {
		char [] sentence = s.toCharArray();
		System.out.println(sentence);
		OnePoint4.replaceWhitespace(sentence, sentence.length - 4); // -4 is hard-coded.
		System.out.println(sentence);
	}
	
	/* 1.5 */
	public static void test_OnePoint5() {
		System.out.println("\n*** Test 1.5");
		test_OnePoint5_helper("aabcccccaaa");
		test_OnePoint5_helper("abababa");
	}
	
	private static void test_OnePoint5_helper(String original) {
		System.out.println("Original string = " + original);
		String compressed = OnePoint5.basicCompression(original);
		System.out.println("Solution: " + compressed);	
	}
	
	/* 1.6 */
	public static void test_OnePoint6() {
		System.out.println("\n*** Test 1.6");
		int [] [] image = {{1, 2},
                           {3, 4}};

		int [] [] image2 = {{1, 2, 3},
		                 {4, 5, 6},
		                 {7, 8, 9}};
		
		int [] [] image3 = {{ 1,  2,  3,  4},
		                 { 5,  6,  7,  8},
		                 { 9, 10, 11, 12},
		                 {13, 14, 15, 16}};
		
		int[][] image4 = {{ 1,  2,  3,  4,  5},
						  { 6,  7,  8,  9, 10},
						  {11, 12, 13, 14, 15},
						  {16, 17, 18, 19, 20},
						  {21, 22, 23, 24, 25}};
		
		testImage(image);
		testImage(image2);
		testImage(image3);
		testImage(image4);
	}
	
	private static void printImage(int [] [] image) {
		for (int i = 0; i < image.length; i++){
			for (int j = 0; j < image[0].length; j++){
				System.out.printf("%2d ", image[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private static void testImage(int [][] image) { // tests our rotations on a given image
		System.out.println("Original image");
		printImage(image);
		System.out.println("Rotated 90 degrees clockwise");
		OnePoint6.rotate90clockwise(image);
		printImage(image);
		System.out.println("Rotated anoter 180 degrees clockwise");
		OnePoint6.rotate180(image);  //notice this rotates the already 90-degree rotated image.
		printImage(image);
		System.out.println();
	}
	
	/* 1.7 */
	public static void test_OnePoint7() {
		System.out.println("*** Test 1.7");
		int [][] matrix =  {{1, 2, 3},
 	            {0, 5, 6}};

		int [][] matrix2 = {{1, 2, 3, 1},
			            {4, 5, 6, 0},
			            {0, 5, 3, 0}};
		
		testMatrix(matrix);
		testMatrix(matrix2);
	}
	
	private static void printMatrix(int [] [] matrix) {
		for (int i = 0; i < matrix.length; i++){
			for (int j = 0; j < matrix[0]. length; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private static void testMatrix(int [][] matrix) {
		System.out.println("Original matrix");
		printMatrix(matrix);
		System.out.println("Zero out necessary rows/columns");
		OnePoint7.zero(matrix);
		printMatrix(matrix);
		System.out.println();
	}
	
	/* 1.8 */
	public static void test_OnePoint8() {
		System.out.println("*** Test 1.8");
		test_OnePoint8_helper("waterbottle", "erbottlewat");
		test_OnePoint8_helper("", "erbottlewat");
		test_OnePoint8_helper("tooth", "candy");
	}
	
	private static void test_OnePoint8_helper(String s1, String s2) {
		System.out.println(s1 + ", " + s2 + "  --> " + OnePoint8.isRotation(s1, s2));
	}
}
