package _17_24_Max_Submatrix;

public class Tester {
	public static void main(String[] args) {
		System.out.println("*** Test 17.24: Max Submatrix\n");
        int[][] matrix = {{ 1,-2, 3, 1},
		                  { 1, 5,-4, 1},
		                  { 1, 1, 0, 2},
		                  {-1, 1, 1,-8},
		                  {-8,-9, 9,-3}};
        test(matrix);
	}
	
	private static void test(int[][] matrix) {
		System.out.println("(Solution 1): " + MaxSubmatrix.findLargestSubmatrix(matrix));
		System.out.println("(Solution 2): " + MaxSubmatrix.findLargestSubmatrix2(matrix));
		System.out.println("(Solution 3): " + MaxSubmatrix.findLargestSubmatrix3(matrix));
	}
}
