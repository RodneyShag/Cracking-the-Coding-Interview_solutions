package _4_10_Check_Subtree;

import common.TreeNode;

public class CheckSubtree {
    public static boolean containsTree(TreeNode t1, TreeNode t2) {
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        
        getPreorder(t1, sb1);
        getPreorder(t2, sb2);
        
        return sb1.indexOf(sb2.toString()) != -1;
    }

    private static void getPreorder(TreeNode node, StringBuffer sb) {
        if (node == null) {
            sb.append("X");          // Add X representing null
            return;
        }
        sb.append("#" + node.data);  // Add separator and root 
        getPreorder(node.left, sb);  // Add left
        getPreorder(node.right, sb); // Add right
    }
}

//  Time Complexity: O(m + n) if we can assume .indexOf() uses KMP algorithm.
// Space Complexity: O(m + n)
