package _4_02_Minimal_Tree;

import common.TreeNode;
import common.TreeFunctions;

public class Tester {
	public static void main(String[] args) {
		System.out.println("*** Test 4.2: Minimal Tree\n");
		int[] sortedArray = {1, 2, 3, 4, 5, 6, 7};
		TreeNode BST = MinimalTree.createBST(sortedArray);
		System.out.print("In-Order print of tree: ");
		TreeFunctions.printInOrder(BST);
	}
}
