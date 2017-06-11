package _16_14_Best_Line;

import java.util.HashMap;
import common.Point;
import common.Line;

// I coded it differently than book. Tricks:
// 1) Overridden .equals(Object o) and .hashCode() methods (so HashMap will work). 
// 2) Like book, use 2 nested loops to loop through pairs of points, creating lines, but instead insert them into a HashMap<Line, Integer> 
// 3) Loop through HashMap to see which line was most popular.

// Mistakes or unnecessary things book does:
// 1) Uses a Double as their hash key ( == is not properly defined for Doubles )
//    Uses a HashMap<double, ArrayList<Line>>, hashing the slopes, instead of the Lines themselves.
// 2) Searches their HashMap at three spots: flooredSlope, flooredSlope - epsilon, and flooredSlope + epsilon

public class BestLine {
	public static Line findBestLine(Point[] points) {
		int numPoints = points.length;
		HashMap<Line, Integer> map = new HashMap<>();
		
		/* Put lines into HashMap */
		for (int i = 0; i < numPoints - 1; i++) {
			for (int j = i + 1; j < numPoints; j++) {
				Line line = new Line(points[i], points[j]);
				System.out.println(line); // for error checking
				map.merge(line, 1, Integer::sum);
			}
		}
		
		/* Count which line is most popular */
		int max = 0;
		Line bestLine = null;
		for (Line line : map.keySet()) {
			int value = map.get(line);
			if (value >= max) {
				max = map.get(line);
				bestLine = line;
			}
		}
		return bestLine;
	}
}
