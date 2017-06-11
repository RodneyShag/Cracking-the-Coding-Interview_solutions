package _1_7_Rotate_Matrix;

import common.Functions;

public class Tester {
	public static void main(String[] args) {
		System.out.println("*** Test 1.7: Rotate Matrix\n");
		int[][] image1 = { { 1, 2 }, { 3, 4 } };

		int[][] image2 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		int[][] image3 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		int[][] image4 = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
				{ 21, 22, 23, 24, 25 } };

		test(image1);
		test(image2);
		test(image3);
		test(image4);
	}

	private static void test(int[][] image) {
		System.out.println("Original image");
		Functions.printImage(image);

		System.out.println("Rotated 90 degrees clockwise");
		RotateMatrix.rotate90clockwise(image);
		Functions.printImage(image);

		System.out.println("Rotated ANOTHER 180 degrees clockwise");
		RotateMatrix.rotate180(image); // this rotates the already 90-degree
										// rotated image.
		Functions.printImage(image);
		System.out.println();
	}
}
