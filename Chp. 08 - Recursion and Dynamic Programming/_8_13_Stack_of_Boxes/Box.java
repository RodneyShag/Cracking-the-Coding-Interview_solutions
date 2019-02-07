package _8_13_Stack_of_Boxes;

/* Used in 9.10 */
public class Box {
    int width;
    int height;
    int depth;

    /* Constructor */
    Box(int w, int h, int d) {
        width  = w;
        height = h;
        depth  = d;
    }

    /* Constructor */
    Box(Box other) {
        width  = other.width;
        height = other.height;
        depth  = other.depth;
    }

    /* A box can be placed on 1) an empty platform (that's what the "other == null" is for), or 2) a bigger box (in every dimension) */
    public boolean canPlaceAbove(Box other) {
        return (other == null) || (width < other.width && height < other.height && depth < other.depth);
    }
	
    /* Book didn't have these 2 functions. I think they're needed so Boxes can be hashed correctly */

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        } else if (other == null || !(other instanceof Box)) {
            return false;
        }
        Box otherBox = (Box) other;
        return width == otherBox.width && height == otherBox.height && depth == otherBox.depth;
    }

    @Override
    public int hashCode() {
        return 2 * width + 3 * height + 5 * depth;
    }

    @Override
    public String toString() {
        return "Box (" + width + "," + height + "," + depth + ")";
    }
}
