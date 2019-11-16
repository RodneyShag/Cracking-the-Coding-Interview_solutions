// github.com/RodneyShag

package _16_14_Best_Line;

import common.Point;
import common.Line;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test 16.9: Best Line\n");
        Point[] points = new Point[4];
        points[0] = new Point(1, 3);
        points[1] = new Point(2, 4);
        points[2] = new Point(3, 5);
        points[3] = new Point(13, 7);

        Line bestLine = BestLine.findBestLine(points);
        System.out.println("\nbestLine:  " + bestLine);
    }
}
