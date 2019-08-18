package _16_04_Tic_Tac_Win;

// Clever Trick: 
//	1) Preprocess all possible boards to create a 1-1 mapping from boards to integers: 0 to maxNumBoards
//	2) Use an array of booleans to indicate which boards are winning boards.

public class TicTacWin {
    private boolean[] winnerMap;

    public static int convertBoardToInt(char[][] board) {
        int sum = 0;
        int factor = 1;
        int dimension = board.length; // assumes square board
        for (int row = 0; row < dimension; row++) {
            for (int col = 0; col < dimension; col++) {
                char ch = board[row][col];
                int value = 0;
                switch (ch) {
                    case ' ':
                        value = 0 * factor;
                        break;
                    case 'o':
                        value = 1 * factor;
                        break;
                    case 'x':
                        value = 2 * factor;
                        break;
                    default: // should not occur
                        break;
                }
                sum += value;
                factor *= dimension;
            }
        }
        return sum;
    }

    public boolean hasWon(int board) {
        return winnerMap[board]; // assuming this array has been filled with proper values
    }
}
