// github.com/RodneyShag

package _8_10_Paint_Fill;

/* Same as book's code */
public class PaintFill {
    public static boolean paintFill(Color[][] screen, int x, int y, Color newColor) {
        if (screen == null || newColor == null || screen[y][x] == newColor) {
            return false;
        }
        return paintFillRecursive(screen, x, y, newColor, screen[y][x]);
    }

    private static boolean paintFillRecursive(Color[][] screen, int x, int y, Color newColor, Color oldColor) {
        if (x < 0 || x >= screen[0].length || y < 0 || y >= screen.length) {
            return false;
        }

        if (screen[y][x] == oldColor) {
            screen[y][x] = newColor;
            paintFillRecursive(screen, x - 1, y, newColor, oldColor);
            paintFillRecursive(screen, x + 1, y, newColor, oldColor);
            paintFillRecursive(screen, x, y - 1, newColor, oldColor);
            paintFillRecursive(screen, x, y + 1, newColor, oldColor);
        }
        return true;
    }
}
