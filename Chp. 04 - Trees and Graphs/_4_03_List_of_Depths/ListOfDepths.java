// github.com/RodneyShag

package _4_03_List_of_Depths;

import java.util.*;
import common.TreeNode;

public class ListOfDepths {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        ArrayDeque<TreeNode> deque = new ArrayDeque<>(); // use deque as a queue
        deque.add(root);
        while (!deque.isEmpty()) {
            int numNodesInLevel = deque.size();
            List<Integer> level = new ArrayList<>(numNodesInLevel);
            for (int i = 0; i < numNodesInLevel; i++) {
                TreeNode n = deque.remove();
                level.add(n.data);
                if (n.left != null) {
                    deque.add(n.left);
                }
                if (n.right != null) {
                    deque.add(n.right);
                }
            }
            lists.add(level);
        }
        return lists;
    }
}
