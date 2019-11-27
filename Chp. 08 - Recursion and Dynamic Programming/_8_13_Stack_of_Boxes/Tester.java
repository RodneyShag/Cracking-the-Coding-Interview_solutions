// github.com/RodneyShag

package _8_13_Stack_of_Boxes;

import java.util.*;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test 8.13: Stack of Boxes\n");
        List<Box> boxes = new LinkedList();
        boxes.add(new Box(3, 4, 1));
        boxes.add(new Box(8, 6, 2));
        boxes.add(new Box(4, 8, 3));
        test(boxes);
    }

    private static void test(List<Box> boxes) {
        System.out.println("Original boxes: " + boxes + "\n");
        int height = StackOfBoxes.findMaxHeight(boxes);
        System.out.println("Height of tallest stack: " + height);
    }
}
