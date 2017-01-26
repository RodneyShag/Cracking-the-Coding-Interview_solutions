package chapter01;

/* If I can figure out the (simple) algorithm, coding it is simple */
public class OnePoint7 {
	
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
}
