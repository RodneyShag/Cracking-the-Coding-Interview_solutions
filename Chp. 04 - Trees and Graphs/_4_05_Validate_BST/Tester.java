package _4_05_Validate_BST;

import common.TreeNode;
import common.TreeFunctions;

public class Tester {
	public static void main(String[] args) {
		System.out.println("*** Test 4.5: Validate BST\n");
		TreeNode tree1 = TreeFunctions.createTree();
		test(tree1); // should be false
		TreeNode tree2 = TreeFunctions.createBST();
		test(tree2); // should be true
	}
	
	private static void test(TreeNode tree) {
		System.out.println("is BST?: " + ValidateBST.isBST(tree));
	}
}
