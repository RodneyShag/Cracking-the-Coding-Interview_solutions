package _4_08_First_Common_Ancestor;

import common.TreeNode;

// Find common ancestor
//
// Solutions                  Runtime                   Preference
// ---------------------------------------------------------------
// 0) If BST, trace Paths     O(log n) if balanced      Clever
// 1) Use links to parents    O(log n) if balanced      Clever
// 2) Recursive               O(n)                      Favorite

public class FirstCommonAncestor {
    /* Solution 0: If Binary Search Tree, can go down the tree from the root to see where we need to diverge paths */

    /* Book Solution 1: If we have links to parents, we can save all of node1's parents (ancestors) in a HashSet
     *                  and then see if node2's parents (ancestors) match any of those */

    /* Solution 2 - from: http://www.programcreek.com/2014/07/leetcode-lowest-common-ancestor-of-a-binary-tree-java/ */
    public static TreeNode commonAnc(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        } else if (root == p || root == q) {
            return root;
        }

        TreeNode left = commonAnc(root.left, p, q);
        TreeNode right = commonAnc(root.right, p, q);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }
}
