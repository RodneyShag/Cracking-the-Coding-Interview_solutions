package common;

public class Functions {
	public static void printImage(int[][] image) {
		int rows = image.length;
		int cols = image[0].length;
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				System.out.printf("%2d ", image[row][col]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
