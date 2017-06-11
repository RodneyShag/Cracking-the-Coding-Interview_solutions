package _16_19_Pond_Sizes;

import java.util.ArrayList;

public class Tester {
	public static void main(String[] args) {
		System.out.println("*** Test 16.19: Pond Sizes\n");
		int[][] grid = {{0, 2, 1, 0},
						{0, 2, 0, 1},
						{1, 1, 0, 1},
						{0, 1, 0, 1}};
		test(grid);
	}
	
	private static void test(int[][] grid) {
		ArrayList<Integer> pondSizes = PondSizes.findPonds(grid);
		System.out.println(pondSizes);
	}
}
