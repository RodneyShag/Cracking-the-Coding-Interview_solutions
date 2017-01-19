package chapter4;

import java.util.ArrayList;

public class Practice {
	public static void printPaths(TreeNode node, int value){
		ArrayList<TreeNode> path = new ArrayList<>();
		printPaths(node, value, path);
	}
	
	public static void printPaths(TreeNode node, int value, ArrayList<TreeNode> path){
		if (node == null || path == null)
			return;
		
		path.add(node);
		checkSums(path, value);
		printPaths(node.left,  value, path);
		printPaths(node.right, value, path);
		path.remove(node);
	}
	
	public static void printData(ArrayList<TreeNode> path, int start, int end){
		System.out.println();
		for (int i = start; i <= end; i++){
			System.out.print(path.get(i).data + " ");
		}
	}
	
	public static void checkSums(ArrayList<TreeNode> path, int value){
		if (path == null)
			return;
		int sum = 0;
		int lastIndex = path.size() - 1;
		for (int i = path.size() - 1; i >= 0; i--){
			sum += path.get(i).data;
			if (sum == value)
				printData(path, i, lastIndex);
		}
	}
}
