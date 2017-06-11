package _17_23_Max_Black_Square;

public class Cell {
	public int blacksRight = 0; // including itself
	public int blacksDown  = 0; // including itself
	
	public Cell(int right, int below) {
		blacksRight = right;
		blacksDown  = below;
	}
}
