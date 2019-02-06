package _16_03_Intersection;

import common.Point;
import common.Line;
import common.LineFunctions;

public class Tester {

    public static void main(String[] args) {
        System.out.println("*** Test 16.3: Intersection\n");

        Line line1 = new Line(new Point(2, 0), new Point(2, 3));
        Line line2 = new Line(new Point(2, 5), new Point(2, 7));
        Line line3 = new Line(new Point(1, 2), new Point(3, 3));
        Line line4 = new Line(new Point(2, 3), new Point(4, 4));

        System.out.println("Lines intersect? (should be true):  " + LineFunctions.intersect(line1, line2));
        System.out.println("Lines intersect? (should be true):  " + LineFunctions.intersect(line1, line3));
        System.out.println("Lines intersect? (should be true):  " + LineFunctions.intersect(line1, line4));
        System.out.println("Lines intersect? (should be true):  " + LineFunctions.intersect(line2, line3));
        System.out.println("Lines intersect? (should be true):  " + LineFunctions.intersect(line2, line4));
        System.out.println("Lines intersect? (should be false): " + LineFunctions.intersect(line3, line4) + "\n");

        System.out.println("Lines intersect? (should be true):  " + LineFunctions.sameLine(line1, line2));
        System.out.println("Lines intersect? (should be false): " + LineFunctions.sameLine(line1, line3));
        System.out.println("Lines intersect? (should be false): " + LineFunctions.sameLine(line1, line4));
        System.out.println("Lines intersect? (should be false): " + LineFunctions.sameLine(line2, line3));
        System.out.println("Lines intersect? (should be false): " + LineFunctions.sameLine(line2, line4));
        System.out.println("Lines intersect? (should be false): " + LineFunctions.sameLine(line3, line4));
    }
}
