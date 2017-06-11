package _1_8_Zero_Matrix;

public class ZeroMatrix {
	public static void zero(int[][] array) {
		int M = array.length;
		int N = array[0].length;

		/* Figure out which rows & columns should become 0 */
		boolean[] rows = new boolean[M];
		boolean[] cols = new boolean[N];
		for (int row = 0; row < M; row++) {
			for (int col = 0; col < N; col++) {
				if (array[row][col] == 0) {
					rows[row] = true;
					cols[col] = true;
				}
			}
		}

		/* Re-loop through 2-d matrix and set whichever entries are necessary to 0 */
		for (int row = 0; row < M; row++) {
			for (int col = 0; col < N; col++) {
				if (rows[row] == true || cols[col] == true) {
					array[row][col] = 0;
				}
			}
		}
	}
}
