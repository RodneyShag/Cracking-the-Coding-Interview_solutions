package _4_10_Check_Subtree;

import common.TreeNode;

public class CheckSubtree {

    public static boolean containsTree(TreeNode t1, TreeNode t2) {
        if (t2 == null) { // the empty tree is always a subtree. We do this 
                          // check here to avoid doing it every time in subTree.
            return true;
        }
        return subTree(t1, t2);
    }

    public static boolean subTree(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return false;
        }

        if (matchTree(t1, t2)) {
            return true;
        }

        return subTree(t1.left, t2) || subTree(t1.right, t2);
    }

    public static boolean matchTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        if (p.data != q.data) {
            return false;
        }
        return matchTree(p.left, q.left) && matchTree(p.right, q.right);
    }
}

// Runtimes: 
// Let t1 have n nodes and t2 have m nodes
//
// Time Complexity: 
// - O(nm) worst case, but average case is much better since matchTree() usually returns 
//   false immediately, so it's O(n + km) where k is number of occurrences of T2's root in T1
// - Also, even when we do call matchTree, it is likely to not match very soon in its search
//
// Space Complexity: O(log(n) + log(m)). Which is great.
