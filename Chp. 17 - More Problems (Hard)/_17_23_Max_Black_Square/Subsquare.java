package _17_23_Max_Black_Square;

public class Subsquare {
	 int row;
	 int col;
	 int length;
     
	 public Subsquare(int r, int c, int l) {
		 row    = r;
		 col    = c;
		 length = l;
	 }
	 
	 @Override
	 public String toString() {
		 return "row = " + row + "  col = " + col + "  length = " + length;
	 }
}
