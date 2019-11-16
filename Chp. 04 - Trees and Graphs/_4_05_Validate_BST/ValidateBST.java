// github.com/RodneyShag

package _4_05_Validate_BST;

import common.TreeNode;

public class ValidateBST {
    public static boolean isBST(TreeNode root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBST(TreeNode node, int min, int max) {
        if (node == null) {
            return true;
        }
        if (node.data <= min || node.data > max) { // tricky off-by-one errors for duplicates. Tricky whether it's <, <=, >, >=
            return false;
        }
        return isBST(node.left, min, node.data) && isBST(node.right, node.data, max);
    }
}

//  Time Complexity: O(n) since we visit every node
// Space Complexity: O(log n) if tree is balanced, O(n) otherwise, since that's the depth of the recursion
