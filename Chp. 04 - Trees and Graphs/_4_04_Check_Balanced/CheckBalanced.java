package _4_04_Check_Balanced;

import common.TreeNode;

// Algorithm: If subtree at Node is imbalanced, return -1. Otherwise, return height of subtree.

//  Time Complexity: O(n)
// Space Complexity: O(h)

public class CheckBalanced {
    public static boolean isBalanced(TreeNode root) {
        return (isBalancedHelper(root) == -1) ? false : true;
    }

    /* Returns -1 if unbalanced, otherwise returns height of tree from given node */
    private static int isBalancedHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = isBalancedHelper(root.left);
        if (leftHeight == -1) {
            return -1; // left tree is unbalanced
        }

        int rightHeight = isBalancedHelper(root.right);
        if (rightHeight == -1) {
            return -1; // right tree is unbalanced
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // imbalance between the 2 subtrees
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
