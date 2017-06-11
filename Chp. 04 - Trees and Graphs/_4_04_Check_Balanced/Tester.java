package _4_04_Check_Balanced;

import common.TreeNode;
import common.TreeFunctions;

public class Tester {
	public static void main(String[] args) {
		System.out.println("*** Test 4.4: Check Balanced\n");
		TreeNode tree = TreeFunctions.createBST();
		test(tree);
	}
	
	private static void test(TreeNode tree) {
		System.out.println("Tree balanced?: " + CheckBalanced.isBalanced(tree));
	}
}
