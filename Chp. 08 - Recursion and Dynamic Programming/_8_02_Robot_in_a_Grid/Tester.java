package _8_02_Robot_in_a_Grid;

import java.util.ArrayList;

public class Tester {
	public static void main(String[] args) {
		test_RobotsInAGrid();
		test_FindOnePath();
		test_FindAllPaths();
	}
	
	private static void test_RobotsInAGrid() {
		System.out.println("*** Test 8.2: Robots in a Grid\n");
		test_RobotsInAGridHelper(1, 1);
		test_RobotsInAGridHelper(2, 2);
		test_RobotsInAGridHelper(3, 3);
	}
	
	private static void test_RobotsInAGridHelper(int rows, int cols) {
		System.out.format("Number of Paths in %dx%d maze = %d%n" , rows, cols, RobotInAGrid.numPaths(rows, cols));
	}
	
	private static void test_FindOnePath() {
		System.out.println("\n\n*** Test Follow-up: Find 1 Path");
		boolean[][] maze = createMaze(3, 3);
		
		/* Find and print solution */
		ArrayList<Point> path = RobotInAGrid.findPath(maze, 2, 2);
		System.out.print("\nOld Path: " + path);
		
		/* Add walls to block the original solution path, to see if it will find a different solution */
		maze[1][1] = false;
		maze[2][1] = false;
		
		/* Find and print solution */
		path = RobotInAGrid.findPath(maze, 2, 2);
		System.out.print("\nNew Path: " + path);
	}
	
	private static void test_FindAllPaths() {
		System.out.println("\n\n\n*** Test Follow-up: Find All Paths\n");
		boolean[][] maze = createMaze(3, 3);
		ArrayList<ArrayList<Point>> solutionPaths = RobotInAGrid.allPaths(maze, 2, 2);
		printAllPaths(solutionPaths);
	}
	
	private static boolean[][] createMaze(int rows, int cols) {
		boolean[][] maze = new boolean[rows][cols];
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				maze[row][col] = true;
			}
		}
		return maze;
	}
	
	private static void printAllPaths(ArrayList<ArrayList<Point>> solutionPaths) {
		if (solutionPaths != null) {
			for (ArrayList<Point> path : solutionPaths) {
				System.out.println(path);
			}
		}
	}
}
