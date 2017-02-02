package chapter18;

public class Subsquare {
	 int col;
	 int row;
	 int length;
     
	 public Subsquare(int r, int c, int l) {
		 row    = r;
		 col    = c;
		 length = l;
	 }
	 
	 @Override
	 public String toString(){
		 return "row = " + row + "  col = " + col + "  length = " + length;
	 }
}
