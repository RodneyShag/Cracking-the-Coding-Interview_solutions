package chapter9;
import java.util.ArrayList;

/* Code from book. Tricks:
 * 1) Notice that we can represent a solution ChessBoard as an Integer[] with 8 elements (since there is a queen on each row)
 * 2) Represent all solutions as ArrayList<Integer[]>.
 * - I think this is kinda like a DFS.
 * - I don't think we can "cache" previous results since we are looking for ALL possible solutions.
 */
public class NinePoint9 {	//could have also done it as ArrayList<ArrayList<Integer>>
	static int GRID_SIZE = 8;
	
	/* Wrapper */
	public static ArrayList<Integer[]> placeQueens(){
		Integer [] board = new Integer[GRID_SIZE];
		ArrayList<Integer[]> results = new ArrayList<Integer[]>();
		placeQueens(0, board, results);
		return results;
	}
	
	/* Main Algo */
	public static void placeQueens(int row, Integer[] board, ArrayList<Integer[]> results){
		if (row == GRID_SIZE)
			results.add((Integer[]) board.clone());	//Tricky knowing we need clone() here. 
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
