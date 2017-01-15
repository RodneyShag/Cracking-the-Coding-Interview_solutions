package chapter7;
import java.util.HashMap;

/* 7.6 - Clever Algorithm! The algorithm is the important part. I did it slightly differently than book. Tricks:
 * 0) "Line" representation is important. Class has "y-intercept", "slope", "infinite_slope".  Also have
 * 		- Use epsilon = 0.0001 and floor all doubles to nearest epsilon (see clever trick in code, from book)
 *    	- constructor using 2 "Point"s as input.
 *    	- overridden .equals(Object o) and .hashCode() methods (so HashMap will work). 
 * 1) Like book, use 2 nested loops to loop through pairs of points, creating lines, but insert them into a HashMap<Line, Integer> 
 * 2) Loop through HashMap to see which line was most popular.
 * 
 * 
 * Dumb/Annoying Things book does:
 * 1) searches their HashMap at three spots: flooredSlope, flooredSlope - epsilon, and flooredSlope + epsilon
 * 2) Uses a HashMap<double, ArrayList<Line>>, hashing the slopes, instead of the Lines themselves.
 */
public class SevenPoint6 {
	public static Line findBestLine(Point [] points){
		int numPoints = points.length;
		HashMap<Line, Integer> map = new HashMap<Line, Integer>();
		
		/* Put lines into HashMap */
		for (int i = 0; i < numPoints - 1; i++){
			for (int j = i + 1; j < numPoints; j++){
				Line line = new Line(points[i], points[j]);	//here for error checking
				System.out.println("Line:   Slope = " + line.slope + "   Intercept = " + line.intercept);
				if (map.containsKey(line))
					map.put(line, map.get(line) + 1);	//this is the correct way to update a value. It will overwrite it.				
				else
					map.put(line, 1);
			}
		}
		
		/* Count which line is most popular */
		int max = 0;
		Line bestLine = null;
		for (HashMap.Entry<Line, Integer> entry : map.entrySet()){				//Nowadays I use map.keySet()
			Line key = entry.getKey();
			int value = entry.getValue();
			if (value > max){
				max = value;
				bestLine = key;
			}
		}
		return bestLine;
	}
}
