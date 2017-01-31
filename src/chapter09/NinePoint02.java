package chapter09;

import java.util.ArrayList;
import java.util.HashMap;

/* Number of ways to get from (0,0) to (x,y) in a grid (assuming no backwards moves)
 * 
 * Solutions            Runtime        Space          Preference
 * -------------------------------------------------------------
 * 1) Mathematical      NA             NA       
 * 2) Iterative         O(rows*cols)   O(rows*cols)   Favorite
 * 
 * Follow-up: (In a maze with walls) Discover 1 solution path
 * Follow-up: (In a maze with walls) Discover all solution paths
 */
public class NinePoint02 {

	/* Solution 1 -  (x+y)!     <-- Math solution (from book) : (x+y) moves total, choose x of them to go right
	 *              --------
	 *              (x!)(y!)
	 */

	/* Solution 2 */
	public static int numPaths(int columns, int rows){
		int [][] paths = new int[rows][columns];
		
		/* Base cases */
		for (int row = 0; row < rows; row++){
			paths[row][0] = 1;
		}
		for (int col = 0; col < columns; col++){
			paths[0][col] = 1;
		}
		
		/* "Recursive" cases, although we don't use recursion */
		for (int row = 1; row < rows; row++){
			for (int col = 1; col < columns; col++){
				paths[row][col] = paths[row-1][col] + paths[row][col-1];
			}
		}
		return paths[rows - 1][columns - 1];
	}
	
	/*************************************************/
	/* Follow-up question:- find ONE solution path.  */
	/*************************************************/
	
	/* The reason we use a HashMap as a cache instead of an int[][] is because HashMap can give us 3 pieces of information:
	 * 1) haven't cached yet (we know this if the HashMap does not contain the key)
	 * 2) Cached - path exists
	 * 3) Cached - path doesn't exist
     */
	public static ArrayList<Point> findPath(final boolean [][] maze, int row, int column){
		if (maze == null || row >= maze.length || column >= maze[0].length)
			return null;
		
		/* Create path to save solution into */
		ArrayList<Point> path = new ArrayList<Point>();
		path.add(new Point(0,0));
		
		/* Create cache to save solutions to subproblems */
		HashMap<Point, Boolean> cache = new HashMap<>(); // requires overriding .equals() and .hashCode for Point, for HashMap to work properly
		cache.put(new Point(0,0), true); // base case
		
		/* Recursively calculate answer */
		boolean foundResult = findPath(maze, row, column, path, cache);
		if (foundResult)
			return path;
		else
			return null;
	}
	
	private static boolean findPath(final boolean [][] maze, int row, int column, ArrayList<Point> path, HashMap<Point, Boolean> cache){
		Point p = new Point(column, row);
		if (cache.containsKey(p)) // here so that we don't recompute subproblems that we already solved
			return cache.get(p); // since nobody is going to alter the Point p, no need to do a deep copy before returning cached result
		
		if(!isFree(maze, row, column))
			return false;
		
		/* Find paths recursively. Tricky to remember to only search the 2nd path if necessary */
		boolean success = findPath(maze, row, column - 1, path, cache);
		if (!success)
			success = findPath(maze, row - 1, column, path, cache); // if no success, we try moving vertically
		
		cache.put(p, success); // update cache

		/* Update path if we found a solution */
		if (success)
			path.add(p);
		
		return success;
	}
	
	/* A spot is free if it's within maze bounds and is not a wall */
	private static boolean isFree(boolean [][] maze, int row, int column){
		if (row < 0 || row >= maze.length || column < 0 || column >= maze[0].length)
			return false;
		return maze[row][column];
	}
	
	/********************************************/
	/* Follow-up (from website): Find ALL Paths */		// kinda similar to 8-Queens Problem.
	/********************************************/
	// no point in caching results since we have to try all paths
	public static ArrayList<ArrayList<Point>> allPaths(boolean [][] maze, int row, int column){
		if (maze == null || row >= maze.length || column >= maze[0].length)
			return null;

		ArrayList<Point> path = new ArrayList<Point>();
		
		ArrayList<ArrayList<Point>> solutionPaths = new ArrayList<ArrayList<Point>>();
		
		getAllPaths(maze, row, column, path, solutionPaths);
		return solutionPaths;
	}
	
	public static void getAllPaths(boolean [][] maze, int row, int column, ArrayList<Point> path, ArrayList<ArrayList<Point>> solutionPaths){
		if (!isFree(maze, row, column))
			return;
		Point p = new Point(column, row);
		path.add(p);
		if (row == 0 && column == 0){
			/* Shallow copy would give us the correct solution too but each ArrayList<Point> in solutionPaths would
            contain Points that are references to other Points in a different ArrayList<Point> in solutionsPaths */
			deepCopyPathIntoSolutions(path, solutionPaths);
			// we do not add a "return" here so that the code will eventually get to "path.remove(p)"
		}
		getAllPaths(maze, row, column - 1, path, solutionPaths);
		getAllPaths(maze, row - 1, column, path, solutionPaths);
		path.remove(p);								// notice there is exactly 1 .remove() since we had exactly 1 .add()
	}
	
	private static void deepCopyPathIntoSolutions(ArrayList<Point> path, ArrayList<ArrayList<Point>> solutionPaths)	{
		ArrayList<Point> solutionPath = new ArrayList<>();
		for (int i = path.size()-1; i >= 0; i--){ // I reverse the order of the path here since we stored it backwards
			Point point = path.get(i);
			solutionPath.add(new Point(point.x, point.y));
		}
		solutionPaths.add(solutionPath);
	}
}
