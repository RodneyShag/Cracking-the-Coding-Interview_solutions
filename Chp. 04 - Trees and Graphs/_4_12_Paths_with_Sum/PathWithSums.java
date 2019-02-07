package _4_12_Paths_with_Sum;

import java.util.ArrayList;
import common.TreeNode;

// The Big Trick
//
// Instead of checking if a node starts a path that sums to "value", we check if it ENDS a path summing to "value".

public class PathWithSums {
    public static void findSum(TreeNode node, int value) {
        findSum(node, value, new ArrayList<TreeNode>());
    }

    /* Recursive function */
    private static void findSum(TreeNode node, int value, ArrayList<TreeNode> path) {
        if (node == null) {
            return;
        }
        path.add(node);
        checkSums(path, value);
        findSum(node.left, value, path);
        findSum(node.right, value, path);
        path.remove(node); // We have 1 "remove" for each 1 "add"
    }

    /* We sum paths in REVERSE order to see if they equal 'value' */
    private static void checkSums(ArrayList<TreeNode> path, int value) {
        int sum = 0;
        for (int i = path.size() - 1; i >= 0; i--) { // We must loop backwards
            sum += path.get(i).data;
            if (sum == value) {
                printPath(path, i, path.size() - 1);
            }
        }
    }

    private static void printPath(ArrayList<TreeNode> path, int start, int end) {
        System.out.println();
        for (int i = start; i <= end; i++) {
            System.out.print(path.get(i).data + " ");
        }
    }
}

// Time/Space complexities: Assuming BALANCED binary tree
// Time complexity: O(n log(n)) since we touch all "n" nodes, and findSum is O(log n)) in AVERAGE case.
//                  findSum worst case is O((log n)^2) since it may call print every single time,
//                  making overall time complexity worst case O(n (log n)^2)
// Space complexity: O(log n) since that's the max size of a path, and also the max amount of recursive calls on stack.
