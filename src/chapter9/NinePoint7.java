package chapter9;
/* Standard DFS. Marking stuff as visited is automatically taken care of */
public class NinePoint7 {
	/* Wrapper */
	public static void paintFill(Color [][] screen, int x, int y, Color newColor){
		if (screen == null || newColor == null)
			return;
		paintFill(screen, x, y, screen[y][x], newColor);
	}
	
	public static void paintFill(Color [][] screen, int x, int y, Color oldColor, Color newColor){
		/* Validate Input */
		if (screen == null || oldColor == null || newColor == null)
			return;
		
		/* Base Cases */
		if (x < 0 || x >= screen[0].length || y < 0 || y >= screen.length)
			return;
		
		/* Recursive Case */
		if (screen[y][x] == oldColor){	//this prevents infinite recursion by preventing visits to previous pixels
			screen[y][x] = newColor;
			paintFill(screen, x - 1, y, oldColor, newColor);
			paintFill(screen, x + 1, y, oldColor, newColor);
			paintFill(screen, x, y - 1, oldColor, newColor);
			paintFill(screen, x, y + 1, oldColor, newColor);
		}
	}
}
