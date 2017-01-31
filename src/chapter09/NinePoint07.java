package chapter09;

/* Same as book's code */
public class NinePoint07 {

	public static boolean paintFill(Color [][] screen, int x, int y, Color newColor){
		if (screen == null || newColor == null || screen[y][x] == newColor)
			return false;
		return paintFillRecursive(screen, x, y, screen[y][x], newColor);
	}
	
	private static boolean paintFillRecursive(Color [][] screen, int x, int y, Color oldColor, Color newColor){
		if (x < 0 || x >= screen[0].length || y < 0 || y >= screen.length)
			return false;
		
		if (screen[y][x] == oldColor){
			screen[y][x] = newColor;
			paintFillRecursive(screen, x - 1, y, oldColor, newColor);
			paintFillRecursive(screen, x + 1, y, oldColor, newColor);
			paintFillRecursive(screen, x, y - 1, oldColor, newColor);
			paintFillRecursive(screen, x, y + 1, oldColor, newColor);
		}
		return true;
	}
}
