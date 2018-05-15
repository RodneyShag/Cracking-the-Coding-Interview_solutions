package _4_10_Check_Subtree;

import common.TreeNode;
import common.TreeFunctions;

public class Tester {
	public static void main(String[] args) {
		System.out.println("*** Test 4.10: subTree\n");
		TreeNode tree1 = TreeFunctions.createTree();
		TreeNode tree2 = TreeFunctions.createBST();
		TreeNode tree3 = new TreeNode(5);
		System.out.println("Contains tree? (should be false): " + CheckSubtree.containsTree(tree1, tree2));
		System.out.println("Contains tree? (should be false): " + CheckSubtree.containsTree(tree1, tree3));
		System.out.println("Contains tree? (should be true): " + CheckSubtree.containsTree(tree1, tree1));
	}
}
