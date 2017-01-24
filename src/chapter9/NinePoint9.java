package chapter9;

import java.util.ArrayList;

/* Tricks:
 * 1) Represent a solution ChessBoard as an Integer[] with 8 elements (since there is a queen on each row)
 * 2) Represent all solutions as ArrayList<Integer[]>.
 * - we don't cache previous results since we are looking for ALL possible solutions (Like Problem 9.2 part 3 "find all paths" question)
 */
public class NinePoint9 {
	static private final int GRID_SIZE = 8;
	
	/* Wrapper */
	public static ArrayList<Integer[]> placeQueens(){ // java won't let us do do int[] inside ArrayList<>
		Integer [] board = new Integer[GRID_SIZE]; // Index is Queen's row. Value is Queen's column.
		ArrayList<Integer[]> results = new ArrayList<Integer[]>();
		placeQueens(0, board, results);
		return results;
	}
	
	/* Main Algo */
	private static void placeQueens(int row, Integer[] board, ArrayList<Integer[]> results){
		if (row == GRID_SIZE){
			/* Here, .clone() creates another Integer[] with its own deep copied Integers. If instead of Integer[] we had an array of objects, 
               .clone() would still create another array of objects, but the objects would not be deep copied (they would be references to the
               original objects). This is because Integer, although an object, works differently than other objects that contain data. 
               See my written lesson in "Lessons" package called ShallowDeep.java for more info */
			results.add((Integer[]) board.clone());	// no compiler warnings even if we omit typecast
		}
		else{
			for (int col = 0; col < GRID_SIZE; col++){
				if (checkValid(board, row, col)){
					board[row] = col;
					placeQueens(row + 1, board, results);
				}
			}
		}
	}
	
	/* Straightforward. Make sure I get the parameters right though, and don't forget Math.abs() */
	private static boolean checkValid(Integer[] board, int rowNew, int colNew){
		for (int rowOld = 0; rowOld < rowNew; rowOld++){
			Integer colOld = board[rowOld];
			
			/* Check same column */
			if (colOld == colNew)
				return false;
			
			/* Check same diagonal */
			int rowDistance = rowNew - rowOld; //always positive
			int colDistance = Math.abs(colNew - colOld);
			if (colDistance == rowDistance)
				return false;
		}
		
		return true;
	}
}
