package _4_06_Successor;

import common.TreeNode;

// Read book's logic, but ignore its code. The code below is much cleaner.
// - Notice there are 2 distinct cases: "leftMostChild" (easy to code), "properParent" (a little tricky)

public class Successor {
    public static TreeNode inOrderSucc(TreeNode node) {
        if (node.right != null) {
            return leftMostChild(node.right);
        } else {
            return properParent(node);
        }
    }

    private static TreeNode leftMostChild(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode result = node;
        while (result.left != null) {
            result = result.left;
        }
        return result;
    }

    // Finds the parent (well, ancestor) that has treeNode in its left subtree. Returns null if such parent doesn't exist
    private static TreeNode properParent(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode parent = node.parent;
        TreeNode child = node;
        while (parent != null && parent.left != child) {
            child = parent; // crucial step
            parent = child.parent;
        }
        return parent;
    }
}

// Finding Successor of a Node is useful when deleting a node in a binary *search* tree,
// since that's a node we can put in place of the deleted node