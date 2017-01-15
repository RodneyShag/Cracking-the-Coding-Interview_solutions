package chapter17;

public class SeventeenPoint2 {
	/* Clever Trick: Preprocessing all possible boards (by treating board as an "int") (See book for explanation)
	 * - Then can have an array (that acts as a HashMap) where each index is the key, and value is "who won". (Not shown in code below)
	 */
	
	/*public int hasWon(int board) {
		return winnerHashtable[board];
	}*/
	
	//Can view this as a 1-to-1 mapping from boards to Integers, so that the Integer can be used as a key in a HashMap (we use array)
	public static int convertBoardToInt(char[][] board){
		int factor = 1;
		int sum = 0;
		for (int i = 0; i < board.length; i++){
			for (int j = 0; j < board[0].length; j++){
				int value = 0;
				if (board[i][j] == 'x')
					value = 1;
				else if (board[i][j] == 'o')
					value = 2;
				sum += factor * value;
				factor *= 3;
			}
		}
		return sum;
	}
	
	/* Solution 2, 3 - The 3x3 and NxN solution are trivial (no need to code)
	 * - Board is an array of "Piece"s
	 * - Just check 3 rows, 3 columns, and 2 diagonals. 
	 * - if NxN board, I should still be able to code it w/o problems.
	 */
}
