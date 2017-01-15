package chapter9;
import java.util.ArrayList;
import java.util.HashMap;

public class NinePoint2 {
	/* number of Paths  - not cached, using x and y */
	public static int numPaths(boolean [][] maze, int x, int y){	//could be caching results here too.
		if (x < 0 || y < 0)
			return 0;
		if (x == 0 && y == 0)
			return 1;
		else
			return numPaths(maze, x-1, y) + numPaths(maze, x, y-1);
	}
	
	/* number of Paths - cached using Points.
	 * Note: Point class now needs overwritten .equals and .hashCode */
	public static int numPaths2(boolean [][] maze, int x, int y){
		HashMap<Point, Integer> cache = new HashMap<Point, Integer>();
		cache.put(new Point(0, 0), 1);
		return numPaths2(maze, new Point(x, y), cache);
		
	}
	public static int numPaths2(boolean [][] maze, Point p, HashMap<Point, Integer> cache){
		if (cache.containsKey(p))
			return cache.get(p);
		if (!isFree(maze, p))
			return 0;
		int numPaths = numPaths2(maze, new Point(p.x - 1, p.y), cache) + numPaths2(maze, new Point(p.x, p.y - 1), cache);
		cache.put(p, numPaths);
		return numPaths;
	}
	
	public static boolean isFree(boolean [][] maze, Point p){
		if (p.x < 0 || p.y < 0 || p.x > maze[0].length || p.y > maze.length)
			return false;
		return maze[p.y][p.x];	//this assumes we set non-walls to true.
	}
	
	/* Solution 1 - find ONE solution path.
	 * Cache alternatives to HashMap: a parallel boolean[][]
	 * Looks like a modified version of DFS. This does the backtrackmap (called path) in a unique way.
	 */
	public static ArrayList<Point> findPath(boolean [][] maze, int x, int y){
		if (maze == null)
			return null;
		ArrayList<Point> path = new ArrayList<Point>();
		HashMap<Point, Boolean> cache = new HashMap<Point, Boolean>();
		cache.put(new Point(0,0), true);
		findPath(maze, x, y, path, cache);
		return path;
	}
	
	public static boolean findPath(boolean [][] maze, int x, int y, ArrayList<Point> path, HashMap<Point, Boolean> cache){
		Point p = new Point(x, y);
		if (cache.containsKey(p))
			return cache.get(p);
		
		boolean success = false;
		if (isFree(maze, x-1, y))
			success = findPath(maze, x-1, y, path, cache);
		if (!success && isFree(maze, x-1, y))
			success = findPath(maze, x, y-1, path, cache);
		if (success)
			path.add(p);
		
		cache.put(p, success);
		return success;
	}
	
	private static boolean isFree(boolean [][] maze, int x, int y){		//can put "walls" in the maze here as problem suggests
		if (x < 0 || y < 0 || y >= maze.length || x >= maze[0].length)
			return false;
		return maze[y][x];	//this assumes we set non-walls to true.
	}
	
	/********************************************/
	/* Follow-up (from website): Find ALL Paths */		//kinda similar to 8-Queens Problem.
	/********************************************/
	public static ArrayList<ArrayList<Point>> allPaths(boolean [][] maze, int x, int y){
		if (maze == null)
			return null;
		ArrayList<ArrayList<Point>> result = new ArrayList<ArrayList<Point>>();
		ArrayList<Point> path = new ArrayList<Point>();
		getAllPaths(maze, x, y, path, result);
		return result;
	}
	
	public static void getAllPaths(boolean [][] maze, int x, int y, ArrayList<Point> path, ArrayList<ArrayList<Point>> result){
		if (!isFree(maze, x, y))
			return;
		Point p = new Point(x, y);
		path.add(p);
		if (x == 0 && y == 0){
			result.add((ArrayList<Point>) path.clone());
			//we do not add a "return" here so that the code will eventually get to "path.remove(p)"
		}
		getAllPaths(maze, x-1, y, path, result);
		getAllPaths(maze, x, y-1, path, result);
		path.remove(p);								//notice there is a 1 remove for the 1 add
	}
}
