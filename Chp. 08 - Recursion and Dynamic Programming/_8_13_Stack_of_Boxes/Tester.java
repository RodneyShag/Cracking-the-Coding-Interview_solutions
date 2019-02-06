package _8_13_Stack_of_Boxes;

import java.util.ArrayDeque;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test 8.13: Stack of Boxes\n");
        ArrayDeque<Box> boxes = new ArrayDeque<>();
        boxes.add(new Box(3, 4, 1));
        boxes.add(new Box(8, 6, 2));
        boxes.add(new Box(4, 8, 3));
        test(boxes);
    }

    private static void test(ArrayDeque<Box> boxes) {
        System.out.println("Original boxes: " + boxes + "\n");
        ArrayDeque<Box> stack = StackOfBoxes.buildTallestStack(boxes);
        System.out.println("Tallest stack:  " + stack);
    }
}
