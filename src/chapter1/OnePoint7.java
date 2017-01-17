package chapter1;

public class OnePoint7 {
	public static void main (String [] args){
		int [][] matrix =  {{1, 2, 3},
             	            {0, 5, 6}};
		
		int [][] matrix2 = {{1, 2, 3, 1},
				            {4, 5, 6, 0},
				            {0, 5, 3, 0}};
		
		testImage(matrix);
		testImage(matrix2);
	}
	
	/* Zeros out necessary rows/columns */
	public static void zero(int [][] array){
		/* To store which rows or columns should become 0 */
		int m = array.length;
		int n = array[0].length;
		
		boolean [] rows = new boolean[m];
		boolean [] cols = new boolean[n];
		
		/* Figure out which rows & columns should become 0 */
		for (int row = 0; row < m; row++){
			for (int col = 0; col < n; col++){
				if (array[row][col] == 0){
					rows[row] = true;
					cols[col] = true;
				}
			}
		}
		
		/* Re-loop through 2-d matrix and set whichever entries are necessary to 0 */
		for (int row = 0; row < m; row++){
			for (int col = 0; col < n; col++){
				if (rows[row] == true || cols[col] == true)
					array[row][col] = 0;
			}
		}
	}
	
	/* Prints matrix */
	public static void printMatrix(int [] [] matrix){
		for (int i = 0; i < matrix.length; i++){
			for (int j = 0; j < matrix[0]. length; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	/* Tests our code on a given image */
	private static void testImage(int [][] matrix){
		System.out.println("***********************************\n");
		printMatrix(matrix);
		System.out.println("Zero out necessary rows/columns\n");
		zero(matrix);
		printMatrix(matrix);
		System.out.println();
	}
}
