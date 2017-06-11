package _1_8_Zero_Matrix;

import common.Functions;

public class Tester {
	public static void main(String[] args) {
		System.out.println("*** Test 1.8: Zero Matrix\n");
		int[][] matrix = {{1, 2, 3},
 	            		  {0, 5, 6}};
		
		int[][] matrix2 = {{1, 2, 3, 1},
			               {4, 5, 6, 0},
			               {0, 5, 3, 0}};
		
		testMatrix(matrix);
		testMatrix(matrix2);
	}
	
	private static void testMatrix(int[][] matrix) {
		System.out.println("Original matrix");
		Functions.printImage(matrix); // uses print function above in 1.6
		System.out.println("Zero out necessary rows/columns");
		ZeroMatrix.zero(matrix);
		Functions.printImage(matrix);
		System.out.println();
	}
}
