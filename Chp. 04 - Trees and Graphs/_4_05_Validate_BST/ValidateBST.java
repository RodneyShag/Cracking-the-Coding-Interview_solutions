package _4_05_Validate_BST;

import common.TreeNode;

//  Time Complexity: O(n)     - since we visit every node
// Space Complexity: O(log n) - that's the depth of the recursion

public class ValidateBST {
    public static boolean isBST(TreeNode root) {
        return isBST_Helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBST_Helper(TreeNode node, int min, int max) {
        if (node == null) {
            return true;
        }
        if (node.data <= min || node.data > max) { // tricky off-by-one errors for duplicates. Tricky whether it's <, <=, >, >=
            return false;
        }
        return isBST_Helper(node.left, min, node.data) && isBST_Helper(node.right, node.data, max);
    }
}
